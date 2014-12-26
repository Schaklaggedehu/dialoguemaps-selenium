package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PenWindowAdapter implements PageElementAdapter {

	private static PenWindowAdapter _window;
	private WebElement _penWindow;
	private List<WebElement> _penButtons;
	private WebElement _penCloseButton;

	public static PenWindowAdapter createPenWindowAdapter(WebElement penWindow, List<WebElement> penButtons, 
			WebElement penCloseButton) {
		if (_window == null) {
			_window = new PenWindowAdapter(penWindow, penButtons, penCloseButton);
		}
		return _window;
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
	public WebElement getCloseButton(){
		return _penCloseButton;
	}

	@Override
	public void clear() {
		_window = null;
	}
}
