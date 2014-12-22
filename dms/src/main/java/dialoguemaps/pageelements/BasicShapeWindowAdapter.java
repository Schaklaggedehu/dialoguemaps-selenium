package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class BasicShapeWindowAdapter implements PageElementAdapter {

	private static BasicShapeWindowAdapter _window;
	private WebElement _mapArrowWindow;
	private WebElement _closeButton;
	private List<WebElement> _sizeButtons;
	private List<WebElement> _shapes;

	public static BasicShapeWindowAdapter getBasicShapeWindow(WebElement basicShapeWindow, WebElement closeButton,
			List<WebElement> sizeButtons, List<WebElement> shapes) {

		if (_window == null) {
			_window = new BasicShapeWindowAdapter(basicShapeWindow, closeButton, sizeButtons, shapes);
		}
		return _window;
	}

	private BasicShapeWindowAdapter(WebElement mapArrowWindow, WebElement closeButton, List<WebElement> sizeButtons,
			List<WebElement> shapes) {
		_mapArrowWindow = mapArrowWindow;
		_closeButton = closeButton;
		_sizeButtons = sizeButtons;
		_shapes = shapes;
	}

	public WebElement getMapArrowWindow() {
		return _mapArrowWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getSmallButton() {
		return _sizeButtons.get(0);
	}

	public WebElement getMiddleButton() {
		return _sizeButtons.get(1);
	}

	public WebElement getBigButton() {
		return _sizeButtons.get(2);
	}

	public WebElement getShape(int shape) {
		return _shapes.get(shape);
	}

	@Override
	public void clear() {
		_window = null;
	}
}