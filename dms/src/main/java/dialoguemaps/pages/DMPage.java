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
		_mapMenu = getMapMenu();
		_eventhelper.click(_mapMenu.getNewMapButton());
		List<WebElement> tabs = findElements(By.cssSelector("#isc_IH>*>*>*>*>*>*"));
		waitUntilTextPresent(tabs.get(0), "undefined", 2);
	}

	public boolean isNewMapOpen() {
		List<WebElement> tabs = findElements(By.cssSelector("#isc_IH>*>*>*>*>*>*"));
		return "undefined".equals(tabs.get(0).getText()) && tabs.size() / 4 == 1;
	}

	public void switchFromMainMenuToMapToolMenu() {
		_mainMenu = getMainMenu();
		_eventhelper.click(_mainMenu.getMapToolsButton());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMapMenu)));
		_mapMenu = getMapMenu();
	}

	public void switchFromMapToolMenuToMainMenu() {
		_mapMenu = getMapMenu();
		_eventhelper.doubleClick(_mapMenu.getMapToolMenuToolStrip());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMainMenu)));
		_mainMenu = getMainMenu();
	}

	public void openPenWindow() {
		_mainMenu = getMainMenu();
		_eventhelper.click(_mainMenu.getInteractionButton());
		_interactionWindow = getInteractionWindow();
		_eventhelper.click(_interactionWindow.getPenButton());
	}

	public boolean isPenWindowOpen() {
		_penWindow = getPenWindow();
		return waitUntilVisible(_penWindow.getPenWindow());
	}

	public void clickNormalPenButton() {
		_penWindow = getPenWindow();
		_eventhelper.click(_penWindow.getNormalButton());
	}

	public void drawHouseOnMap() {
		_eventhelper.drawHouse(findElement(By.cssSelector(_cssSelectorWholeMap)));
	}

	public void closePenWindow() {
		_eventhelper.click(_penWindow.getCloseButton());
	}

	public boolean isPenWindowClosed() {
		return waitUntilInvisibilityOfElementLocated(By.cssSelector(_cssSelectorPenWindow));
	}

	public int getSizeOfDrawnElements() {
		_dialogueMap = getDialogueMap();
		return _dialogueMap.getAllDrawElements().size();
	}
	public boolean waitForNewDrawElement(){
		return waitUntilPresenceOfAllElementsLocatedBy(By.cssSelector(_cssSelectorDialogueMap+">*>*>g"), 5);
	}
}
