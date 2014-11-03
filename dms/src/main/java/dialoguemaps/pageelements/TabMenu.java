package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class TabMenu implements PageElement{

	private List<WebElement> _tabs;
	
	public static TabMenu getTabMenu(List<WebElement> tabs) {
		return new TabMenu(tabs);
	}
	
	private TabMenu(List<WebElement> tabs){
		_tabs = tabs;
	}
	
	public List<WebElement> getAllTabs(){
		return _tabs;
	}
	
	
	@Override
	public void clear() {
		//No singleton, therefore nothing to do here.
	}


}
