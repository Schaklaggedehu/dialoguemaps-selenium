package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Zoom and Pan window. Elements can
 * be e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class ZoomAndPanWindowAdapter implements PageElementAdapter {

	private WebElement _zoomWindow;
	private List<WebElement> _zoomButtons;
	private List<WebElement> _panButtons;
	private WebElement _eyeButton;

	public static ZoomAndPanWindowAdapter createZoomWindowAdapter(WebElement zoomWindow, List<WebElement> zoomButtons,
			List<WebElement> panButtons, WebElement eyeButton) {
		return new ZoomAndPanWindowAdapter(zoomWindow, zoomButtons, panButtons, eyeButton);
	}

	private ZoomAndPanWindowAdapter(WebElement zoomWindow, List<WebElement> zoomButtons, List<WebElement> panButtons,
			WebElement eyeButton) {
		_zoomWindow = zoomWindow;
		_zoomButtons = zoomButtons;
		_panButtons = panButtons;
		_eyeButton = eyeButton;
	}

	public WebElement getZoomWindow() {
		return _zoomWindow;
	}

	public WebElement getUpButton() {
		return _panButtons.get(0);
	}

	public WebElement getLeftButton() {
		return _panButtons.get(1);
	}

	public WebElement getCenterButton() {
		return _panButtons.get(2);
	}

	public WebElement getRightButton() {
		return _panButtons.get(3);
	}

	public WebElement getDownButton() {
		return _panButtons.get(4);
	}

	public WebElement getZoomInButton() {
		return _zoomButtons.get(0);
	}

	public WebElement getZoomToButton() {
		return _zoomButtons.get(1);
	}

	public WebElement getHomeButton() {
		return _zoomButtons.get(2);
	}

	public WebElement getZoomOutButton() {
		return _zoomButtons.get(3);
	}

	public WebElement getToggleHomeButton() {
		return _eyeButton;
	}
}