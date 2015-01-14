package dialoguemaps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		return waitUntilVisible(By.cssSelector(_cssSelectorTabMenu
				+ ">div[eventproxy^=\"isc_TabSet_\"]>div>div>div>div>div>table[width]"));
	}

	public void openNewMap() {
		createMapMenuAdapter();
		EventHelper.mouse.click(_mapmenuAdapter.getNewMapButton());
		createTabMenuAdapter();
		waitUntilTextPresent(_tabmenuAdapter.getAllTabs().get(0), "DM-Map", 2);
	}

	public boolean isNewMapOpen() {
		createTabMenuAdapter();
		return "DM-Map".equals(_tabmenuAdapter.getAllTabs().get(0).getText())
				&& _tabmenuAdapter.getAllTabs().size() == 1;
	}

	public void switchFromMainMenuToMapToolMenu() {
		createMainMenuAdapter();
		EventHelper.mouse.click(_mainmenuAdapter.getMapToolsButton());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMapMenu)));
		createMapMenuAdapter();
	}

	public void switchFromMapToolMenuToMainMenu() {
		createMapMenuAdapter();
		EventHelper.mouse.doubleClick(_mapmenuAdapter.getMapToolMenuToolStrip());
		waitUntilClickable(findElement(By.cssSelector(_cssSelectorMainMenu)));
		createMainMenuAdapter();
	}

	public void openInteractionWindow() {
		createMainMenuAdapter();
		EventHelper.mouse.click(_mainmenuAdapter.getInteractionButton());
	}

	public void openTeleporterWindow() {
		createMainMenuAdapter();
		EventHelper.mouse.click(_mainmenuAdapter.getTeleporterButton());
	}

	public void openPenWindow() {
		createInteractionWindowAdapter();
		EventHelper.mouse.click(_interactionWindowAdapter.getPenButton());
	}

	public boolean isPenWindowOpen() {
		createPenWindowAdapter();
		return waitUntilVisible(_penWindowAdapter.getPenWindow());
	}

	public boolean isInteractionWindowOpen() {
		createInteractionWindowAdapter();
		return waitUntilVisible(_interactionWindowAdapter.getInteractionWindow());
	}

	public void clickNormalPenButton() {
		createPenWindowAdapter();
		WebElement normalButton = _penWindowAdapter.getNormalButton();
		EventHelper.mouse.click(normalButton);
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
		createDialogueMapAdapter();
		return _dialogueMapAdapter.getAllDrawElements().size();
	}

	public void waitUntilNewDrawElementsCreated(int sizeAfter) {
		createDialogueMapAdapter();
		waitUntilNewDrawElementsCreated(sizeAfter, _dialogueMapAdapter);
	}

	public void shortcutCreateNewMap() {
		EventHelper.keys.controlAltN();
		createTabMenuAdapter();
		waitUntilTextPresent(_tabmenuAdapter.getAllTabs().get(0), "DM-Map", 1);
	}

	public String getTextFromTab(int tab) {
		createTabMenuAdapter();
		return _tabmenuAdapter.getAllTabs().get(0).getText();
	}

	public boolean isDMLoginPageOpen() {
		return waitUntilVisible(By.cssSelector("body>div[eventproxy^=\"isc_HLayout_\"]>div>div>div>div[eventproxy^=\"isc_IButton_\"]"));
	}

	public void doo() {
		createInteractionWindowAdapter();
		createInteractionWindowAdapter();
		createInteractionWindowAdapter();
		createInteractionWindowAdapter();
		
	}
}
