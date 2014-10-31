package dialoguemaps.seleniumtests.singleuser.happypaths.newmaptests;

import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dialoguemaps.pages.DMPage;
import dialoguemaps.tools.AbstractSelenium2Test;

/**
 * 
 * @author janis
 */
public class OpenNewMapAndThenOpenDrawWindowTest extends AbstractSelenium2Test {

	@BeforeClass
	public static void test(){
		AbstractSelenium2Test.initSelenium2Test(1);
	}
//	public OpenNewMapAndThenOpenDrawWindowTest() {
//		super(1);
//	}
	private static final String NAME = "dev";
	private static final String PASSWORD = "dev";
	DMPage _dm;

	@Before
	public void setUp() {
		_dm = new DMPage(_drivers.get(0));
	}
	
	@Test
	public void openNewMapAndOpenPenWindow() {
		_dm.open();
		_dm.sleepXseconds(2);
		assertThat("mainpage not open", _dm.isOpen(), is(true));
		_dm.logIntoMainpage(NAME, PASSWORD);
		assertThat("couldn't log in", _dm.isLoggedIntoMainPage(), is(true));
		_dm.openNewMap();
		assertThat("couldn't open new map", _dm.isNewMapOpen(), is(true));
		_dm.openPenWindow();
		assertThat("couldn't open pen window", _dm.isPenWindowOpen(), is(true));
	}
}
