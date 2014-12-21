package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * The DM ZoomWindow.
 * 
 * @author janis
 * @edit Martin
 * 
 * @version November 2014
 */
public class LoadMapWindow implements PageElement {

	private static LoadMapWindow _window;
	private static List<WebElement> _mapList;

	public static LoadMapWindow getLoadMapWindow(WebElement loadMapWindow, WebElement closeButton,
			List<WebElement> mapList) {
		if (_window == null) {
			_window = new LoadMapWindow(loadMapWindow, closeButton);
		}
		_mapList = mapList;
		return _window;
	}

	private WebElement _closeButton;
	private WebElement _loadMapWindow;

	/**
     * 
     */
	private LoadMapWindow(WebElement loadMapWindow, WebElement closeButton) {
		_loadMapWindow = loadMapWindow;
		_closeButton = closeButton;
	}

	public WebElement getWindow() {
		return _loadMapWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getListEntry(int listEntry) {
		return _mapList.get(listEntry);
	}

	public String getMapID(WebElement listEntry) {
		return listEntry.findElement(By.cssSelector("td:nth-child(1)>div>nobr")).getText();
	}

	public String getName(WebElement listEntry) {
		return listEntry.findElement(By.cssSelector("td:nth-child(2)>div>nobr")).getText();

	}

	public String getCreationTime(WebElement listEntry) {
		return listEntry.findElement(By.cssSelector("td:nth-child(3)>div>nobr")).getText();

	}

	/**
     * 
     */
	@Override
	public void clear() {
		_window = null;
	}
}