package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * 
 * @author janis
 */
public class PenWindow {

	private static WebElement _penWindow;
	private List<WebElement> _penButtons;
	private static PenWindow _window;

	public static PenWindow getPenWindow(WebElement penWindow, List<WebElement> penButtons) {
		if (_window == null) {
			_window = new PenWindow(penWindow, penButtons);
		}
		return _window;
	}

	private PenWindow(WebElement penWindow, List<WebElement> penButtons) {
		_penWindow = penWindow;
		_penButtons = penButtons;
	}

	public WebElement getPenWindow() {
		return _penWindow;
	}

	public WebElement getThinButton() {
		return _penButtons.get(0);
	}

	public WebElement getNormalButton() {
		return _penButtons.get(1);
	}

	public WebElement getThickButton() {
		return _penButtons.get(2);
	}

}
