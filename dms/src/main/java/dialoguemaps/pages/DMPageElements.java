package dialoguemaps.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.AddAttachmentWindowAdapter;
import dialoguemaps.pageelements.AttachmentsWindowAdapter;
import dialoguemaps.pageelements.BasicShapeWindowAdapter;
import dialoguemaps.pageelements.BoundingBoxesAdapter;
import dialoguemaps.pageelements.ColorPickerAdapter;
import dialoguemaps.pageelements.ContextmenuAdapter;
import dialoguemaps.pageelements.DialogueMapAdapter;
import dialoguemaps.pageelements.ElucidationAttributesWindowAdapter;
import dialoguemaps.pageelements.HighlightPresentationWindowAdapter;
import dialoguemaps.pageelements.HighlightWindowAdapter;
import dialoguemaps.pageelements.InteractionWindowAdapter;
import dialoguemaps.pageelements.LoadMapWindowAdapter;
import dialoguemaps.pageelements.MainmenuAdapter;
import dialoguemaps.pageelements.MapArrowWindowAdapter;
import dialoguemaps.pageelements.MapmenuAdapter;
import dialoguemaps.pageelements.PageElementAdapter;
import dialoguemaps.pageelements.PenWindowAdapter;
import dialoguemaps.pageelements.TabmenuAdapter;
import dialoguemaps.pageelements.TeleporterWindowAdapter;
import dialoguemaps.pageelements.ZoomAndPanWindowAdapter;

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
	final String _cssSelectorElucidations = "#ElucidationController";
	final String _cssSelectorBoundingBoxes = "#BoundingBoxOverlay>g";
	final String _cssSelectorColorPicker = "body>div[eventproxy^=\"isc_ColorPicker_\"][role=\"dialog\"]";

	final String _cssSelectorTeleporterWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_TeleporterView_\"]";
	final String _cssSelectorHighlightWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_HighlightView_\"]";
	final String _cssSelectorHighlightPresentationWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_HighlightPresentationView_\"]";
	final String _cssSelectorMapArrowWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_MapArrowView_\"]";
	final String _cssSelectorBasicShapeWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_MapFigureView_\"]";
	final String _cssSelectorLoadMapWindow = "body>div[class=\"normal\"][eventproxy^=\"isc_DialogLoadMapView_\"]>div";
	final String _cssSelectorElucidationAttributesWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_ElucidationContextView_\"]";
	final String _cssSelectorAttachmentsWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_AttachmentAddItemView_\"]";
	final String _cssSelectorAddAttachmentWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_AttachmentAddView_\"]";

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

	MainmenuAdapter _mainMenu;
	MapmenuAdapter _mapMenu;
	TabmenuAdapter _tabMenu;
	ContextmenuAdapter _contextMenu;

	InteractionWindowAdapter _interactionWindow;
	TeleporterWindowAdapter _teleporterWindow;
	HighlightWindowAdapter _highlightWindow;
	HighlightPresentationWindowAdapter _highlightPresentationWindow;
	PenWindowAdapter _penWindow;
	ZoomAndPanWindowAdapter _zoomWindow;
	MapArrowWindowAdapter _mapArrowWindow;
	BasicShapeWindowAdapter _basicShapeWindow;
	LoadMapWindowAdapter _loadMapWindow;
	ElucidationAttributesWindowAdapter _elucidationAttributeWindow;
	AttachmentsWindowAdapter _attachmentsWindow;
	AddAttachmentWindowAdapter _addAttachmentWindow;

	DialogueMapAdapter _dialogueMap;
	BoundingBoxesAdapter _boundingBox;

	private static Set<PageElementAdapter> _pageElements = new HashSet<>();

	DMPageElements(WebDriver driver) {
		super(driver, By
				.cssSelector("body>div[eventproxy^=\"isc_HLayout_\"]>div>div>div>div>div[eventproxy^=\"isc_Img_\"]"));
	}

	public static void clearAllMenusAndWindows() {
		for (PageElementAdapter pageElement : _pageElements) {
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

	protected InteractionWindowAdapter getInteractionWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorInteractionWindow));
		WebElement interactionWindow = findElement(By.cssSelector(_cssSelectorInteractionWindow));
		List<WebElement> interactionButtons = interactionWindow.findElements(By
				.cssSelector("*>*>*>*>*>*>*>*>*>*>*>img"));// TODO: Sternchen
															// entfernen.
		InteractionWindowAdapter window = InteractionWindowAdapter.getInteractionWindow(interactionWindow, interactionButtons);
		_pageElements.add(window);
		return window;
	}

	protected TeleporterWindowAdapter getTeleporterWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorTeleporterWindow));
		WebElement teleporterWindow = findElement(By.cssSelector(_cssSelectorTeleporterWindow));
		WebElement teleporterCloseButton = teleporterWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> teleporterButtons = teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		TeleporterWindowAdapter window = TeleporterWindowAdapter.getTeleporterWindow(teleporterWindow, teleporterCloseButton,
				teleporterButtons);
		_pageElements.add(window);
		return window;
	}

	protected HighlightWindowAdapter getHighlightWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorHighlightWindow));
		WebElement highlightWindow = findElement(By.cssSelector(_cssSelectorHighlightWindow));
		WebElement highlightCloseButton = highlightWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> highlightButtons = highlightWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		HighlightWindowAdapter window = HighlightWindowAdapter.getHighlightWindow(highlightWindow, highlightCloseButton,
				highlightButtons);
		_pageElements.add(window);
		return window;
	}

	protected HighlightPresentationWindowAdapter getHighlightPresentationPresentationWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorHighlightPresentationWindow));
		WebElement highlightPresentationWindow = findElement(By.cssSelector(_cssSelectorHighlightPresentationWindow));
		WebElement highlightPresentationCloseButton = highlightPresentationWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> highlightPresentationButtons = highlightPresentationWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>img"));
		HighlightPresentationWindowAdapter window = HighlightPresentationWindowAdapter.getHighlightPresentationWindow(
				highlightPresentationWindow, highlightPresentationCloseButton, highlightPresentationButtons);
		_pageElements.add(window);
		return window;
	}

	protected PenWindowAdapter getPenWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorPenWindow));
		WebElement penWindow = findElement(By.cssSelector(_cssSelectorPenWindow));
		List<WebElement> penButtons = penWindow.findElements(By.cssSelector("*>*>*>*>*>*>*>img"));// TODO:
																									// Sternchen
																									// entfernen.
		WebElement penCloseButton = penWindow.findElements(By.cssSelector("*>*>*>*>*>img")).get(1);// TODO:
																									// Sternchen
																									// entfernen.
		PenWindowAdapter window = PenWindowAdapter.getPenWindow(penWindow, penButtons, penCloseButton);
		_pageElements.add(window);
		return window;
	}

	protected ZoomAndPanWindowAdapter getZoomWindow() {
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
		ZoomAndPanWindowAdapter window = ZoomAndPanWindowAdapter.getZoomWindow(zoomWindow, zoomButtons);
		_pageElements.add(window);
		return window;
	}

	protected MainmenuAdapter getMainMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorMainMenu));
		WebElement mainMenu = findElement(By.cssSelector(_cssSelectorMainMenu));
		List<WebElement> mainMenuButtons = mainMenu.findElements(By.cssSelector("div>div>div>img"));
		MainmenuAdapter menu = MainmenuAdapter.getMainMenu(mainMenu, mainMenuButtons);
		_pageElements.add(menu);
		return menu;
	}

	protected MapmenuAdapter getMapMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorMapMenu));
		WebElement mapMenu = findElement(By.cssSelector(_cssSelectorMapMenu));
		List<WebElement> mapMenuButtons = mapMenu.findElements(By.cssSelector("div>div>div>img"));
		MapmenuAdapter menu = MapmenuAdapter.getMapMenu(mapMenu, mapMenuButtons);
		_pageElements.add(menu);
		return menu;
	}

	protected TabmenuAdapter getTabMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu));
		WebElement tabMenu = findElement(By.cssSelector(_cssSelectorTabMenu));
		List<WebElement> buttons = tabMenu.findElements(By
				.cssSelector("div[eventproxy^=\"isc_ToolStrip_\"]>div>div>div>table>tbody>tr>td[align]"));
		TabmenuAdapter menu = TabmenuAdapter.getTabMenu(tabMenu, buttons);
		_pageElements.add(menu);
		return menu;
	}

	protected ContextmenuAdapter getContextMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorContextMenu));
		WebElement contextMenu = findElement(By.cssSelector(_cssSelectorContextMenu));
		ContextmenuAdapter menu = ContextmenuAdapter.getContextmenu(contextMenu);
		_pageElements.add(menu);
		return menu;
	}

	protected DialogueMapAdapter getDialogueMap() {
		waitUntilVisible(By.cssSelector(_cssSelectorDialogueMap));
		WebElement dialogueMap = findElement(By.cssSelector(_cssSelectorDialogueMap));
		List<WebElement> dialogueMapCategories = dialogueMap.findElements(By.cssSelector("g>g"));
		WebElement elucidationController = findElement(By.cssSelector(_cssSelectorElucidations));
		DialogueMapAdapter map = DialogueMapAdapter.getDialogueMap(dialogueMap, dialogueMapCategories, elucidationController);
		_pageElements.add(map);
		return map;
	}

	protected BoundingBoxesAdapter getBoundingBoxes() {
		waitUntilVisible(By.cssSelector(_cssSelectorBoundingBoxes));
		List<WebElement> boundingBoxes = findElements(By.cssSelector(_cssSelectorBoundingBoxes));
		BoundingBoxesAdapter boxes = BoundingBoxesAdapter.getBoundingBoxes(boundingBoxes);
		_pageElements.add(boxes);
		return boxes;
	}

	protected MapArrowWindowAdapter getMapArrowWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorMapArrowWindow));
		WebElement mapArrowWindow = findElement(By.cssSelector(_cssSelectorMapArrowWindow));
		List<WebElement> threeColumns = mapArrowWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div[eventproxy^=\"isc_VLayout_\"]"));
		WebElement closeButton = mapArrowWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> sizeButtons = mapArrowWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		List<WebElement> tails = threeColumns.get(0).findElements(By.cssSelector("div[eventproxy^=\"tail\"]"));
		List<WebElement> lines = threeColumns.get(1).findElements(By.cssSelector("div[eventproxy^=\"line\"]"));
		List<WebElement> heads = threeColumns.get(2).findElements(By.cssSelector("div[eventproxy^=\"head\"]"));
		MapArrowWindowAdapter window = MapArrowWindowAdapter.getMapArrowWindow(mapArrowWindow, closeButton, sizeButtons, tails,
				lines, heads);
		_pageElements.add(window);
		return window;
	}

	protected BasicShapeWindowAdapter getBasicShapeWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorBasicShapeWindow));
		WebElement basicShapeWindow = findElement(By.cssSelector(_cssSelectorBasicShapeWindow));
		WebElement closeButton = basicShapeWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> sizeButtons = basicShapeWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		List<WebElement> shapes = basicShapeWindow
				.findElements(By
						.cssSelector("div>div>div>div>div>div[eventproxy^=\"isc_TabSet\"]>div>div>div>div>div>div[eventproxy^=\"figureList\"]"));
		BasicShapeWindowAdapter window = BasicShapeWindowAdapter.getBasicShapeWindow(basicShapeWindow, closeButton, sizeButtons,
				shapes);
		_pageElements.add(window);
		return window;
	}

	protected LoadMapWindowAdapter getLoadMapWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorLoadMapWindow));
		WebElement loadMapWindow = findElement(By.cssSelector(_cssSelectorLoadMapWindow));
		WebElement closeButton = loadMapWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		LoadMapWindowAdapter window = LoadMapWindowAdapter.getLoadMapWindow(loadMapWindow, closeButton);
		_pageElements.add(window);
		return window;
	}

	protected ElucidationAttributesWindowAdapter getElucidationAttributesWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorElucidationAttributesWindow));
		WebElement elucidationAttributesWindow = findElement(By.cssSelector(_cssSelectorElucidationAttributesWindow));
		WebElement closeButton = elucidationAttributesWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		ElucidationAttributesWindowAdapter window = ElucidationAttributesWindowAdapter.getElucidationAttributesWindow(
				elucidationAttributesWindow, closeButton);
		_pageElements.add(window);
		return window;
	}
	
	protected AddAttachmentWindowAdapter getAddAttachmentWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorAddAttachmentWindow));
		WebElement addAttachmentWindow = findElement(By.cssSelector(_cssSelectorAddAttachmentWindow));
		WebElement closeButton = addAttachmentWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		WebElement okButton = addAttachmentWindow.findElement(By
				.cssSelector("div>div>div>div>div>div>div>div[eventproxy^=\"isc_Button_\"]"));
		List<WebElement> inputFields = addAttachmentWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>iframe"));
		AddAttachmentWindowAdapter window = AddAttachmentWindowAdapter.getAddAttachmentWindow(
				addAttachmentWindow, closeButton, okButton, inputFields);
		_pageElements.add(window);
		return window;
	}
	
	protected AttachmentsWindowAdapter getAttachmentsWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorAttachmentsWindow));
		WebElement attachmentWindow = findElement(By.cssSelector(_cssSelectorAttachmentsWindow));
		WebElement closeButton = attachmentWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		WebElement newButton = attachmentWindow.findElement(By
				.cssSelector("div>div>div>div>div>div>div>div[eventproxy^=\"isc_Button_\"]"));
		AttachmentsWindowAdapter window = AttachmentsWindowAdapter.getAttachmentsWindow(
				attachmentWindow, closeButton, newButton);
		_pageElements.add(window);
		return window;
	}

	protected ColorPickerAdapter getColorPicker() {
		waitUntilVisible(By.cssSelector(_cssSelectorColorPicker));
		List<WebElement> colorPickers = findElements(By.cssSelector(_cssSelectorColorPicker));
		ColorPickerAdapter picker =  ColorPickerAdapter.getColorPicker(colorPickers);
		_pageElements.add(picker);
		return picker;
	}

}
