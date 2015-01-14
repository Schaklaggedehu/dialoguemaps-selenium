package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Pen window. Elements can be e.g.
 * the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class PenWindowAdapter implements PageElementAdapter {

	private WebElement _penWindow;
	private List<WebElement> _penButtons;
	private WebElement _penCloseButton;

	public static PenWindowAdapter createPenWindowAdapter(WebElement penWindow, List<WebElement> penButtons,
			WebElement penCloseButton) {
		return new PenWindowAdapter(penWindow, penButtons, penCloseButton);
	}

	private PenWindowAdapter(WebElement penWindow, List<WebElement> penButtons, WebElement penCloseButton) {
		_penWindow = penWindow;
		_penButtons = penButtons;
		_penCloseButton = penCloseButton;
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

	public WebElement getCloseButton() {
		return _penCloseButton;
	}
}
