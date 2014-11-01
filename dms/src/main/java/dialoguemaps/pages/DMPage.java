package dialoguemaps.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.tools.EventHelper;

/**
 * 
 * @author janis
 */
public class DMPage extends PageElementCreator {

	private EventHelper _eventhelper = new EventHelper(_driver);

	public DMPage(final WebDriver driver) {
		super(driver, By.id("isc_G"));
	}

	public boolean isLoggedIntoMainPage() {
		return waitUntilVisible(By.cssSelector("#isc_FW"));
	}

	public void openNewMap() {
		switchFromMainMenuToMapToolMenu();
		_eventhelper.click(_mapMenu.getNewMapButton());
		List<WebElement> tabs = findElements(By.cssSelector("#isc_IH>*>*>*>*>*>*"));
		waitUntilTextPresent(tabs.get(0), "undefined", 2);
	}

	public boolean isNewMapOpen() {
		List<WebElement> tabs = findElements(By.cssSelector("#isc_IH>*>*>*>*>*>*"));
		return "undefined".equals(tabs.get(0).getText()) && tabs.size() / 4 == 1;
	}

	public void switchFromMainMenuToMapToolMenu(){
		waitUntilVisible(By.cssSelector("#isc_FW"));
		_mainMenu = getMainMenu();
		_eventhelper.click(_mainMenu.getMapToolsButton());
		waitUntilClickable(findElement(By.cssSelector("#isc_H8")));
		_mapMenu = getMapMenu();
	}
	
	public void switchFromMapToolMenuToMainMenu(){
		waitUntilVisible(By.cssSelector("#isc_H8"));
		_mapMenu = getMapMenu();
		_eventhelper.doubleClick(_mapMenu.getMapToolMenuToolStrip());
		waitUntilClickable(findElement(By.cssSelector("#isc_FW")));
		_mainMenu = getMainMenu();
	}
	
	public void openPenWindow() {
		switchFromMapToolMenuToMainMenu();
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
