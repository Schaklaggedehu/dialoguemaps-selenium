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
		_mapMenuAdapter = getMapMenu();
		EventHelper.mouse.click(_mapMenuAdapter.getNewMapButton());
		_tabMenuAdapter = getTabMenu();
		waitUntilTextPresent(_tabMenuAdapter.getAllTabs().get(0), "DM-Map", 2);
	}

	public boolean isNewMapOpen() {
		_tabMenuAdapter = getTabMenu();
		return "undefined".equals(_tabMenuAdapter.getAllTabs().get(0).getText()) && _tabMenuAdapter.getAllTabs().size() == 1;
	}

	public void switchFromMainMenuToMapToolMenu() {
		_mainMenuAdapter = getMainMenu();
		EventHelper.mouse.click(_mainMenuAdapter.getMapToolsButton());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMapMenu)));
		_mapMenuAdapter = getMapMenu();
	}

	public void switchFromMapToolMenuToMainMenu() {
		_mapMenuAdapter = getMapMenu();
		EventHelper.mouse.doubleClick(_mapMenuAdapter.getMapToolMenuToolStrip());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMainMenu)));
		_mainMenuAdapter = getMainMenu();
	}

	public void openInteractionWindow() {
		_mainMenuAdapter = getMainMenu();
		EventHelper.mouse.click(_mainMenuAdapter.getInteractionButton());
	}

	public void openTeleporterWindow() {
		_mainMenuAdapter = getMainMenu();
		EventHelper.mouse.click(_mainMenuAdapter.getTeleporterButton());
	}

	public void openPenWindow() {
		_interactionWindowAdapter = getInteractionWindow();
		EventHelper.mouse.click(_interactionWindowAdapter.getPenButton());
	}

	public boolean isPenWindowOpen() {
		_penWindowAdapter = getPenWindow();
		return waitUntilVisible(_penWindowAdapter.getPenWindow());
	}

	public boolean isInteractionWindowOpen() {
		_interactionWindowAdapter = getInteractionWindow();
		return waitUntilVisible(_interactionWindowAdapter.getInteractionWindow());
	}

	public void clickNormalPenButton() {
		_penWindowAdapter = getPenWindow();
		EventHelper.mouse.click(_penWindowAdapter.getNormalButton());
	}

	public void drawHouseOnMap() {
		EventHelper.mouse.drawHouse(findElement(By.cssSelector(_cssSelectorWholeMap)));
	}

	public void closePenWindow() {
		EventHelper.mouse.click(_penWindowAdapter.getCloseButton());
	}

	public boolean isPenWindowClosed() {
		return waitUntilInvisibilityOfElementLocated(By.cssSelector(_cssSelectorPenWindow));
	}

	public int getSizeOfDrawnElements() {
		_dialogueMapAdapter = getDialogueMap();
		return _dialogueMapAdapter.getAllDrawElements().size();
	}

	public void waitUntilNewDrawElementsCreated(int sizeAfter) {
		_dialogueMapAdapter = getDialogueMap();
		waitUntilNewDrawElementsCreated(sizeAfter, _dialogueMapAdapter);
	}

	public void shortcutNewMap() {
		EventHelper.keys.controlAltN();
		_tabMenuAdapter = getTabMenu();
		waitUntilTextPresent(_tabMenuAdapter.getAllTabs().get(0), "DM-Map", 1);
	}

	public String getTextFromTab(int tab) {
		_tabMenuAdapter = getTabMenu();
		return _tabMenuAdapter.getAllTabs().get(0).getText();
	}

	public Boolean isDMLoginPageOpen() {
		String visibility = findElement(By.cssSelector("body>div>div>div>div>div[eventproxy^=\"isc_IButton_\"]"))
				.getAttribute("visibility");
		System.out.println(visibility);
		if (" hidden".equals(visibility)) {
			System.out.println("false");
			return false;
		} else {
			System.out.println("true");
			return true;
		}
	}
}
