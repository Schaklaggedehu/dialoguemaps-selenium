package dialoguemaps.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.InterActionWindow;
import dialoguemaps.pageelements.MainMenu;
import dialoguemaps.pageelements.MapMenu;
import dialoguemaps.pageelements.PageElement;
import dialoguemaps.pageelements.PenWindow;
import dialoguemaps.pageelements.ZoomWindow;

/**
 * 
 * @author janis
 */
public class PageElementCreator extends AbstractPage<DMPage> {

	MainMenu _mainMenu;
	MapMenu _mapMenu;
	InterActionWindow _interactionWindow;
	PenWindow _penWindow;
	ZoomWindow _zoomWindow;
	private static Set<PageElement> _pageElements = new HashSet<>();

	PageElementCreator(WebDriver driver, By pageLocator) {
		super(driver, pageLocator);
	}

	public static void clearAllMenusAndWindows() {
		for (PageElement pageElement : _pageElements) {
			pageElement.clear();
		}
	}
	
	public void sleepXseconds(final long seconds) {
		for (int i = 0; i < 8; i++) {
			System.out.println("!DEBUG ONLY! Start sleeping for " + seconds + " seconds. !DEBUG ONLY!");
		}
		try {
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
		InterActionWindow window;
		if (isVisible(By.cssSelector("#isc_K1"))) {
			WebElement interactionWindow = findElement(By.cssSelector("#isc_K1"));
			List<WebElement> interactionButtons = findElements(By.cssSelector("#isc_K1>*>*>*>*>*>*>*>*>*>*>*>img"));
			window = InterActionWindow.getInterActionWindow(interactionWindow, interactionButtons);
		} else {
			window = InterActionWindow.getInterActionWindow(null, null);
		}
		_pageElements.add(window);
		return window;
	}

	protected PenWindow getPenWindow() {
		PenWindow window;
		if (isVisible(By.cssSelector("#isc_9P"))) {
			WebElement penWindow = findElement(By.cssSelector("#isc_9P"));
			List<WebElement> penButtons = findElements(By.cssSelector("#isc_9P>*>*>*>*>*>*>*>img"));
			window = PenWindow.getPenWindow(penWindow, penButtons);
		} else {
			window = PenWindow.getPenWindow(null, null);
		}
		_pageElements.add(window);
		return window;
	}

	protected ZoomWindow getZoomWindow() {
		ZoomWindow window;
		if (isVisible(By.cssSelector("#isc_92"))) {
			WebElement zoomWindow = findElement(By.cssSelector("#isc_92"));
			List<WebElement> zoomButtons = findElements(By.cssSelector("#isc_92>*>*>*>img"));
			zoomButtons.addAll(findElements(By.cssSelector("#isc_92>*>*>*>*>*>img")));
			zoomButtons.add(findElement(By.cssSelector("#isc_92>*>*>*>*>*>*>*>img")));
			zoomButtons.remove(0);
			window = ZoomWindow.getZoomWindow(zoomWindow, zoomButtons);
		} else {
			window = ZoomWindow.getZoomWindow(null, null);
		}
		_pageElements.add(window);
		return window;
	}

	protected MainMenu getMainMenu() {
		MainMenu menu;
		if (isVisible(By.cssSelector("#isc_FW"))) {
			WebElement mainMenu = findElement(By.cssSelector("#isc_FW"));
			List<WebElement> mainMenuButtons = findElements(By.cssSelector("#isc_FW>*>*>*>img"));
			menu = MainMenu.getMainMenu(mainMenu, mainMenuButtons);
		} else {
			menu = MainMenu.getMainMenu(null, null);
		}
		_pageElements.add(menu);
		return menu;
	}

	protected MapMenu getMapMenu() {
		MapMenu menu;
		if (isVisible(By.cssSelector("#isc_H8"))) {
			WebElement mapMenu = findElement(By.cssSelector("#isc_H8"));
			List<WebElement> mapMenuButtons = findElements(By.cssSelector("#isc_H8>*>*>*>img"));
			menu = MapMenu.getMapMenu(mapMenu, mapMenuButtons);
		} else {
			menu = MapMenu.getMapMenu(null, null);
		}
		_pageElements.add(menu);
		return menu;
	}
}
