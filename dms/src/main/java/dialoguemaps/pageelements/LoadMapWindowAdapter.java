package dialoguemaps.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Load Map window. Elements can be
 * e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class LoadMapWindowAdapter implements PageElementAdapter {

	private WebElement _closeButton;
	private WebElement _loadMapWindow;

	public static LoadMapWindowAdapter createLoadMapWindowAdapter(WebElement loadMapWindow, WebElement closeButton) {
		return new LoadMapWindowAdapter(loadMapWindow, closeButton);
	}

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
}