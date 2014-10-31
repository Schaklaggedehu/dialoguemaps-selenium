package dialoguemaps.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.InterActionWindow;
import dialoguemaps.pageelements.MainMenu;
import dialoguemaps.pageelements.MapMenu;
import dialoguemaps.pageelements.PenWindow;
import dialoguemaps.pageelements.ZoomWindow;

/**
 * 
 * @author janis
 */
public class PageElementCreator extends AbstractPage<DMPage> {

	PageElementCreator(WebDriver driver, By pageLocator) {
		super(driver, pageLocator);
	}

	public void sleepXseconds(final long seconds) {
		try {
			System.out.println("!DEBUG ONLY! Start sleeping for " + seconds
					+ " seconds. !DEBUG ONLY!");
			System.out.println("!DEBUG ONLY! Start sleeping for " + seconds
					+ " seconds. !DEBUG ONLY!");
			System.out.println("!DEBUG ONLY! Start sleeping for " + seconds
					+ " seconds. !DEBUG ONLY!");
			System.out.println("!DEBUG ONLY! Start sleeping for " + seconds
					+ " seconds. !DEBUG ONLY!");
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
		}
	}
	
	public void logIntoMainpage(String name, String password) {
		WebElement nameField = findElement(By.cssSelector("#isc_P"));
		nameField.sendKeys(name);
		nameField.submit();
		WebElement passwordField = findElement(By.cssSelector("#isc_S"));
		passwordField.sendKeys(password);
		passwordField.submit();
		WebElement signIn = findElement(By.cssSelector("#isc_1E"));
		signIn.click();
	}
	
	protected InterActionWindow getInteractionWindow() {
		if (isVisible(By.cssSelector("#isc_K1"))) {
			WebElement interactionWindow = findElement(By
					.cssSelector("#isc_K1"));
			List<WebElement> interactionButtons = findElements(By
					.cssSelector("#isc_K1>*>*>*>*>*>*>*>*>*>*>*>img"));
			return InterActionWindow.getInterActionWindow(interactionWindow, interactionButtons);
		} else {
			return InterActionWindow.getInterActionWindow(null, null);
		}
	}
	
	protected PenWindow getPenWindow(){
		if(isVisible(By.cssSelector("#isc_9P"))){
			WebElement penWindow = findElement(By.cssSelector("#isc_9P"));
			List<WebElement> penButtons = findElements(By.cssSelector("#isc_9P>*>*>*>*>*>*>*>img"));
			return PenWindow.getPenWindow(penWindow, penButtons);
		} else{
			return PenWindow.getPenWindow(null, null);
		}
	}

	protected ZoomWindow getZoomWindow() {
		if (isVisible(By.cssSelector("#isc_92"))) {
			WebElement zoomWindow = findElement(By.cssSelector("#isc_92"));
			List<WebElement> zoomButtons = findElements(By
					.cssSelector("#isc_92>*>*>*>img"));
			zoomButtons.addAll(findElements(By
					.cssSelector("#isc_92>*>*>*>*>*>img")));
			zoomButtons.add(findElement(By
					.cssSelector("#isc_92>*>*>*>*>*>*>*>img")));
			zoomButtons.remove(0);
			return ZoomWindow.getZoomWindow(zoomWindow, zoomButtons);
		} else {
			return ZoomWindow.getZoomWindow(null, null);
		}
	}

	protected MainMenu getMainMenu() {
		if (isVisible(By.cssSelector("#isc_FW"))) {
			WebElement mainMenu = findElement(By.cssSelector("#isc_FW"));
			List<WebElement> mainMenuButtons = findElements(By
					.cssSelector("#isc_FW>*>*>*>img"));
			return MainMenu.getMainMenu(mainMenu, mainMenuButtons);
		} else {
			return MainMenu.getMainMenu(null, null);
		}
	}
	
	protected MapMenu getMapMenu() {
		if (isVisible(By.cssSelector("#isc_H8"))) {
			WebElement mapMenu = findElement(By.cssSelector("#isc_H8"));
			List<WebElement> mapMenuButtons = findElements(By
					.cssSelector("#isc_H8>*>*>*>img"));
			return MapMenu.getMapMenu(mapMenu, mapMenuButtons);
		} else {
			return MapMenu.getMapMenu(null, null);
		}
	}
}
