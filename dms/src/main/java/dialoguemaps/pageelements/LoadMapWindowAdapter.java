package dialoguemaps.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoadMapWindowAdapter implements PageElementAdapter {

	private static LoadMapWindowAdapter _window;

	public static LoadMapWindowAdapter getLoadMapWindow(WebElement loadMapWindow, WebElement closeButton) {
		if (_window == null) {
			_window = new LoadMapWindowAdapter(loadMapWindow, closeButton);
		}
		return _window;
	}

	private WebElement _closeButton;
	private WebElement _loadMapWindow;

	private LoadMapWindowAdapter(WebElement loadMapWindow, WebElement closeButton) {
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
		return _loadMapWindow
				.findElements(By.cssSelector("div>div>div>div>div>div>div>div>div>div>div>table>tbody>tr")).get(
						listEntry);
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

	@Override
	public void clear() {
		_window = null;
	}
}