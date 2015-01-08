package dialoguemaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dialoguemaps.tools.EventHelper;

/**
 * The DM webpage.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version Dezember 2014
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
		_mapmenuAdapter1 = createMapMenuAdapter();
		EventHelper.mouse.click(_mapmenuAdapter1.getNewMapButton());
		_tabmenuAdapter1 = createTabMenuAdapter();
		waitUntilTextPresent(_tabmenuAdapter1.getAllTabs().get(0), "DM-Map", 2);
	}

	public boolean isNewMapOpen() {
		_tabmenuAdapter1 = createTabMenuAdapter();
		return "DM-Map".equals(_tabmenuAdapter1.getAllTabs().get(0).getText())
				&& _tabmenuAdapter1.getAllTabs().size() == 1;
	}

	public void switchFromMainMenuToMapToolMenu() {
		_mainmenuAdapter1 = createMainMenuAdapter();
		EventHelper.mouse.click(_mainmenuAdapter1.getMapToolsButton());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMapMenu)));
		_mapmenuAdapter1 = createMapMenuAdapter();
	}

	public void switchFromMapToolMenuToMainMenu() {
		_mapmenuAdapter1 = createMapMenuAdapter();
		EventHelper.mouse.doubleClick(_mapmenuAdapter1.getMapToolMenuToolStrip());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMainMenu)));
		_mainmenuAdapter1 = createMainMenuAdapter();
	}

	public void openInteractionWindow() {
		_mainmenuAdapter1 = createMainMenuAdapter();
		EventHelper.mouse.click(_mainmenuAdapter1.getInteractionButton());
	}

	public void openTeleporterWindow() {
		_mainmenuAdapter1 = createMainMenuAdapter();
		EventHelper.mouse.click(_mainmenuAdapter1.getTeleporterButton());
	}

	public void openPenWindow() {
		_interactionWindowAdapter1 = createInteractionWindowAdapter();
		EventHelper.mouse.click(_interactionWindowAdapter1.getPenButton());
	}

	public boolean isPenWindowOpen() {
		_penWindowAdapter1 = createPenWindowAdapter();
		return waitUntilVisible(_penWindowAdapter1.getPenWindow());
	}

	public boolean isInteractionWindowOpen() {
		_interactionWindowAdapter1 = createInteractionWindowAdapter();
		return waitUntilVisible(_interactionWindowAdapter1.getInteractionWindow());
	}

	public void clickNormalPenButton() {
		_penWindowAdapter1 = createPenWindowAdapter();
		EventHelper.mouse.click(_penWindowAdapter1.getNormalButton());
	}

	public void drawHouseOnMap() {
		EventHelper.mouse.drawHouse(findElement(By.cssSelector(_cssSelectorWholeMap)));
	}

	public void closePenWindow() {
		EventHelper.mouse.click(_penWindowAdapter1.getCloseButton());
	}

	public boolean isPenWindowClosed() {
		return waitUntilInvisibilityOfElementLocated(By.cssSelector(_cssSelectorPenWindow));
	}

	public int getSizeOfDrawnElements() {
		_dialogueMapAdapter1 = createDialogueMapAdapter();
		return _dialogueMapAdapter1.getAllDrawElements().size();
	}

	public void waitUntilNewDrawElementsCreated(int sizeAfter) {
		_dialogueMapAdapter1 = createDialogueMapAdapter();
		waitUntilNewDrawElementsCreated(sizeAfter, _dialogueMapAdapter1);
	}

	public void shortcutNewMap() {
		EventHelper.keys.controlAltN();
		_tabmenuAdapter1 = createTabMenuAdapter();
		waitUntilTextPresent(_tabmenuAdapter1.getAllTabs().get(0), "DM-Map", 1);
	}

	public String getTextFromTab(int tab) {
		_tabmenuAdapter1 = createTabMenuAdapter();
		return _tabmenuAdapter1.getAllTabs().get(0).getText();
	}

	public boolean isDMLoginPageOpen() {
		_loginmenuAdapter1 = createLoginmenuAdapter();
		boolean visibility = findElement(
				By.cssSelector("body>div[eventproxy^=\"isc_HLayout_\"]>div>div>div>div[eventproxy^=\"isc_IButton_\"]")).isDisplayed();
		return visibility;
	}
}
