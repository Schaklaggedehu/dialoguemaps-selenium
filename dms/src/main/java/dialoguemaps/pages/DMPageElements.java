package dialoguemaps.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.BasicShapeWindow;
import dialoguemaps.pageelements.BoundingBoxes;
import dialoguemaps.pageelements.Contextmenu;
import dialoguemaps.pageelements.DialogueMap;
import dialoguemaps.pageelements.HighlightPresentationWindow;
import dialoguemaps.pageelements.HighlightWindow;
import dialoguemaps.pageelements.InteractionWindow;
import dialoguemaps.pageelements.Mainmenu;
import dialoguemaps.pageelements.MapArrowWindow;
import dialoguemaps.pageelements.Mapmenu;
import dialoguemaps.pageelements.PageElement;
import dialoguemaps.pageelements.PenWindow;
import dialoguemaps.pageelements.Tabmenu;
import dialoguemaps.pageelements.TeleporterWindow;
import dialoguemaps.pageelements.ZoomWindow;

/**
 * 
 * @author janis
 */
public class DMPageElements extends AbstractPage<DMPage> {

	final String _cssSelectorWholeMap = "body>div[eventproxy^=\"isc_VLayout_\"]";

	final String _cssSelectorMainMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div>div>div>div.toolStrip:nth-child(1)";
	final String _cssSelectorMapMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div>div>div>div.toolStrip:nth-child(2)";
	final String _cssSelectorTabMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div[eventproxy^=\"isc_GWTMapElementZoomUI\"]";
	final String _cssSelectorContextMenu = "body>div[eventproxy^=\"isc_VLayout_\"]"
			+ ">div>div>div>div>div>div>div[eventproxy^=\"isc_Menu_\"]";
	
	final String _cssSelectorDialogueMap = "#DialogueMap";
	final String _cssSelectorBoundingBoxes = "#BoundingBoxOverlay>g";
	
	final String _cssSelectorTeleporterWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_TeleporterView_\"]";
	final String _cssSelectorHighlightWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_HighlightView_\"]";
	final String _cssSelectorHighlightPresentationWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_HighlightPresentationView_\"]";
	final String _cssSelectorMapArrowWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_MapArrowView_\"]";
	final String _cssSelectorBasicShapeWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_MapFigureView_\"]";

	final String _cssSelectorInteractionWindow = "#isc_JR";// TODO temporäre id
															// durch smarte
															// css-Pfade
															// austauschen
	final String _cssSelectorPenWindow = "#isc_9P";// TODO temporäre id durch
													// smarte css-Pfade
													// austauschen
	final String _cssSelectorZoomWindow = "#isc_92";// TODO temporäre id durch
													// smarte css-Pfade
													// austauschen

	Mainmenu _mainMenu;
	Mapmenu _mapMenu;
	Tabmenu _tabMenu;
	Contextmenu _contextMenu;
	
	InteractionWindow _interactionWindow;
	TeleporterWindow _teleporterWindow;
	HighlightWindow _highlightWindow;
	HighlightPresentationWindow _highlightPresentationWindow;
	PenWindow _penWindow;
	ZoomWindow _zoomWindow;
	MapArrowWindow _MapArrowWindow;
	BasicShapeWindow _BasicShapeWindow;

	DialogueMap _dialogueMap;
	BoundingBoxes _boundingBox;

	private static Set<PageElement> _pageElements = new HashSet<>();

	DMPageElements(WebDriver driver) {
		super(driver, By.id("isc_G"));// TODO temporäre id durch smarte
										// css-Pfade austauschen
	}

	public static void clearAllMenusAndWindows() {
		for (PageElement pageElement : _pageElements) {
			pageElement.clear();
		}
	}

	public void sleepXseconds(final long seconds) {
		System.out.println();
		for (int i = 0; i < 8; i++) {
			System.out.println("!!DEBUG ONLY!!DEBUG ONLY!!DEBUG ONLY!!    Start sleeping for " + seconds
					+ " seconds.    !!DEBUG ONLY!!DEBUG ONLY!!DEBUG ONLY!!");
		}
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
		}
		System.out.println("!!DONE SLEEPING!!");
		System.out.println();
	}

