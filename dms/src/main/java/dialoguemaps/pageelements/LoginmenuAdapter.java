package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class LoginmenuAdapter implements PageElementAdapter{

	private static LoginmenuAdapter _menu;
	private List<WebElement> _loginmenuFields;
	private List<WebElement> _loginmenuButtons;

	public static LoginmenuAdapter createLoginmenuAdapter(List<WebElement> loginmenuButtons,
			List<WebElement> loginmenuFields) {
		if(_menu==null){
			_menu = new LoginmenuAdapter(loginmenuButtons, loginmenuFields);
		}
		return _menu;
	}
	
	private LoginmenuAdapter(final List<WebElement> loginmenuButtons, final List<WebElement> loginmenuFields) {
		_loginmenuFields = loginmenuFields;
		_loginmenuButtons = loginmenuButtons;
	}

	public WebElement getSignInButton(){
		return _loginmenuButtons.get(0);
	}
	
	public WebElement getRegisterButton(){
		return _loginmenuButtons.get(1);
	}
	
	public WebElement getSignInUsernameField() {
		return _loginmenuFields.get(0);
	}
	
	public WebElement getSignInPasswordField() {
		return _loginmenuFields.get(1);
	}
	
	public WebElement getRegisterUsernameField() {
		return _loginmenuFields.get(2);
	}
	
	public WebElement getRegisterPasswordField() {
		return _loginmenuFields.get(3);
	}
	
	public WebElement getRegisterRepeatPasswordField() {
		return _loginmenuFields.get(4);
	}
	
	public WebElement getRegisterEmailField() {
		return _loginmenuFields.get(5);
	}
	
	public WebElement getRegisterRepeatEmailField() {
		return _loginmenuFields.get(6);
	}
	
	@Override
	public void clear() {
		_menu = null;
	}
}
