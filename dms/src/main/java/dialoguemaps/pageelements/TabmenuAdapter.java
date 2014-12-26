package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TabmenuAdapter implements PageElementAdapter {

	private static TabmenuAdapter _menu;
	private List<WebElement> _buttons;
	private WebElement _tabMenu;

	public static TabmenuAdapter createTabMenuAdapter(WebElement tabMenu, List<WebElement> buttons) {
		if (_menu == null) {
			_menu = new TabmenuAdapter(tabMenu, buttons);
		}
		return _menu;
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

	@Override
	public void clear() {
		_menu = null;
	}

}
