package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Basic Shape window. Elements can
 * be e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class BasicShapeWindowAdapter implements PageElementAdapter {

	private WebElement _mapArrowWindow;
	private WebElement _closeButton;
	private List<WebElement> _sizeButtons;
	private List<WebElement> _shapes;

	public static BasicShapeWindowAdapter createBasicShapeWindowAdapter(WebElement basicShapeWindow,
			WebElement closeButton, List<WebElement> sizeButtons, List<WebElement> shapes) {

		return new BasicShapeWindowAdapter(basicShapeWindow, closeButton, sizeButtons, shapes);
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
}