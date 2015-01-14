package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Map menu. Elements can be e.g.
 * the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class MapmenuAdapter implements PageElementAdapter {

	private WebElement _mapToolsMenuToolStrip;
	private List<WebElement> _mapMenuButtons;

	public static MapmenuAdapter createMapMenuAdapter(WebElement mapMenu, List<WebElement> mapMenuButtons) {
		return new MapmenuAdapter(mapMenu, mapMenuButtons);
	}

	private MapmenuAdapter(final WebElement mapToolsMenuToolStrip, final List<WebElement> mapMenuButtons) {
		_mapToolsMenuToolStrip = mapToolsMenuToolStrip;
		_mapMenuButtons = mapMenuButtons;
	}

	public WebElement getMapToolMenuToolStrip() {
		return _mapToolsMenuToolStrip;
	}

	public WebElement getOpenButton() {
		return _mapMenuButtons.get(0);
	}

	public WebElement getNewMapButton() {
		return _mapMenuButtons.get(1);
	}

	public WebElement getDeleteMapButton() {
		return _mapMenuButtons.get(2);
	}

	public WebElement getClearMapButton() {
		return _mapMenuButtons.get(3);
	}

	public WebElement getSaveAsButton() {
		return _mapMenuButtons.get(4);
	}

	public WebElement getReturnButton() {
		return _mapMenuButtons.get(5);
	}
}
