package dialoguemaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dialoguemaps.tools.EventHelper;

/**
 * 
 * @author janis
 */
public class DMPage extends DMPageElements {

	private EventHelper _eventhelper = new EventHelper(_driver);

	public DMPage(final WebDriver driver) {
		super(driver);
	}

	public boolean isLoggedIntoMainPage() {
		return waitUntilVisible(By.cssSelector(_cssSelectorMainMenu));
	}

	public void openNewMap() {
		_mapMenu = getMapMenu();
		_eventhelper.click(_mapMenu.getNewMapButton());
		_tabMenu = getTabMenu();
		waitUntilTextPresent(_tabMenu.getAllTabs().get(0), "undefined", 2);
	}

	public boolean isNewMapOpen() {
		_tabMenu = getTabMenu();
		return "undefined".equals(_tabMenu.getAllTabs().get(0).getText()) && 
				_tabMenu.getAllTabs().size() == 1;
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

	public void openInteractionWindow() {
		_mainMenu = getMainMenu();
		_eventhelper.click(_mainMenu.getInteractionButton());
	}
	
	public void openTeleporterWindow() {
		_mainMenu = getMainMenu();
		_eventhelper.click(_mainMenu.getTeleporterButton());
	}

	public void openPenWindow() {
		_interactionWindow = getInteractionWindow();
		_eventhelper.click(_interactionWindow.getPenButton());
	}

	public boolean isPenWindowOpen() {
		_penWindow = getPenWindow();
		return waitUntilVisible(_penWindow.getPenWindow());
	}

	public boolean isInteractionWindowOpen() {
		_interactionWindow = getInteractionWindow();
		return waitUntilVisible(_interactionWindow.getInteractionWindow());
	}

	public void clickNormalPenButton() {
		_penWindow = getPenWindow();
		_eventhelper.click(_penWindow.getNormalButton());
	}

	public void drawOneHouseOnMap() {
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

	public void waitUntilNewDrawElementsCreated(int sizeAfter) {
		_dialogueMap = getDialogueMap();
		waitUntilNewDrawElementsCreated(sizeAfter, _dialogueMap);
	}
}
