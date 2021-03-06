package dialoguemaps.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the context menu. Elements can be
 * e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class ContextmenuAdapter implements PageElementAdapter {

	private WebElement _contextMenu;

	public static ContextmenuAdapter createContextMenuAdapter(WebElement contextMenu) {
		return new ContextmenuAdapter(contextMenu);
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
}
