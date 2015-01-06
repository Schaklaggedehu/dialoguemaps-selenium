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
		_mapMenuAdapter = createMapMenuAdapter();
		EventHelper.mouse.click(_mapMenuAdapter.getNewMapButton());
		_tabMenuAdapter = createTabMenuAdapter();
		waitUntilTextPresent(_tabMenuAdapter.getAllTabs().get(0), "DM-Map", 2);
	}

	public boolean isNewMapOpen() {
		_tabMenuAdapter = createTabMenuAdapter();
		return "DM-Map".equals(_tabMenuAdapter.getAllTabs().get(0).getText())
				&& _tabMenuAdapter.getAllTabs().size() == 1;
	}

	public void switchFromMainMenuToMapToolMenu() {
		_mainMenuAdapter = createMainMenuAdapter();
		EventHelper.mouse.click(_mainMenuAdapter.getMapToolsButton());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMapMenu)));
		_mapMenuAdapter = createMapMenuAdapter();
	}

	public void switchFromMapToolMenuToMainMenu() {
		_mapMenuAdapter = createMapMenuAdapter();
		EventHelper.mouse.doubleClick(_mapMenuAdapter.getMapToolMenuToolStrip());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMainMenu)));
		_mainMenuAdapter = createMainMenuAdapter();
	}

	public void openInteractionWindow() {
		_mainMenuAdapter = createMainMenuAdapter();
		EventHelper.mouse.click(_mainMenuAdapter.getInteractionButton());
	}

	public void openTeleporterWindow() {
		_mainMenuAdapter = createMainMenuAdapter();
		EventHelper.mouse.click(_mainMenuAdapter.getTeleporterButton());
	}

	public void openPenWindow() {
		_interactionWindowAdapter = createInteractionWindowAdapter();
		EventHelper.mouse.click(_interactionWindowAdapter.getPenButton());
	}

	public boolean isPenWindowOpen() {
		_penWindowAdapter = createPenWindowAdapter();
		return waitUntilVisible(_penWindowAdapter.getPenWindow());
	}

	public boolean isInteractionWindowOpen() {
		_interactionWindowAdapter = createInteractionWindowAdapter();
		return waitUntilVisible(_interactionWindowAdapter.getInteractionWindow());
	}

	public void clickNormalPenButton() {
		_penWindowAdapter = createPenWindowAdapter();
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
		_dialogueMapAdapter = createDialogueMapAdapter();
		return _dialogueMapAdapter.getAllDrawElements().size();
	}

	public void waitUntilNewDrawElementsCreated(int sizeAfter) {
		_dialogueMapAdapter = createDialogueMapAdapter();
		waitUntilNewDrawElementsCreated(sizeAfter, _dialogueMapAdapter);
	}

	public void shortcutNewMap() {
		EventHelper.keys.controlAltN();
		_tabMenuAdapter = createTabMenuAdapter();
		waitUntilTextPresent(_tabMenuAdapter.getAllTabs().get(0), "DM-Map", 1);
	}

	public String getTextFromTab(int tab) {
		_tabMenuAdapter = createTabMenuAdapter();
		return _tabMenuAdapter.getAllTabs().get(0).getText();
	}

	public boolean isDMLoginPageOpen() {
		_loginmenuAdapter = createLoginmenuAdapter();
		boolean visibility = _loginmenuAdapter.getSignInButton().isDisplayed();//TODO: ungetestet
//		boolean visibility = findElement(
//				By.cssSelector("body>div[eventproxy^=\"isc_HLayout_\"]>div>div>div>div[eventproxy^=\"isc_IButton_\"]")).isDisplayed();
		return visibility;
	}
}
