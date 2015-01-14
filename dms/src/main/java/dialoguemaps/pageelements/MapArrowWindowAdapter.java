package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Map Arrow window. Elements can be
 * e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class MapArrowWindowAdapter implements PageElementAdapter {

	private WebElement _mapArrowWindow;
	private WebElement _closeButton;
	private List<WebElement> _sizeButtons;
	private List<WebElement> _tails;
	private List<WebElement> _lines;
	private List<WebElement> _heads;

	public static MapArrowWindowAdapter createMapArrowWindowAdapter(WebElement mapArrowWindow, WebElement closeButton,
			List<WebElement> sizeButtons, List<WebElement> tails, List<WebElement> lines, List<WebElement> heads) {

		return new MapArrowWindowAdapter(mapArrowWindow, closeButton, sizeButtons, tails, lines, heads);
	}

	private MapArrowWindowAdapter(WebElement mapArrowWindow, WebElement closeButton, List<WebElement> sizeButtons,
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
}