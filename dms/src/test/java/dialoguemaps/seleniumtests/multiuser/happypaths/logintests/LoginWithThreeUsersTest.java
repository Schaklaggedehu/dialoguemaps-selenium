package dialoguemaps.seleniumtests.multiuser.happypaths.logintests;

import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dialoguemaps.pages.DMPage;
import dialoguemaps.tests.AbstractSelenium2Test;

public class LoginWithThreeUsersTest extends AbstractSelenium2Test {

	private static final int USERCOUNT = 3;
	private static final List<String> LOGINPERSON0= Arrays.asList("dev","dev");
	private static final List<String> LOGINPERSON1= Arrays.asList("dev","dev");
	private static final List<String> LOGINPERSON2= Arrays.asList("dev","dev");
	private DMPage _dm0;
	private DMPage _dm1;
	private DMPage _dm2;

	@BeforeClass
	public static void initSelenium2Test(){
		AbstractSelenium2Test.initSelenium2Test(USERCOUNT);
	}

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
		assertThat(_dm0.isDMLoginPageOpen(), is(true), "couldn't reach login page");
		_dm1.open();
		assertThat(_dm1.isDMLoginPageOpen(), is(true), "couldn't reach login page");
		_dm2.open();
		assertThat(_dm2.isDMLoginPageOpen(), is(true), "couldn't reach login page");
		_dm0.logIntoMainpage(LOGINPERSON0.get(NAME), LOGINPERSON0.get(PASSWORD));
		_dm1.logIntoMainpage(LOGINPERSON1.get(NAME), LOGINPERSON1.get(PASSWORD));
		_dm2.logIntoMainpage(LOGINPERSON2.get(NAME), LOGINPERSON2.get(PASSWORD));
		assertThat(_dm0.isLoggedIntoMainPage(), is(true), "person 1 not logged in");
		assertThat(_dm1.isLoggedIntoMainPage(), is(true), "person 2 not logged in");
		assertThat(_dm2.isLoggedIntoMainPage(), is(true), "person 3 not logged in");
	}
}
