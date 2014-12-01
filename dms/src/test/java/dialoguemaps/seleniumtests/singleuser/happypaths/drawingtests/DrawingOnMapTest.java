package dialoguemaps.seleniumtests.singleuser.happypaths.drawingtests;

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
	}

	@Test
	public void usePenToDraw() {
		_dm.open();
		assertThat("mainpage not open", _dm.isOpen(), is(true));
		_dm.logIntoMainpage(NAME, PASSWORD);
		assertThat("couldn't log in", _dm.isLoggedIntoMainPage(), is(true));
		_dm.openInteractionWindow();
		assertThat("couldn't open interaction window", _dm.isInteractionWindowOpen(), is(true));
		_dm.openPenWindow();
		assertThat("couldn't open pen window", _dm.isPenWindowOpen(), is(true));
		_dm.clickNormalPenButton();
		int drawnElementsBeforeDrawing = _dm.getSizeOfDrawnElements();
		_dm.drawOneHouseOnMap();
		_dm.closePenWindow();
		assertThat("couldn't close penwindow", _dm.isPenWindowClosed(), is(true));
		_dm.waitUntilNewDrawElementsCreated(drawnElementsBeforeDrawing + 1);
		int drawnElementsAfterSaving = _dm.getSizeOfDrawnElements();
		assertThat("didn't save drawing", drawnElementsAfterSaving, is(drawnElementsBeforeDrawing + 1));
	}

	@Test
	public void openNewMapAndUsePenToDraw() {
		_dm.open();
		assertThat("mainpage not open", _dm.isOpen(), is(true));
		_dm.logIntoMainpage(NAME, PASSWORD);
		assertThat("couldn't log in", _dm.isLoggedIntoMainPage(), is(true));
		_dm.switchFromMainMenuToMapToolMenu();
		_dm.openNewMap();
		assertThat("couldn't open new map", _dm.isNewMapOpen(), is(true));
		_dm.switchFromMapToolMenuToMainMenu();
		_dm.openInteractionWindow();
		assertThat("couldn't open interaction window", _dm.isInteractionWindowOpen(), is(true));
		_dm.openPenWindow();
		assertThat("couldn't open pen window", _dm.isPenWindowOpen(), is(true));
		_dm.clickNormalPenButton();
		int drawnElementsBeforeDrawing = _dm.getSizeOfDrawnElements();
		_dm.drawOneHouseOnMap();
		_dm.closePenWindow();
		assertThat("couldn't close penwindow", _dm.isPenWindowClosed(), is(true));
		_dm.waitUntilNewDrawElementsCreated(drawnElementsBeforeDrawing + 1);
		int drawnElementsAfterSaving = _dm.getSizeOfDrawnElements();
		assertThat("didn't save drawing", drawnElementsAfterSaving, is(drawnElementsBeforeDrawing + 1));
	}
}
