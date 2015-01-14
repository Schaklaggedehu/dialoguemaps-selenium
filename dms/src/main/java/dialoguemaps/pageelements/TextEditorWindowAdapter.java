package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class TextEditorWindowAdapter implements PageElementAdapter {

	private WebElement _closeButton;
	private WebElement _textEditorWindow;
	private List<WebElement> _buttons;
	private List<WebElement> _forms;
	private WebElement _textfield;

	public static TextEditorWindowAdapter createTextEditorWindowAdapter(WebElement textEditorWindow,
			WebElement closeButton, List<WebElement> buttons, List<WebElement> forms, WebElement textfield) {
		return new TextEditorWindowAdapter(textEditorWindow, closeButton, buttons, forms, textfield);
	}

	private TextEditorWindowAdapter(WebElement textEditorWindow, WebElement closeButton, List<WebElement> buttons,
			List<WebElement> forms, WebElement textfield) {
		_textEditorWindow = textEditorWindow;
		_closeButton = closeButton;
		_buttons = buttons;
		_forms = forms;
		_textfield = textfield;
	}

	public WebElement getTextEditorWindow() {
		return _textEditorWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getColorButton() {
		return _buttons.get(0);
	}

	public WebElement getBoldButton() {
		return _buttons.get(1);
	}

	public WebElement getItalicButton() {
		return _buttons.get(2);
	}

	public WebElement getUnderlineButton() {
		return _buttons.get(3);
	}

	public WebElement getCrossoutButton() {
		return _buttons.get(4);
	}

	public WebElement getOKButton() {
		return _buttons.get(5);
	}

	public WebElement getFontForm() {
		return _forms.get(0);
	}

	public WebElement getFontSizeForm() {
		return _forms.get(0);
	}

	public WebElement getTextEditorInputForm() {
		return _textfield;
	}
}
