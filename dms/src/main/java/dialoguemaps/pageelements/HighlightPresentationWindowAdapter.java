package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class HighlightPresentationWindowAdapter implements PageElementAdapter {

	private static HighlightPresentationWindowAdapter _window;
	private WebElement _highlightPresentationWindow;
	private List<WebElement> _highlightPresentationButtons;
	private WebElement _highlightPresentationCloseButton;

	public static HighlightPresentationWindowAdapter getHighlightPresentationWindow(WebElement highlightPresentationWindow,
			WebElement highlightPresentationCloseButton, List<WebElement> highlightPresentationButtons) {
		if (_window == null) {
			_window = new HighlightPresentationWindowAdapter(highlightPresentationWindow, highlightPresentationCloseButton,
					highlightPresentationButtons);
		}
		return _window;
	}

	private HighlightPresentationWindowAdapter(WebElement highlightPresentationWindow,
			WebElement highlightPresentationCloseButton, List<WebElement> highlightPresentationButtons) {
		_highlightPresentationWindow = highlightPresentationWindow;
		_highlightPresentationCloseButton = highlightPresentationCloseButton;
		_highlightPresentationButtons = highlightPresentationButtons;
	}

	public WebElement getCloseButton() {
		return _highlightPresentationCloseButton;
	}

	public WebElement getHighlightPresentationWindow() {
		return _highlightPresentationWindow;
	}

	public WebElement getPreviousButton() {
		return _highlightPresentationButtons.get(0);
	}

	public WebElement getNextButton() {
		return _highlightPresentationButtons.get(1);
	}

	public WebElement getAddPreviousButton() {
		return _highlightPresentationButtons.get(2);
	}

	public WebElement getAddNextButton() {
		return _highlightPresentationButtons.get(3);
	}

	@Override
	public void clear() {
		_window = null;
	}
}