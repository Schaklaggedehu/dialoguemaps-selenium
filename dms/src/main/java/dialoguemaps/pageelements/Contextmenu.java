package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Contextmenu implements PageElement {

	private static Contextmenu _menu;
	private List<WebElement> _menuItems;
	private WebElement _contextMenu;

	
	public static Contextmenu getContextmenu(WebElement contextMenu, List<WebElement> menuItems) {
		if (_menu == null) {
			_menu = new Contextmenu(contextMenu, menuItems);
		}
		return _menu;
	}

	private Contextmenu(WebElement contextMenu, List<WebElement> menuItems) {
		_contextMenu = contextMenu;
		_menuItems = menuItems;
	}

	public WebElement getContextMenu() {
		return _contextMenu;
	}

	public WebElement getMenuItem(int item) {
		return _menuItems.get(item);
	}

	@Override
	public void clear() {
		_menu = null;
	}

}
