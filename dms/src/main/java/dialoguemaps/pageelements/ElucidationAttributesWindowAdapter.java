package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Elucidation Attributes window.
 * Elements can be e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class ElucidationAttributesWindowAdapter implements PageElementAdapter {

	private WebElement _closeButton;
	private WebElement _elucidationAttributesWindow;

	public static ElucidationAttributesWindowAdapter createElucidationAttributesWindowAdapter(
			WebElement elucidationAttributesWindow, WebElement closeButton) {
		return new ElucidationAttributesWindowAdapter(elucidationAttributesWindow, closeButton);
	}

	private ElucidationAttributesWindowAdapter(WebElement elucidationAttributesWindow, WebElement closeButton) {
		_elucidationAttributesWindow = elucidationAttributesWindow;
		_closeButton = closeButton;
	}

	public WebElement getElucidationAttributesWindow() {
		return _elucidationAttributesWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public List<WebElement> getAllListItems() {
		return _elucidationAttributesWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>table>tbody>tr"));
	}

	public String getOverlayname(WebElement listItem) {
		return listItem.findElement(By.cssSelector("td:nth-child(1)>div>nobr")).getText();
	}

	public String getName(WebElement listItem) {
		return listItem.findElement(By.cssSelector("td:nth-child(2)>div>nobr")).getText();
	}
}