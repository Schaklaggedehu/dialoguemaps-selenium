package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Teleporter window.
 * Elements can be e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class TeleporterWindowAdapter implements PageElementAdapter {

	private static TeleporterWindowAdapter _window;
	private WebElement _teleporterWindow;
	private List<WebElement> _teleporterButtons;
	private WebElement _teleporterCloseButton;

	public static TeleporterWindowAdapter createTeleporterWindowAdapter(WebElement teleporterWindow, WebElement teleporterCloseButton,
			List<WebElement> teleporterButtons) {
		if (_window == null) {
			_window = new TeleporterWindowAdapter(teleporterWindow, teleporterCloseButton, teleporterButtons);
		}
		return _window;
	}

	private TeleporterWindowAdapter(WebElement teleporterWindow, WebElement teleporterCloseButton,
			List<WebElement> teleporterButtons) {
		_teleporterWindow = teleporterWindow;
		_teleporterCloseButton = teleporterCloseButton;
		_teleporterButtons = teleporterButtons;
	}

	public WebElement getTeleporterWindow() {
		return _teleporterWindow;
	}

	public WebElement getCloseButton() {
		return _teleporterCloseButton;
	}

	public WebElement getPresentationModeButton() {
		return _teleporterButtons.get(0);
	}

	public WebElement getNewSlideButton() {
		return _teleporterButtons.get(1);
	}

	public WebElement getHighlightGroupButton() {
		return _teleporterButtons.get(2);
	}

	public WebElement getNewPathButton() {
		return _teleporterButtons.get(3);
	}

	public List<WebElement> getSlides() {
		return _teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_UITrailPoint_\"]"));
	}

	public List<WebElement> getPaths() {
		return _teleporterWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>div>div>table>tbody>tr"));
	}

	public TeleporterSlide getSlide(int position) {
		List<WebElement> teleporterSlides = _teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_UITrailPoint_\"]"));
		return new TeleporterSlide(teleporterSlides.get(position));
	}

	public TeleporterPath getPath(int position) {
		List<WebElement> teleporterPaths = _teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>table>tbody>tr"));
		return new TeleporterPath(teleporterPaths.get(position));
	}

	public class TeleporterPath {
		WebElement _path;

		public TeleporterPath(WebElement path) {
			_path = path;
		}

		public WebElement getPath() {
			return _path;
		}

		public WebElement getDeleteButton() {
			return _path.findElement(By.cssSelector("td>div>nobr>img"));
		}

		public String getText() {
			return _path.findElement(By.cssSelector("td>div>nobr")).getText();
		}
	}

	public class TeleporterSlide {

		WebElement _slide;

		public TeleporterSlide(WebElement slide) {
			_slide = slide;
		}

		public WebElement getSlide() {
			return _slide.findElement(By.cssSelector("div>div>div>form"));
		}

		public WebElement getDeleteButton() {
			return _slide.findElement(By.cssSelector("div>div>div[eventproxy^=\"isc_Img_\"]"));
		}

		public WebElement getPreviewSVG() {
			return _slide.findElement(By.cssSelector("div>div>div>div>div>div>div>svg"));
		}

	}

	@Override
	public void clear() {
		_window = null;
	}
}
