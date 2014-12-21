package dialoguemaps.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Contextmenu implements PageElement {

	private static Contextmenu _menu;
	private WebElement _contextMenu;

	public static Contextmenu getContextmenu(WebElement contextMenu) {
		if (_menu == null) {
			_menu = new Contextmenu(contextMenu);
		}
		return _menu;
	}

	private Contextmenu(WebElement contextMenu) {
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
