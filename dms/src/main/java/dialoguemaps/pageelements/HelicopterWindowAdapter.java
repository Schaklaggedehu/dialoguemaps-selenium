package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelicopterWindowAdapter implements PageElementAdapter {

	private static HelicopterWindowAdapter _window;
	private WebElement _helicopterWindow;
	private WebElement _closeButton;

	public static HelicopterWindowAdapter createHelicopterWindowAdapter(WebElement helicopterWindow,
			WebElement closeButton) {
		if (_window == null) {
			_window = new HelicopterWindowAdapter(helicopterWindow, closeButton);
		}
		return _window;
	}

	private HelicopterWindowAdapter(WebElement helicopterWindow, WebElement closeButton) {
		_helicopterWindow = helicopterWindow;
		_closeButton = closeButton;
	}

	public WebElement getHelicopterWindow() {
		return _helicopterWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public List<WebElement> getAllHelicopterMapElements() {
		return _helicopterWindow.findElements(By.cssSelector("div>div>div>div>div>div>svg>g>g>g"));
	}

	@Override
	public void clear() {
		_window = null;
	}
}
