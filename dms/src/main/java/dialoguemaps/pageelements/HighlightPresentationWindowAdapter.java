package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Highlight Presentation window.
 * Elements can be e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class HighlightPresentationWindowAdapter implements PageElementAdapter {

	private WebElement _highlightPresentationWindow;
	private List<WebElement> _highlightPresentationButtons;
	private WebElement _highlightPresentationCloseButton;

	public static HighlightPresentationWindowAdapter createHighlightPresentationWindowAdapter(
			WebElement highlightPresentationWindow, WebElement highlightPresentationCloseButton,
			List<WebElement> highlightPresentationButtons) {
		return new HighlightPresentationWindowAdapter(highlightPresentationWindow, highlightPresentationCloseButton,
				highlightPresentationButtons);
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
}