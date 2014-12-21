package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 */
public class AttachmentsWindow implements PageElement {

	private static AttachmentsWindow _window;
	private WebElement _closeButton;
	private WebElement _attachmentWindow;
	private WebElement _newButton;

	public static AttachmentsWindow getAttachmentsWindow(WebElement attachmentWindow, WebElement closeButton,
			WebElement newButton) {
		if (_window == null) {
			_window = new AttachmentsWindow(attachmentWindow, closeButton, newButton);
		}
		return _window;
	}

	private AttachmentsWindow(WebElement attachmentWindow, WebElement closeButton, WebElement newButton) {
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