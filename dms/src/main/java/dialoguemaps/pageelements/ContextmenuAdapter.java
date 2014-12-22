package dialoguemaps.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContextmenuAdapter implements PageElementAdapter {

	private static ContextmenuAdapter _menu;
	private WebElement _contextMenu;

	public static ContextmenuAdapter getContextmenu(WebElement contextMenu) {
		if (_menu == null) {
			_menu = new ContextmenuAdapter(contextMenu);
		}
		return _menu;
	}

	private ContextmenuAdapter(WebElement contextMenu) {
		_contextMenu = contextMenu;
	}

	public WebElement getContextMenu() {
		return _contextMenu;
	}

	public WebElement getMenuItem(int item) {
		return _contextMenu.findElements(By.cssSelector("div>table>tbody>tr[role=\"menuitem\"]")).get(item);
	}

	@Override
	public void clear() {
		_menu = null;
	}

}
