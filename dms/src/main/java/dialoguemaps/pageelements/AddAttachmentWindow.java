package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * 
 */
public class AddAttachmentWindow implements PageElement {

	private static AddAttachmentWindow _window;
	private WebElement _closeButton;
	private WebElement _addAttachmentWindow;
	private WebElement _okButton;
	private List<WebElement> _inputFields;

	public static AddAttachmentWindow getAddAttachmentWindow(WebElement addAttachmentWindow, WebElement closeButton,
			WebElement okButton, List<WebElement> inputFields) {
		if (_window == null) {
			_window = new AddAttachmentWindow(addAttachmentWindow, closeButton, okButton, inputFields);
		}
		return _window;
	}

	private AddAttachmentWindow(WebElement addAttachmentWindow, WebElement closeButton, WebElement okButton,
			List<WebElement> inputFields) {
		_addAttachmentWindow = addAttachmentWindow;
		_closeButton = closeButton;
		_okButton = okButton;
		_inputFields = inputFields;
	}

	public WebElement getAddAttachmentWindow() {
		return _addAttachmentWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getOkButton() {
		return _okButton;
	}

	public WebElement getTitleField() {
		return _inputFields.get(0);
	}

	public WebElement getAddressField() {
		return _inputFields.get(1);
	}

	@Override
	public void clear() {
		_window = null;
	}

}