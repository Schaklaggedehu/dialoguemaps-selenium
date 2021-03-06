package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Main menu. Elements can be e.g.
 * the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class MainmenuAdapter implements PageElementAdapter {

	private WebElement _mainMenuToolStrip;
	private List<WebElement> _mainMenuButtons;

	public static MainmenuAdapter createMainMenuAdapter(WebElement mainMenu, List<WebElement> mainMenuButtons) {

		return new MainmenuAdapter(mainMenu, mainMenuButtons);
	}

	private MainmenuAdapter(final WebElement mainMenuToolStrip, final List<WebElement> mainMenuButtons) {
		_mainMenuToolStrip = mainMenuToolStrip;
		_mainMenuButtons = mainMenuButtons;
	}

	public WebElement getMainMenuToolStrip() {
		return _mainMenuToolStrip;
	}

	public WebElement getMapToolsButton() {
		return _mainMenuButtons.get(0);
	}

	public WebElement getInteractionButton() {
		return _mainMenuButtons.get(1);
	}

	public WebElement getChatButton() {
		return _mainMenuButtons.get(2);
	}

	public WebElement getZoomButton() {
		return _mainMenuButtons.get(3);
	}

	public WebElement getHelicopterButton() {
		return _mainMenuButtons.get(4);
	}

	public WebElement getHighlightButton() {
		return _mainMenuButtons.get(5);
	}

	public WebElement getTeleporterButton() {
		return _mainMenuButtons.get(6);
	}

	public WebElement getStructureGraphButton() {
		return _mainMenuButtons.get(7);
	}

	public WebElement getAttachmentListButton() {
		return _mainMenuButtons.get(8);
	}

	public WebElement getLogoutButton() {
		return _mainMenuButtons.get(9);
	}

	public WebElement getSettingsButton() {
		return _mainMenuButtons.get(10);
	}

	public WebElement getInfoButton() {
		return _mainMenuButtons.get(11);
	}
}
