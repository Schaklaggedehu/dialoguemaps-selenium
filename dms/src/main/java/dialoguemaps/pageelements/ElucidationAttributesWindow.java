package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElucidationAttributesWindow implements PageElement {

	private static ElucidationAttributesWindow _window;
	private WebElement _closeButton;
	private WebElement _elucidationAttributesWindow;

	public static ElucidationAttributesWindow getElucidationAttributesWindow(WebElement elucidationAttributesWindow,
			WebElement closeButton) {
		if (_window == null) {
			_window = new ElucidationAttributesWindow(elucidationAttributesWindow, closeButton);
		}
		return _window;
	}

	private ElucidationAttributesWindow(WebElement elucidationAttributesWindow, WebElement closeButton) {
		_elucidationAttributesWindow = elucidationAttributesWindow;
		_closeButton = closeButton;
	}

	public WebElement getElucidationAttributesWindow() {
		return _elucidationAttributesWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public List<WebElement> getAllListItems() {
		return _elucidationAttributesWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>table>tbody>tr"));
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