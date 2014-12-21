package dialoguemaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dialoguemaps.tools.EventHelper;

/**
 * 
 * @author janis
 */
public class DMPage extends DMPageElements {

	public DMPage(final WebDriver driver) {
		super(driver);
		EventHelper.setDriver(_driver);
	}

	public boolean isLoggedIntoMainPage() {
		return waitUntilVisible(By.cssSelector(_cssSelectorMainMenu));
	}

	public void openNewMap() {
		_mapMenu = getMapMenu();
		EventHelper.mouse.click(_mapMenu.getNewMapButton());
		_tabMenu = getTabMenu();
		waitUntilTextPresent(_tabMenu.getAllTabs().get(0), "DM-Map", 2);
	}

	public boolean isNewMapOpen() {
		_tabMenu = getTabMenu();
		return "undefined".equals(_tabMenu.getAllTabs().get(0).getText()) && _tabMenu.getAllTabs().size() == 1;
	}

	public void switchFromMainMenuToMapToolMenu() {
		_mainMenu = getMainMenu();
		EventHelper.mouse.click(_mainMenu.getMapToolsButton());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMapMenu)));
		_mapMenu = getMapMenu();
	}

	public void switchFromMapToolMenuToMainMenu() {
		_mapMenu = getMapMenu();
		EventHelper.mouse.doubleClick(_mapMenu.getMapToolMenuToolStrip());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMainMenu)));
		_mainMenu = getMainMenu();
	}

	public void openInteractionWindow() {
		_mainMenu = getMainMenu();
		EventHelper.mouse.click(_mainMenu.getInteractionButton());
	}

	public void openTeleporterWindow() {
		_mainMenu = getMainMenu();
		EventHelper.mouse.click(_mainMenu.getTeleporterButton());
	}

	public void openPenWindow() {
		_interactionWindow = getInteractionWindow();
		EventHelper.mouse.click(_interactionWindow.getPenButton());
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
		EventHelper.mouse.click(_penWindow.getNormalButton());
	}

	public void drawHouseOnMap() {
		EventHelper.mouse.drawHouse(findElement(By.cssSelector(_cssSelectorWholeMap)));
	}

	public void closePenWindow() {
		EventHelper.mouse.click(_penWindow.getCloseButton());
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

	public void shortcutNewMap() {
		EventHelper.keys.controlAltN();
		_tabMenu = getTabMenu();
		waitUntilTextPresent(_tabMenu.getAllTabs().get(0), "DM-Map", 1);
	}

	public String getTextFromTab(int tab) {
		_tabMenu = getTabMenu();
		return _tabMenu.getAllTabs().get(0).getText();
	}

	public Boolean isDMLoginPageOpen() {
		String visibility = findElement(By.cssSelector("body>div>div>div>div>div[eventproxy^=\"isc_IButton_\"]"))
				.getAttribute("visibility");
		if ("hidden".equals(visibility)) {
			return false;
		} else {
			return true;
		}
	}
}
