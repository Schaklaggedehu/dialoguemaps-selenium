package dialoguemaps.seleniumtests.multiuser.happypaths.logintests;

import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dialoguemaps.pages.DMPage;
import dialoguemaps.tools.AbstractSelenium2Test;

/**
 * 
 * @author janis
 */
public class LoginWithThreeUsersTest extends AbstractSelenium2Test {

	private static final int _userCount = 3;
	private static final List<String> _loginPerson0= Arrays.asList("dev","dev");
	private static final List<String> _loginPerson1= Arrays.asList("dev","dev");
	private static final List<String> _loginPerson2= Arrays.asList("dev","dev");
	DMPage _dm0;
	DMPage _dm1;
	DMPage _dm2;

	@BeforeClass
	public static void test(){
		AbstractSelenium2Test.initSelenium2Test(3);
	}
//	public LoginWithThreeUsersTest(){
//		super(_userCount);
//	}
	@Before
	public void setUp() {
		_dm0 = new DMPage(_drivers.get(0));
		_dm1 = new DMPage(_drivers.get(1));
		_dm2 = new DMPage(_drivers.get(2));
	}

	@Test
	public void loginWithThreeUsers() {
		final int NAME = 0;
		final int PASSWORD = 1;
		_dm0.open();
		_dm1.open();
		_dm2.open();
		_dm0.logIntoMainpage(_loginPerson0.get(NAME), _loginPerson0.get(PASSWORD));
		_dm1.logIntoMainpage(_loginPerson1.get(NAME), _loginPerson1.get(PASSWORD));
		_dm2.logIntoMainpage(_loginPerson2.get(NAME), _loginPerson2.get(PASSWORD));
		assertThat("person 1 not logged in", _dm0.isLoggedIntoMainPage(), is(true));
		assertThat("person 2 not logged in", _dm1.isLoggedIntoMainPage(), is(true));
		assertThat("person 3 not logged in", _dm2.isLoggedIntoMainPage(), is(true));
	}
}
