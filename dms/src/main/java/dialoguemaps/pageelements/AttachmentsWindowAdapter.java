package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Attachments window.
 * Elements can be e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class AttachmentsWindowAdapter implements PageElementAdapter {

	private static AttachmentsWindowAdapter _window;
	private WebElement _closeButton;
	private WebElement _attachmentWindow;
	private WebElement _newButton;

	public static AttachmentsWindowAdapter createAttachmentsWindowAdapter(WebElement attachmentWindow, WebElement closeButton,
			WebElement newButton) {
		if (_window == null) {
			_window = new AttachmentsWindowAdapter(attachmentWindow, closeButton, newButton);
		}
		return _window;
	}

	private AttachmentsWindowAdapter(WebElement attachmentWindow, WebElement closeButton, WebElement newButton) {
		_attachmentWindow = attachmentWindow;
		_closeButton = closeButton;
		_newButton = newButton;
	}

	public WebElement getAttachmentWindow() {
		return _attachmentWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getNewButton() {
		return _newButton;
	}

	public List<WebElement> getAllListItems() {
		return _attachmentWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>div>div>table>tbody>tr"));
	}

	@Override
	public void clear() {
		_window = null;
	}

}