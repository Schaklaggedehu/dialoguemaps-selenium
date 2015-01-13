package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class SettingsWindowAdapter implements PageElementAdapter {

	private static SettingsWindowAdapter _window;
	private WebElement _settingsWindow;
	private WebElement _closeButton;
	private WebElement _saveButton;
	private List<WebElement> _inputFields;

	public static SettingsWindowAdapter createSettingsWindowAdapter(WebElement settingsWindow, WebElement closeButton,
			WebElement saveButton, List<WebElement> inputFields) {
		if (_window == null) {
			_window = new SettingsWindowAdapter(settingsWindow, closeButton, saveButton, inputFields);
		}
		return _window;
	}

	private SettingsWindowAdapter(WebElement settingsWindow, WebElement closeButton, WebElement saveButton,
			List<WebElement> inputFields) {
		_settingsWindow = settingsWindow;
		_closeButton = closeButton;
		_saveButton = saveButton;
		_inputFields = inputFields;
	}

	public WebElement getSettingsWindow() {
		return _settingsWindow;
	}

	public WebElement getSaveButton() {
		return _saveButton;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getPathField() {
		return _inputFields.get(0);
	}

	public WebElement getGenerationTimeField() {
		return _inputFields.get(1);
	}

	public WebElement getFailTimeField() {
		return _inputFields.get(2);
	}

	public WebElement getAdminEmailAddressField() {
		return _inputFields.get(3);
	}

	public WebElement getSMTPHostField() {
		return _inputFields.get(4);
	}

	public WebElement getSMTPPortField() {
		return _inputFields.get(5);
	}

	public WebElement getSMTPSenderAddressField() {
		return _inputFields.get(6);
	}

	@Override
	public void clear() {
		_window = null;
	}
}
