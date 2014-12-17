package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Tabmenu implements PageElement {

	private static Tabmenu _menu;
	private static List<WebElement> _tabs;
	private List<WebElement> _buttons;

	public static Tabmenu getTabMenu(List<WebElement> tabs, List<WebElement> buttons) {
		if (_menu == null) {
			_menu = new Tabmenu(buttons);
		}
		_tabs = tabs;
		return _menu;
	}

	private Tabmenu(List<WebElement> buttons) {
		_buttons = buttons;
	}

	public List<WebElement> getAllTabs() {
		return _tabs;
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
