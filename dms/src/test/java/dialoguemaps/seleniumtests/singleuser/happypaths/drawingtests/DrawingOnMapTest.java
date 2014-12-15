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
		_dm.open();
		assertThat(_dm.isOpen(), is(true), "mainpage not open");
		_dm.logIntoMainpage(NAME, PASSWORD);
		assertThat(_dm.isLoggedIntoMainPage(), is(true), "couldn't log in");
	}

	@Test//TODO: Element auf die leere Karte legen. Dann usePenToDraw verwenden.
	//XXX Idee: Vielleicht verschiedene SetUps designen. Map leer. Map mit einer Shape. Map mit einer Zeichnung.
	public void usePenToDraw() {
		_dm.openInteractionWindow();
		assertThat(_dm.isInteractionWindowOpen(), is(true), "couldn't open interaction window");
		_dm.openPenWindow();
		assertThat(_dm.isPenWindowOpen(), is(true), "couldn't open pen window");
		_dm.clickNormalPenButton();
		int drawnElementsBeforeDrawing = _dm.getSizeOfDrawnElements();
		_dm.drawOneHouseOnMap();
		_dm.closePenWindow();
		assertThat(_dm.isPenWindowClosed(), is(true), "couldn't close penwindow");
		_dm.waitUntilNewDrawElementsCreated(drawnElementsBeforeDrawing + 1);
		int drawnElementsAfterSaving = _dm.getSizeOfDrawnElements();
		assertThat(drawnElementsAfterSaving, is(drawnElementsBeforeDrawing + 1), "didn't save drawing");
	}

	@Test
	public void openNewMapAndUsePenToDraw() {
		_dm.switchFromMainMenuToMapToolMenu();
		_dm.openNewMap();
		assertThat(_dm.isNewMapOpen(), is(true), "couldn't open new map");
		_dm.switchFromMapToolMenuToMainMenu();
		_dm.openInteractionWindow();
		assertThat(_dm.isInteractionWindowOpen(), is(true), "couldn't open interaction window");
		_dm.openPenWindow();
		assertThat(_dm.isPenWindowOpen(), is(true), "couldn't open pen window");
		_dm.clickNormalPenButton();
		int drawnElementsBeforeDrawing = _dm.getSizeOfDrawnElements();
		_dm.drawOneHouseOnMap();
		_dm.closePenWindow();
		assertThat(_dm.isPenWindowClosed(), is(true), "couldn't close penwindow");
		_dm.waitUntilNewDrawElementsCreated(drawnElementsBeforeDrawing + 1);
		int drawnElementsAfterSaving = _dm.getSizeOfDrawnElements();
		assertThat(drawnElementsAfterSaving, is(drawnElementsBeforeDrawing + 1), "didn't save drawing");
	}
}
