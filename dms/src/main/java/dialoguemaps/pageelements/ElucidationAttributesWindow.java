package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 */
public class ElucidationAttributesWindow implements PageElement {

	private static ElucidationAttributesWindow _window;
	private static List<WebElement> _listItems;
	private WebElement _closeButton;
	private WebElement _elucidationAttributesWindow;

	public static ElucidationAttributesWindow getElucidationAttributesWindow(WebElement elucidationAttributeWindow,
			WebElement closeButton, List<WebElement> listItems) {
		if (_window == null) {
			_window = new ElucidationAttributesWindow(elucidationAttributeWindow, closeButton);
		}
		_listItems = listItems;
		return _window;
	}

	private ElucidationAttributesWindow(WebElement elucidationAttributeWindow, WebElement closeButton) {
		_elucidationAttributesWindow = elucidationAttributeWindow;
		_closeButton = closeButton;
	}

	public WebElement getElucidationAttributesWindow() {
		return _elucidationAttributesWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public List<WebElement> getAllListItems() {
		return _listItems;
	}

	public String getOverlayname(WebElement listItem) {
		return listItem.findElement(By.cssSelector("td:nth-child(1)>div>nobr")).getText();
	}

	public String getName(WebElement listItem) {
		return listItem.findElement(By.cssSelector("td:nth-child(2)>div>nobr")).getText();
	}

	@Override
	public void clear() {
		_window = null;
	}
}