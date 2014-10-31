package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * 
 * @author janis
 */
public class MapMenu {

	private WebElement _mapToolsMenuToolStrip;
	private List<WebElement> _mapMenuButtons;
	private static MapMenu _menu;

	public static MapMenu getMapMenu(WebElement mapMenu, List<WebElement> mapMenuButtons) {
		if(_menu == null){
			_menu = new MapMenu(mapMenu, mapMenuButtons);
		}
		return _menu;
	}
	
	private MapMenu(final WebElement mapToolsMenuToolStrip, final List<WebElement> mapMenuButtons) {
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
