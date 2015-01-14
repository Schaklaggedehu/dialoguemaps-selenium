package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Tab menu. Elements can be e.g.
 * the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class TabmenuAdapter implements PageElementAdapter {

	private List<WebElement> _buttons;
	private WebElement _tabMenu;

	public static TabmenuAdapter createTabMenuAdapter(WebElement tabMenu, List<WebElement> buttons) {
		return new TabmenuAdapter(tabMenu, buttons);
	}

	private TabmenuAdapter(WebElement tabMenu, List<WebElement> buttons) {
		_tabMenu = tabMenu;
		_buttons = buttons;
	}

	public List<WebElement> getAllTabs() {
		return _tabMenu.findElements(By
				.cssSelector("div[eventproxy^=\"isc_TabSet_\"]>div>div>div>div>div>table[width]"));
	}

	public WebElement getBackButton() {
		return _buttons.get(0);
	}

	public WebElement getRootButton() {
		return _buttons.get(1);
	}
}
