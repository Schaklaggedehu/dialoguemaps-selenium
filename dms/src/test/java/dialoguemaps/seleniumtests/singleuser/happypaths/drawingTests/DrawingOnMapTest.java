package dialoguemaps.seleniumtests.singleuser.happypaths.drawingTests;

import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dialoguemaps.pages.DMPage;
import dialoguemaps.tests.AbstractSelenium2Test;

/**
 * This class executes a drawing test on a DM map.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version Dezember 2014
 */
public class DrawingOnMapTest extends AbstractSelenium2Test {

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
		assertThat(_dm.isDMLoginPageOpen(), is(true), "couldn't reach login page");
		_dm.logIntoMainpage(NAME, PASSWORD);
		assertThat(_dm.isLoggedIntoMainPage(), is(true), "couldn't log in");
		_dm.shortcutCreateNewMap();
		assertThat(_dm.isNewMapOpen(), is(true), "creating nof new map failed");
//		assertThat(_dm.getTextFromTab(0), is("DM-Map"), "creating of new map failed");
	}

	@Test
	public void usePenToDrawOnNewMap() {
		_dm.openInteractionWindow();
		assertThat(_dm.isInteractionWindowOpen(), is(true), "couldn't open interaction window");
		_dm.openPenWindow();
		assertThat(_dm.isPenWindowOpen(), is(true), "couldn't open pen window");
		_dm.clickNormalPenButton();
		int drawnElementsBeforeDrawing = _dm.getSizeOfDrawnElements();
		_dm.drawHouseOnMap();
		_dm.closePenWindow();
		assertThat(_dm.isPenWindowClosed(), is(true), "couldn't close penwindow");
		_dm.waitUntilNewDrawElementsCreated(drawnElementsBeforeDrawing + 1);
		int drawnElementsAfterSaving = _dm.getSizeOfDrawnElements();
		assertThat(drawnElementsAfterSaving, is(drawnElementsBeforeDrawing + 1), "didn't save drawing");
	}
}