package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Add Attachment window. Elements
 * can be e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class AddAttachmentWindowAdapter implements PageElementAdapter {

	private WebElement _closeButton;
	private WebElement _addAttachmentWindow;
	private WebElement _okButton;
	private List<WebElement> _inputFields;

	public static AddAttachmentWindowAdapter createAddAttachmentWindowAdapter(WebElement addAttachmentWindow,
			WebElement closeButton, WebElement okButton, List<WebElement> inputFields) {
		return new AddAttachmentWindowAdapter(addAttachmentWindow, closeButton, okButton, inputFields);
	}

	private AddAttachmentWindowAdapter(WebElement addAttachmentWindow, WebElement closeButton, WebElement okButton,
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
}