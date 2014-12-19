package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author janis
 */
public class HighlightWindow implements PageElement {

	private WebElement _highlightWindow;
	private List<WebElement> _highlightButtons;
	private static HighlightWindow _window;
	private static List<WebElement> _highlightSlides;
	private WebElement _highlightCloseButton;

	public static HighlightWindow getHighlightWindow(WebElement highlightWindow, WebElement highlightCloseButton,
			List<WebElement> highlightButtons, List<WebElement> highlightSlides) {
		if (_window == null) {
			_window = new HighlightWindow(highlightWindow, highlightCloseButton, highlightButtons);
		}
		_highlightSlides = highlightSlides;
		return _window;
	}

	private HighlightWindow(WebElement highlightWindow, WebElement highlightCloseButton,
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
		return _highlightSlides;
	}

	public HighlightSlide getSlide(int position) {
		return new HighlightSlide(_highlightSlides.get(position));
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

	@Override
	public void clear() {
		_window = null;
	}
}
