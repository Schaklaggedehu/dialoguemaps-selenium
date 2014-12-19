package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * 
 * The DM ZoomWindow.
 * 
 * @author janis
 * @edit Martin
 * 
 * @version November 2014
 */
public class BasicShapeWindow implements PageElement {

	private static BasicShapeWindow _window;
	private WebElement _mapArrowWindow;
	private WebElement _closeButton;
	private List<WebElement> _sizeButtons;
	private List<WebElement> _shapes;

	public static BasicShapeWindow getBasicShapeWindow(WebElement basicShapeWindow, WebElement closeButton,
			List<WebElement> sizeButtons, List<WebElement> shapes) {

		if (_window == null) {
			_window = new BasicShapeWindow(basicShapeWindow, closeButton, sizeButtons, shapes);
		}
		return _window;
	}

	private BasicShapeWindow(WebElement mapArrowWindow, WebElement closeButton, List<WebElement> sizeButtons,
			List<WebElement> shapes) {
		_mapArrowWindow = mapArrowWindow;
		_closeButton = closeButton;
		_sizeButtons = sizeButtons;
		_shapes = shapes;
	}

	/**
	 * 
	 * @return
	 */
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

	/**
     * 
     */
	@Override
	public void clear() {
		_window = null;
	}
}