package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChatWindowAdapter implements PageElementAdapter {

	private WebElement _chatWindow;
	private WebElement _closeButton;
	private WebElement _inviteButton;
	private WebElement _textarea;
	private List<WebElement> _selectItems;

	public static ChatWindowAdapter createChatWindowAdapter(WebElement chatWindow, WebElement closeButton,
			WebElement inviteButton, WebElement textarea, List<WebElement> selectItems) {
		return new ChatWindowAdapter(chatWindow, closeButton, inviteButton, textarea, selectItems);
	}

	private ChatWindowAdapter(WebElement chatWindow, WebElement closeButton, WebElement inviteButton,
			WebElement textarea, List<WebElement> selectItems) {
		_chatWindow = chatWindow;
		_closeButton = closeButton;
		_inviteButton = inviteButton;
		_textarea = textarea;
		_selectItems = selectItems;
	}

	public WebElement getChatWindow() {
		return _chatWindow;
	}

	public WebElement getCloseButton() {
		return _closeButton;
	}

	public WebElement getInviteToCurrentDMButton() {
		return _inviteButton;
	}

	public WebElement getTextInputField() {
		return _textarea;
	}

	public WebElement getStatusSelector() {
		return _selectItems.get(0);
	}

	public WebElement getChatSelector() {
		return _selectItems.get(1);
	}

	public List<WebElement> getAllTabs() {
		return _chatWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>div[role=\"tab\"]"));
	}

	public WebElement getTab(int tab) {
		return _chatWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>div[role=\"tab\"]")).get(tab);
	}

	public String getPostedTexts() {
		return _chatWindow.findElement(
				By.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_HTMLPane_\"]"))
				.getText();
	}
}
