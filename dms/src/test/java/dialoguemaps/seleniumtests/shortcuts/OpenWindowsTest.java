package dialoguemaps.seleniumtests.shortcuts;

import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dialoguemaps.pages.DMPage;
import dialoguemaps.tests.AbstractSelenium2Test;

/**
 * 
 * @author janis
 */
public class OpenWindowsTest extends AbstractSelenium2Test {

	private static final int USERCOUNT = 1;
	private static final String NAME = "dev";
	private static final String PASSWORD = "dev";
	private DMPage _dm;

	@BeforeClass
	public static void initSelenium2Test() {
		AbstractSelenium2Test.initSelenium2Test(USERCOUNT);
	}

	@Before
	public void setUp() {
		_dm = new DMPage(_drivers.get(0));
		_dm.open();
		assertThat(_dm.isDMPageOpen(), is(true), "couldn't reach login page");
		_dm.logIntoMainpage(NAME, PASSWORD);
		assertThat(_dm.isLoggedIntoMainPage(), is(true), "couldn't log in");
	}

	@Test
	public void openNewMapWindowWithShortcut(){
		//TODO
	}
}
