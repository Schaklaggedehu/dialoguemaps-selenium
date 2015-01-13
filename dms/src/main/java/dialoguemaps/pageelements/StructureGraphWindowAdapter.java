package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StructureGraphWindowAdapter implements PageElementAdapter {

	private static StructureGraphWindowAdapter _window;
	private WebElement _structureGraphWindow;
	private WebElement _closeButton;
	private List<WebElement> _buttons;

	public static StructureGraphWindowAdapter createStructureGraphWindowAdapter(WebElement structureGraphWindow,
			WebElement closeButton, List<WebElement> buttons) {
		if (_window == null) {
			_window = new StructureGraphWindowAdapter(structureGraphWindow, closeButton, buttons);
		}
		return _window;
	}

	private StructureGraphWindowAdapter(WebElement structureGraphWindow, WebElement closeButton,
			List<WebElement> buttons) {
		_structureGraphWindow = structureGraphWindow;
		_closeButton = closeButton;
		_buttons = buttons;
	}

	public WebElement getStructureGraphWindow() {
		return _structureGraphWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getNewMapButton() {
		return _buttons.get(0);
	}

	public WebElement getDeleteButton() {
		return _buttons.get(1);
	}

	public WebElement getCenterButton() {
		return _buttons.get(2);
	}

	public WebElement getZoomInButton() {
		return _buttons.get(3);
	}

	public WebElement getZoomOutButton() {
		return _buttons.get(4);
	}

	public List<WebElement> getAllSVGArrows() {
		return _structureGraphWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>svg>g>svg:nth-Child(1)>svg"));
	}

	public List<WebElement> getAllSVGMapElements() {
		return _structureGraphWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>svg>g>svg:nth-Child(2)>svg"));
	}

	public int getNumberOfDisplayedLevels() {
		return _structureGraphWindow.findElements(
				By.cssSelector("div>div>div>div>div>div>div>div>svg>g>svg:nth-Child(2)>line")).size();
	}

	@Override
	public void clear() {
		_window = null;
	}
}
