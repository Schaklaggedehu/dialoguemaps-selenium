package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Highlight window. Elements can be
 * e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class HighlightWindowAdapter implements PageElementAdapter {

	private WebElement _highlightWindow;
	private List<WebElement> _highlightButtons;
	private WebElement _highlightCloseButton;

	public static HighlightWindowAdapter createHighlightWindowAdapter(WebElement highlightWindow,
			WebElement highlightCloseButton, List<WebElement> highlightButtons) {
		return new HighlightWindowAdapter(highlightWindow, highlightCloseButton, highlightButtons);
	}

	private HighlightWindowAdapter(WebElement highlightWindow, WebElement highlightCloseButton,
			List<WebElement> highlightButtons) {
		_highlightWindow = highlightWindow;
		_highlightCloseButton = highlightCloseButton;
		_highlightButtons = highlightButtons;
	}

	public WebElement getHighlightWindow() {
		return _highlightWindow;
	}

	public WebElement getCloseButton() {
		return _highlightCloseButton;
	}

	public WebElement getPresentationModeButton() {
		return _highlightButtons.get(0);
	}

	public WebElement getNewSlideButton() {
		return _highlightButtons.get(1);
	}

	public WebElement getControllwindowButton() {
		return _highlightButtons.get(2);
	}

	public List<WebElement> getSlides() {
		return _highlightWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_Img_\"]"));
	}

	public HighlightSlide getSlide(int position) {
		List<WebElement> highlightSlides = _highlightWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_Img_\"]"));
		;
		return new HighlightSlide(highlightSlides.get(position));
	}

	public class HighlightSlide {

		WebElement _slide;

		public HighlightSlide(WebElement slide) {
			_slide = slide;
		}

		public WebElement getSlide() {
			return _slide.findElement(By.cssSelector("div>div>div>form"));
		}

		public WebElement getDeleteButton() {
			return _slide.findElement(By.cssSelector("div>div>div[eventproxy^=\"isc_Img_\"]"));
		}
	}
}