	public void logIntoMainpage(String name, String password) {
		WebElement nameField = findElement(By.cssSelector("#isc_P"));// TODO
																		// temporäre
																		// id
																		// durch
																		// smarte
																		// css-Pfade
																		// austauschen
		nameField.sendKeys(name);
		nameField.submit();
		WebElement passwordField = findElement(By.cssSelector("#isc_S"));// TODO
																			// temporäre
																			// id
																			// durch
																			// smarte
																			// css-Pfade
																			// austauschen
		passwordField.sendKeys(password);
		passwordField.submit();
		WebElement signIn = findElement(By.cssSelector("#isc_1E"));// TODO
																	// temporäre
																	// id durch
																	// smarte
																	// css-Pfade
																	// austauschen
		signIn.click();
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu
				+ ">div[eventproxy^=\"isc_TabSet_\"]>div>div>div>div>div>table[width]"));

	}

	protected InteractionWindow getInteractionWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorInteractionWindow));
		WebElement interactionWindow = findElement(By.cssSelector(_cssSelectorInteractionWindow));
		List<WebElement> interactionButtons = interactionWindow.findElements(By
				.cssSelector("*>*>*>*>*>*>*>*>*>*>*>img"));// TODO: Sternchen
															// entfernen.
		InteractionWindow window = InteractionWindow.getInteractionWindow(interactionWindow, interactionButtons);
		_pageElements.add(window);
		return window;
	}

	protected TeleporterWindow getTeleporterWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorTeleporterWindow));
		WebElement teleporterWindow = findElement(By.cssSelector(_cssSelectorTeleporterWindow));
		WebElement teleporterCloseButton = teleporterWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> teleporterButtons = teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		List<WebElement> teleporterPaths = teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>table>tbody>tr"));
		List<WebElement> teleporterSlides = teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_UITrailPoint_\"]"));
		TeleporterWindow window = TeleporterWindow.getTeleporterWindow(teleporterWindow, teleporterCloseButton,
				teleporterButtons, teleporterPaths, teleporterSlides);
		_pageElements.add(window);
		return window;
	}
	
	protected HighlightWindow getHighlightWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorHighlightWindow));
		WebElement highlightWindow = findElement(By.cssSelector(_cssSelectorHighlightWindow));
		WebElement highlightCloseButton = highlightWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> highlightButtons = highlightWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		List<WebElement> highlightSlides = highlightWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_Img_\"]"));
		HighlightWindow window = HighlightWindow.getHighlightWindow(highlightWindow, highlightCloseButton,
				highlightButtons, highlightSlides);
		_pageElements.add(window);
		return window;
	}

	protected HighlightPresentationWindow getHighlightPresentationPresentationWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorHighlightPresentationWindow));
		WebElement highlightPresentationWindow = findElement(By.cssSelector(_cssSelectorHighlightPresentationWindow));
		WebElement highlightPresentationCloseButton = highlightPresentationWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> highlightPresentationButtons = highlightPresentationWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>img"));
		HighlightPresentationWindow window = HighlightPresentationWindow.getHighlightPresentationWindow(highlightPresentationWindow, highlightPresentationCloseButton,
				highlightPresentationButtons);
		_pageElements.add(window);
		return window;
	}

	protected PenWindow getPenWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorPenWindow));
		WebElement penWindow = findElement(By.cssSelector(_cssSelectorPenWindow));
		List<WebElement> penButtons = penWindow.findElements(By.cssSelector("*>*>*>*>*>*>*>img"));// TODO:
																									// Sternchen
																									// entfernen.
		WebElement penCloseButton = penWindow.findElements(By.cssSelector("*>*>*>*>*>img")).get(1);// TODO:
																									// Sternchen
																									// entfernen.
		PenWindow window = PenWindow.getPenWindow(penWindow, penButtons, penCloseButton);
		_pageElements.add(window);
		return window;
	}

	protected ZoomWindow getZoomWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorZoomWindow));
		WebElement zoomWindow = findElement(By.cssSelector(_cssSelectorZoomWindow));
		List<WebElement> zoomButtons = zoomWindow.findElements(By.cssSelector(">*>*>*>img"));// TODO:
																								// Sternchen
																								// entfernen.
		zoomButtons.addAll(zoomWindow.findElements(By.cssSelector("*>*>*>*>*>img")));// TODO:
																						// Sternchen
																						// entfernen.
		zoomButtons.add(zoomWindow.findElement(By.cssSelector("*>*>*>*>*>*>*>img")));// TODO:
																						// Sternchen
																						// entfernen.
		zoomButtons.remove(0);
		ZoomWindow window = ZoomWindow.getZoomWindow(zoomWindow, zoomButtons);
		_pageElements.add(window);
		return window;
	}

	protected Mainmenu getMainMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorMainMenu));
		WebElement mainMenu = findElement(By.cssSelector(_cssSelectorMainMenu));
		List<WebElement> mainMenuButtons = mainMenu.findElements(By.cssSelector("div>div>div>img"));
		Mainmenu menu = Mainmenu.getMainMenu(mainMenu, mainMenuButtons);
		_pageElements.add(menu);
		return menu;
	}

	protected Mapmenu getMapMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorMapMenu));
		WebElement mapMenu = findElement(By.cssSelector(_cssSelectorMapMenu));
		List<WebElement> mapMenuButtons = mapMenu.findElements(By.cssSelector("div>div>div>img"));
		Mapmenu menu = Mapmenu.getMapMenu(mapMenu, mapMenuButtons);
		_pageElements.add(menu);
		return menu;
	}

	protected Tabmenu getTabMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu));
		WebElement tabMenu = findElement(By.cssSelector(_cssSelectorTabMenu));
		List<WebElement> tabs = tabMenu.findElements(By
				.cssSelector("div[eventproxy^=\"isc_TabSet_\"]>div>div>div>div>div>table[width]"));
		List<WebElement> buttons = tabMenu.findElements(By
				.cssSelector("div[eventproxy^=\"isc_ToolStrip_\"]>div>div>div>table>tbody>tr>td[align]"));
		Tabmenu menu = Tabmenu.getTabMenu(tabs, buttons);
		_pageElements.add(menu);
		return menu;
	}
	
	protected Contextmenu getContextMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorContextMenu));
		WebElement contextMenu = findElement(By.cssSelector(_cssSelectorContextMenu));
		List<WebElement> menuItems = findElements(By.cssSelector("div>table>tbody>tr[role=\"menuitem\"]"));
		Contextmenu menu = Contextmenu.getContextmenu(contextMenu, menuItems);
		_pageElements.add(menu);
		return menu;
	}

	protected DialogueMap getDialogueMap() {
		waitUntilVisible(By.cssSelector(_cssSelectorDialogueMap));
		WebElement dialogueMap = findElement(By.cssSelector(_cssSelectorDialogueMap));
		List<WebElement> dialogueMapCategories = dialogueMap.findElements(By.cssSelector("g>g"));
		List<WebElement> shapeElements = dialogueMapCategories.get(0).findElements((By.cssSelector("g")));
		List<WebElement> drawElements = dialogueMapCategories.get(1).findElements((By.cssSelector("g")));
		List<WebElement> previewElements = dialogueMapCategories.get(2).findElements(By.cssSelector("svg"));
		DialogueMap map = DialogueMap.getDialogueMap(dialogueMap, shapeElements, drawElements, previewElements);
		_pageElements.add(map);
		return map;
	}
	
	protected BoundingBoxes getBoundingBoxes() {
		waitUntilVisible(By.cssSelector(_cssSelectorBoundingBoxes));
		List<WebElement> boundingBoxes = findElements(By.cssSelector(_cssSelectorBoundingBoxes));
		BoundingBoxes boxes = BoundingBoxes.getBoundingBoxes(boundingBoxes);
		return boxes;
	}

	protected MapArrowWindow getMapArrowWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorMapArrowWindow));
		WebElement mapArrowWindow = findElement(By.cssSelector(_cssSelectorMapArrowWindow));
		List<WebElement> threeColumns = mapArrowWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_VLayout_\"]"));
		WebElement closeButton = mapArrowWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> sizeButtons = mapArrowWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		List<WebElement> tails = threeColumns.get(0).findElements(By
				.cssSelector("div[eventproxy^=\"tail\"]"));
		List<WebElement> lines = threeColumns.get(1).findElements(By
				.cssSelector("div[eventproxy^=\"line\"]"));
		List<WebElement> heads = threeColumns.get(2).findElements(By
				.cssSelector("div[eventproxy^=\"head\"]"));
		MapArrowWindow window = MapArrowWindow.getMapArrowWindow(mapArrowWindow, closeButton, sizeButtons, tails, lines, heads);
		_pageElements.add(window);
		return window;
	}
	
	protected BasicShapeWindow getBasicShapeWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorBasicShapeWindow));
		WebElement basicShapeWindow = findElement(By.cssSelector(_cssSelectorBasicShapeWindow));
		WebElement closeButton = basicShapeWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> sizeButtons = basicShapeWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		List<WebElement> shapes = basicShapeWindow.findElements(By
				.cssSelector("div>div>div>div>div>div[eventproxy^=\"isc_TabSet\"]>div>div>div>div>div>div[eventproxy^=\"figureList\"]"));
		BasicShapeWindow window = BasicShapeWindow.getBasicShapeWindow(basicShapeWindow, closeButton, sizeButtons, shapes);
		_pageElements.add(window);
		return window;
	}
	
}
