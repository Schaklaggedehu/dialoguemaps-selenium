package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class MapArrowWindow implements PageElement {

	private static MapArrowWindow _window;
	private WebElement _mapArrowWindow;
	private WebElement _closeButton;
	private List<WebElement> _sizeButtons;
	private List<WebElement> _tails;
	private List<WebElement> _lines;
	private List<WebElement> _heads;

	public static MapArrowWindow getMapArrowWindow(WebElement mapArrowWindow, WebElement closeButton,
			List<WebElement> sizeButtons, List<WebElement> tails, List<WebElement> lines, List<WebElement> heads) {

		if (_window == null) {
			_window = new MapArrowWindow(mapArrowWindow, closeButton, sizeButtons, tails, lines, heads);
		}
		return _window;
	}

	private MapArrowWindow(WebElement mapArrowWindow, WebElement closeButton, List<WebElement> sizeButtons,
			List<WebElement> tails, List<WebElement> lines, List<WebElement> heads) {
		_mapArrowWindow = mapArrowWindow;
		_closeButton = closeButton;
		_sizeButtons = sizeButtons;
		_tails = tails;
		_lines = lines;
		_heads = heads;
	}

	public WebElement getMapArrowWindow() {
		return _mapArrowWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getSmallButton() {
		return _sizeButtons.get(0);
	}

	public WebElement getMiddleButton() {
		return _sizeButtons.get(1);
	}

	public WebElement getBigButton() {
		return _sizeButtons.get(2);
	}

	public WebElement getTail(int tail) {
		return _tails.get(tail);
	}

	public WebElement getLine(int line) {
		return _lines.get(line);
	}

	public WebElement getHead(int head) {
		return _heads.get(head);
	}

	@Override
	public void clear() {
		_window = null;
	}
}