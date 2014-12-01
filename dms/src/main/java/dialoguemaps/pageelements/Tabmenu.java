package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Tabmenu implements PageElement{

	private List<WebElement> _tabs;
	private List<WebElement> _buttons;
	
	public static Tabmenu getTabMenu(List<WebElement> tabs, List<WebElement> buttons) {
		return new Tabmenu(tabs, buttons);
	}
	
	private Tabmenu(List<WebElement> tabs, List<WebElement> buttons){
		_tabs = tabs;
		_buttons = buttons;
	}
	
	public List<WebElement> getAllTabs(){
		return _tabs;
	}
	public WebElement getBackButton(){
		return _buttons.get(0);
	}
	public WebElement getRootButton(){
		return _buttons.get(1);
	}
	
	
	@Override
	public void clear() {
		//No singleton, therefore nothing to do here.
	}


}