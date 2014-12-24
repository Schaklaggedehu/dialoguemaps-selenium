package dialoguemaps.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dialoguemaps.pageelements.DialogueMapAdapter;
import dialoguemaps.tools.PropertyReader;

abstract class AbstractPage<T> {

	protected final String _urlPath;
	private final By _pageLocator;
	private final static int WAIT_TIMEOUT = 30;
	protected final WebDriver _driver;

	AbstractPage(final WebDriver driver, final By pageLocator) {
		_driver = driver;
		_pageLocator = pageLocator;

		Properties prop = PropertyReader.load();
		_urlPath = prop.getProperty("website");

	}

	public void open() {
		_driver.get(_urlPath);
		waitUntilPageLoaded();
	}

	public boolean isOpen() {
		try {
			waitUntilPageLoaded();
			return _driver.findElement(_pageLocator).isDisplayed();
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}

	public void reload() {
		_driver.navigate().refresh();
		waitUntilPageLoaded();
	}

	protected boolean waitUntilVisible(final By locator) {
		if(locator==null){
			return false;
		}
			try {
				new WebDriverWait(_driver, WAIT_TIMEOUT).until(ExpectedConditions
						.visibilityOfElementLocated(locator));
				return true;
			} catch (Exception e) {
				return false;
			}			
		
	}
	
	protected boolean waitUntilTextPresent(final WebElement element, String text, int timeout) {
		if(element==null){
			return false;
		}
		try {
			new WebDriverWait(_driver, timeout).until(ExpectedConditions
					.textToBePresentInElement(element, text));
			return true;
		} catch (Exception e) {
			return false;
		}			
		
	}
	protected boolean waitUntilVisible(final WebElement locator) {
		if(locator==null){
			return false;
		}
		try {
			new WebDriverWait(_driver, WAIT_TIMEOUT).until(ExpectedConditions
					.visibilityOf(locator));
			return true;
		} catch (Exception e) {
			return false;
		}			
	}
	protected boolean waitUntilClickable(final WebElement element) {
		if(element==null){
			return false;
		}
		try {
			new WebDriverWait(_driver,WAIT_TIMEOUT).
			                  until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(Exception e){
			return false;
		}		
	}
	protected boolean waitUntilInvisibilityOfElementLocated(final By locator) {
		if(locator==null){
			return false;
		}
		try {
			new WebDriverWait(_driver,WAIT_TIMEOUT).
			until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return true;
		}catch(Exception e){
			return false;
		}		
	}

	protected void waitUntilVisible(final By locator,
			final long timeoutInSeconds) {
		new WebDriverWait(_driver, timeoutInSeconds).until(ExpectedConditions
				.visibilityOfElementLocated(locator));
	}

	public void waitUntilPageLoaded() {
		waitUntilDocumentReadyStateIsComplete();
		waitUntilVisible(_pageLocator);
	}

	/**
	 * uses JavaScript to check for the readyState of the document
	 * https://developer.mozilla.org/en-US/docs/Web/API/document.readyState
	 */
	protected void waitUntilDocumentReadyStateIsComplete() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(final WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(_driver, WAIT_TIMEOUT);
		try {
			wait.until(expectation);
		} catch (Exception error) {
			String currentState = (String) ((JavascriptExecutor) _driver)
					.executeScript("return document.readyState");
			assertThat(
					"Timeout while waiting for document.readyState='complete'. Current state is: "
							+ currentState, true, is(false));
		}
	}

	protected boolean hasPageElement(final By by) {
		return !_driver.findElements(by).isEmpty();
	}

	protected boolean isVisible(final By by) {
		if (hasPageElement(by)) {
			WebElement element = findElement(by);
			return element.isDisplayed();
		} else {
			return false;
		}
	}

	public WebElement findElement(final By by) {
		return _driver.findElement(by);
	}

	public List<WebElement> findElements(final By by) {
		return _driver.findElements(by);
	}

	public String getSource() {
		return _driver.getPageSource();
	}
	public void waitUntilNewDrawElementsCreated(int sizeAfter, DialogueMapAdapter dialogueMap) {
		for (int i = 0; i < WAIT_TIMEOUT; i++) {
			if (dialogueMap.getAllDrawElements().size() == sizeAfter) {
				break;
			}
			sleep(1);
		}
	}
	private void sleep(final long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
		}
	}
}