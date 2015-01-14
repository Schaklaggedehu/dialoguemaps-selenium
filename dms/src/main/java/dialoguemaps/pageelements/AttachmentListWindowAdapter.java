package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AttachmentListWindowAdapter implements PageElementAdapter {

	private WebElement _attachmentListWindow;
	private WebElement _closeButton;
	private List<WebElement> _inputFields;

	public static AttachmentListWindowAdapter createAttachmentListWindowAdapter(WebElement attachmentListWindow,
			WebElement closeButton, List<WebElement> inputFields) {
		return new AttachmentListWindowAdapter(attachmentListWindow, closeButton, inputFields);
	}

	private AttachmentListWindowAdapter(WebElement attachmentListWindow, WebElement closeButton,
			List<WebElement> inputFields) {
		_attachmentListWindow = attachmentListWindow;
		_closeButton = closeButton;
		_inputFields = inputFields;
	}

	public WebElement getAttachmentListWindow() {
		return _attachmentListWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getSearchField() {
		return _inputFields.get(0);
	}

	public WebElement getTypeSelector() {
		return _inputFields.get(1);
	}

	public List<WebElement> getAllAttachments() {
		return _attachmentListWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div[eventproxy^=\"thumbnailView\"]"));
	}
}
