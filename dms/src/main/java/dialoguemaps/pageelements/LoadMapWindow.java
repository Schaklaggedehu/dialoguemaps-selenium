package dialoguemaps.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoadMapWindow implements PageElement {

	private static LoadMapWindow _window;

	public static LoadMapWindow getLoadMapWindow(WebElement loadMapWindow, WebElement closeButton) {
		if (_window == null) {
			_window = new LoadMapWindow(loadMapWindow, closeButton);
		}
		return _window;
	}

	private WebElement _closeButton;
	private WebElement _loadMapWindow;

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