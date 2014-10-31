package dialoguemaps.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.InterActionWindow;
import dialoguemaps.pageelements.MainMenu;
import dialoguemaps.pageelements.MapMenu;
import dialoguemaps.pageelements.PenWindow;
import dialoguemaps.tools.EventHelper;

/**
 * 
 * @author janis
 */
public class DMPage extends PageElementCreator {

	private MainMenu _mainMenu;
	private InterActionWindow _interactionWindow;
	private EventHelper _eventhelper = new EventHelper(_driver);
	private PenWindow _penWindow;
	private MapMenu _mapMenu;

	public DMPage(final WebDriver driver) {
		super(driver, By.id("isc_G"));
	}

	public boolean isLoggedIntoMainPage() {
		return waitUntilVisible(By.cssSelector("#isc_FW"));
	}

	public void openNewMap() {
		_mainMenu = getMainMenu();
		waitUntilVisible(_mainMenu.getMapToolsButton());
		_mainMenu.getMapToolsButton().click();
		sleepXseconds(2);// TODO wait until mapmenu visible
		_mapMenu = getMapMenu();
		waitUntilVisible(_mapMenu.getNewMapButton());
		_eventhelper.click(_mapMenu.getNewMapButton());
		List<WebElement> tabs = findElements(By.cssSelector("#isc_IH>*>*>*>*>*>*"));
		waitUntilTextPresent(tabs.get(0), "undefined");
	}

	public boolean isNewMapOpen() {
		List<WebElement> tabs = findElements(By.cssSelector("#isc_IH>*>*>*>*>*>*"));
		return "undefined".equals(tabs.get(0).getText()) && tabs.size() / 4 == 1;
	}

	public void openPenWindow() {
		_mapMenu = getMapMenu();
		_eventhelper.click(_mapMenu.getReturnButton());
		sleepXseconds(2);// TODO wait until mapmenu visible
		_mainMenu = getMainMenu();
		waitUntilVisible(_mainMenu.getInteractionButton());
		_eventhelper.click(_mainMenu.getInteractionButton());
		_interactionWindow = getInteractionWindow();
		waitUntilVisible(_interactionWindow.getPenButton());
		_eventhelper.click(_interactionWindow.getPenButton());
	}

	public boolean isPenWindowOpen() {
		_penWindow = getPenWindow();
		return waitUntilVisible(_penWindow.getPenWindow());
	}
}
