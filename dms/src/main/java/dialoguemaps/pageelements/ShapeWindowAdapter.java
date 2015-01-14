package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShapeWindowAdapter implements PageElementAdapter {

	private WebElement _shapeWindow;
	private WebElement _closeButton;
	private List<WebElement> _tabs;

	public static ShapeWindowAdapter createShapeWindowAdapter(WebElement shapeWindow, WebElement closeButton,
			List<WebElement> tabs) {
		return new ShapeWindowAdapter(shapeWindow, closeButton, tabs);
	}

	private ShapeWindowAdapter(WebElement shapeWindow, WebElement closeButton, List<WebElement> tabs) {
		_shapeWindow = shapeWindow;
		_closeButton = closeButton;
		_tabs = tabs;
	}

	public WebElement getShapeWindow() {
		return _shapeWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getTab(int tab) {
		return _tabs.get(tab);
	}

	public List<WebElement> getAllVisibleShapes() {
		return _shapeWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>div>div>svg>g"));
	}

	public WebElement getVisibleShape(int number) {
		return _shapeWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>div>div>svg>g")).get(number);
	}
}
