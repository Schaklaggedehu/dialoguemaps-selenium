package dialoguemaps.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.AddAttachmentWindowAdapter;
import dialoguemaps.pageelements.AttachmentListWindowAdapter;
import dialoguemaps.pageelements.AttachmentsWindowAdapter;
import dialoguemaps.pageelements.BasicShapeWindowAdapter;
import dialoguemaps.pageelements.BoundingBoxesAdapter;
import dialoguemaps.pageelements.ChatWindowAdapter;
import dialoguemaps.pageelements.ColorPickerAdapter;
import dialoguemaps.pageelements.ContextmenuAdapter;
import dialoguemaps.pageelements.DialogueMapAdapter;
import dialoguemaps.pageelements.ElucidationAttributesWindowAdapter;
import dialoguemaps.pageelements.HelicopterWindowAdapter;
import dialoguemaps.pageelements.HighlightPresentationWindowAdapter;
import dialoguemaps.pageelements.HighlightWindowAdapter;
import dialoguemaps.pageelements.InfoWindowAdapter;
import dialoguemaps.pageelements.InteractionWindowAdapter;
import dialoguemaps.pageelements.LoadMapWindowAdapter;
import dialoguemaps.pageelements.LoginmenuAdapter;
import dialoguemaps.pageelements.MainmenuAdapter;
import dialoguemaps.pageelements.MapArrowWindowAdapter;
import dialoguemaps.pageelements.MapmenuAdapter;
import dialoguemaps.pageelements.PageElementAdapter;
import dialoguemaps.pageelements.PenWindowAdapter;
import dialoguemaps.pageelements.SettingsWindowAdapter;
import dialoguemaps.pageelements.ShapeWindowAdapter;
import dialoguemaps.pageelements.StructureGraphWindowAdapter;
import dialoguemaps.pageelements.TabmenuAdapter;
import dialoguemaps.pageelements.TeleporterWindowAdapter;
import dialoguemaps.pageelements.TextEditorWindowAdapter;
import dialoguemaps.pageelements.ZoomAndPanWindowAdapter;

/**
 * The DM webpage elements.
 * Examples: MainMenu, MapMenu, TabMenu, ContextMenu, xyzWindow, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version Dezember 2014
 */
public class DMPageElements extends AbstractPage<DMPage> {

	final String _cssSelectorContextMenu = "body>div[eventproxy^=\"isc_VLayout_\"]"
			+ ">div>div>div>div>div>div>div[eventproxy^=\"isc_Menu_\"]";
	final String _cssSelectorLoginMenu = "body>div[eventproxy^=\"isc_HLayout_\"]>div>div[style*=\"cursor: default;\"]>div";
	final String _cssSelectorMainMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div>div>div>div.toolStrip:nth-child(1)";
	final String _cssSelectorMapMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div>div>div>div.toolStrip:nth-child(2)";
	final String _cssSelectorTabMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div[eventproxy^=\"isc_GWTMapElementZoomUI\"]";
	final String _cssSelectorWholeMap = "body>div[eventproxy^=\"isc_VLayout_\"]";// Zum Zeichnen auf Karte

	final String _cssSelectorBoundingBoxes = "#BoundingBoxOverlay>g";
	final String _cssSelectorColorPicker = "body>div[eventproxy^=\"isc_ColorPicker_\"][role=\"dialog\"]";
	final String _cssSelectorDialogueMap = "#DialogueMap";
	final String _cssSelectorElucidations = "#ElucidationController";

	final String _cssSelectorAddAttachmentWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_AttachmentAddView_\"]";
	final String _cssSelectorAttachmentListWindow = "body>div[eventproxy^=\"isc_AttachmentListWindow_\"]>div:not([eventproxy*=\"modalMask\"])";
	final String _cssSelectorAttachmentsWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_AttachmentAddItemView_\"]";
	final String _cssSelectorBasicShapeWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_MapFigureView_\"]";
	final String _cssSelectorChatWindow = "body>div[eventproxy^=\"isc_ChatWindow_\"]>div";
	final String _cssSelectorElucidationAttributesWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_ElucidationContextView_\"]";
	final String _cssSelectorHelicopterWindow = "body>div[eventproxy^=\"isc_HelicopterView_\"]>div";
	final String _cssSelectorHighlightPresentationWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_HighlightPresentationView_\"]";
	final String _cssSelectorHighlightWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_HighlightView_\"]";
	final String _cssSelectorInfoWindow = "body>div.normal[eventProxy^=\"isc_InfoWindow_\"]:not([style*=\"visibility: hidden\"])>div";
	final String _cssSelectorInteractionWindow = "body>div[eventproxy^=\"isc_InteractionView_\"]>div";
	final String _cssSelectorLoadMapWindow = "body>div[class=\"normal\"][eventproxy^=\"isc_DialogLoadMapView_\"]>div";
	final String _cssSelectorMapArrowWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_MapArrowView_\"]";
	final String _cssSelectorPenWindow = "body>div[eventproxy^=\"isc_MapFreeFormView\"]>div";
	final String _cssSelectorSettingsWindow = "body>div[eventproxy^=\"isc_SettingsWindow_\"]>div[eventproxy^=\"isc_SettingsWindow_\"]:not([eventproxy*=\"modalMask\"])";
	final String _cssSelectorShapeWindow = "body>div[eventproxy^=\"isc_ElementSetCollectionView_\"]>div";
	final String _cssSelectorStructureGraphWindow = "body>div[eventproxy^=\"isc_StructureGraphWindow_\"]>div[eventproxy^=\"isc_StructureGraphWindow_\"]";
	final String _cssSelectorTeleporterWindow = "body>div[role=\"dialog\"][eventproxy^=\"isc_TeleporterView_\"]";
	final String _cssSelectorTextEditorWindow = "body>div[eventproxy^=\"isc_MapTextView_\"]>div";
	final String _cssSelectorZoomWindow = "body>div[eventproxy^=\"isc_PanningView_\"]";
	// ---------------------------------------------------------------------------
	ContextmenuAdapter _contextmenuAdapter1;
	LoginmenuAdapter _loginmenuAdapter1;
	MainmenuAdapter _mainmenuAdapter1;
	MapmenuAdapter _mapmenuAdapter1;
	TabmenuAdapter _tabmenuAdapter1;
	// ---------------------------------------------------------------------------
	BoundingBoxesAdapter _boundingBoxAdapter1;
	ColorPickerAdapter _colorPickerAdapter1;
	DialogueMapAdapter _dialogueMapAdapter1;
	// ---------------------------------------------------------------------------
	AddAttachmentWindowAdapter _addAttachmentWindowAdapter1;
	AttachmentListWindowAdapter _attachmentListWindowAdapter1;
	AttachmentsWindowAdapter _attachmentsWindowAdapter1;
	BasicShapeWindowAdapter _basicShapeWindowAdapter1;
	ChatWindowAdapter _chatWindowAdapter1;
	ElucidationAttributesWindowAdapter _elucidationAttributeWindowAdapter1;
	HelicopterWindowAdapter _helicopterWindowAdapter1;
	HighlightPresentationWindowAdapter _highlightPresentationWindowAdapter1;
	HighlightWindowAdapter _highlightWindowAdapter1;
	InfoWindowAdapter _infoWindowAdapter1;
	InteractionWindowAdapter _interactionWindowAdapter1;
	LoadMapWindowAdapter _loadMapWindowAdapter1;
	MapArrowWindowAdapter _mapArrowWindowAdapter1;
	PenWindowAdapter _penWindowAdapter1;
	SettingsWindowAdapter _settingsWindowAdapter1 ;
	ShapeWindowAdapter _shapeWindowAdapter1;
	StructureGraphWindowAdapter _structureGraphWindowAdapter1;
	TeleporterWindowAdapter _teleporterWindowAdapter1;
	TextEditorWindowAdapter _textEditorWindowAdapter1;
	ZoomAndPanWindowAdapter _zoomWindowAdapter1;
	// ---------------------------------------------------------------------------

	private static Set<PageElementAdapter> _pageElementAdapters = new HashSet<>();

	DMPageElements(WebDriver driver) {
		super(driver, By
				.cssSelector("body>div[eventproxy^=\"isc_HLayout_\"]>div>div>div>div>div[eventproxy^=\"isc_Img_\"]"));
	}

	public static void clearAllPageElementAdapters() {
		for (PageElementAdapter pageElement : _pageElementAdapters) {
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
		_loginmenuAdapter1 = createLoginmenuAdapter();
		WebElement nameField = _loginmenuAdapter1.getSignInUsernameField();
		nameField.sendKeys(name);
		nameField.submit();
		WebElement passwordField = _loginmenuAdapter1.getSignInPasswordField();
		passwordField.sendKeys(password);
		passwordField.submit();
		WebElement signIn = _loginmenuAdapter1.getSignInButton();
		signIn.click();
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu
				+ ">div[eventproxy^=\"isc_TabSet_\"]>div>div>div>div>div>table[width]"));
	}

	protected InteractionWindowAdapter createInteractionWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorInteractionWindow));
		WebElement interactionWindow = findElement(By.cssSelector(_cssSelectorInteractionWindow));
		WebElement closeButton = interactionWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> interactionButtons = interactionWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>img:not([src*=\"empty.png\"])"));
		InteractionWindowAdapter window = InteractionWindowAdapter.createInteractionWindowAdapter(interactionWindow,
				closeButton, interactionButtons);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected HelicopterWindowAdapter createHelicopterWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorHelicopterWindow));
		WebElement helicopterWindow = findElement(By.cssSelector(_cssSelectorHelicopterWindow));
		WebElement closeButton = helicopterWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		HelicopterWindowAdapter window = HelicopterWindowAdapter.createHelicopterWindowAdapter(helicopterWindow,
				closeButton);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected ChatWindowAdapter createChatWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorChatWindow));
		WebElement chatWindow = findElement(By.cssSelector(_cssSelectorChatWindow));
		WebElement closeButton = chatWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		WebElement inviteButton = chatWindow.findElement(By.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div>div>div>table>tbody>tr>td>div"));
		WebElement textarea = chatWindow.findElement(By.cssSelector("div>div>div>div>div>div>div>div>div>div>div>div>form>table>tbody>tr>td>textarea"));
		List<WebElement> selectItems = chatWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>form>table>tbody>tr>td>table.selectItemControl"));
		ChatWindowAdapter window = ChatWindowAdapter.createChatWindowAdapter(chatWindow,
				closeButton, inviteButton, textarea, selectItems);
		_pageElementAdapters.add(window);
		return window;
	}

	protected InfoWindowAdapter createInfoWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorInfoWindow));
		WebElement infoWindow = findElement(By.cssSelector(_cssSelectorInfoWindow));
		WebElement modalmask = findElement(By.cssSelector("body>div[eventProxy*=\"modalMask\"]:not([style*=\"visibility: hidden\"])"));
		InfoWindowAdapter window = InfoWindowAdapter.createInfoWindowAdapter(infoWindow, modalmask);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected ShapeWindowAdapter createShapeWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorShapeWindow));
		WebElement shapeWindow = findElement(By.cssSelector(_cssSelectorShapeWindow));
		WebElement closeButton = shapeWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> tabs = shapeWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div.gwt-HTML"));
		ShapeWindowAdapter window = ShapeWindowAdapter.createShapeWindowAdapter(shapeWindow, closeButton, tabs);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected TextEditorWindowAdapter createTextEditorWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorTextEditorWindow));
		WebElement textEditorWindow = findElement(By.cssSelector(_cssSelectorTextEditorWindow));
		WebElement closeButton = textEditorWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> buttons = textEditorWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>table>tbody>tr>td>div>img"));
		List<WebElement> forms = textEditorWindow.findElements(By.cssSelector("div>div>div>div>div>div>div>div>form"));
		WebElement textfield = findElement(By.cssSelector("div>div>div>div>div>div>form"));
		TextEditorWindowAdapter window = TextEditorWindowAdapter.createTextEditorWindowAdapter(textEditorWindow, closeButton, buttons, forms, textfield);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected AttachmentListWindowAdapter createAttachmentListWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorAttachmentListWindow));
		WebElement attachmentListWindow = findElement(By.cssSelector(_cssSelectorAttachmentListWindow));
		WebElement closeButton = attachmentListWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> inputFields = attachmentListWindow.findElements(By.cssSelector("div>div>div>div>div>div>form>table>tbody>tr>td.formCell"));
		AttachmentListWindowAdapter window = AttachmentListWindowAdapter.createAttachmentListWindowAdapter(attachmentListWindow, closeButton, inputFields);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected StructureGraphWindowAdapter createStructureGraphWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorStructureGraphWindow));
		WebElement structureGraphWindow = findElement(By.cssSelector(_cssSelectorStructureGraphWindow));
		WebElement closeButton = structureGraphWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> buttons = structureGraphWindow.findElements(By.cssSelector("div>div>div[eventproxy^=\"isc_ToolStrip_\"]>div>div[eventproxy^=\"isc_Img_\"]"));
		StructureGraphWindowAdapter window = StructureGraphWindowAdapter.createStructureGraphWindowAdapter(structureGraphWindow, closeButton, buttons);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected SettingsWindowAdapter createSettingsWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorSettingsWindow));
		WebElement settingsWindow = findElement(By.cssSelector(_cssSelectorSettingsWindow));
		WebElement closeButton = settingsWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		WebElement saveButton = settingsWindow.findElement(By.cssSelector("div>div>div>div>div.stretchImgButton[eventproxy*=\"Button\"]"));
		List<WebElement> inputFields = settingsWindow.findElements(By.cssSelector("div>div>div>div>form>table>tbody>tr>td>input"));
		SettingsWindowAdapter window = SettingsWindowAdapter.createSettingsWindowAdapter(settingsWindow, closeButton, saveButton, inputFields);
		_pageElementAdapters.add(window);
		return window;
	}
	
	protected LoginmenuAdapter createLoginmenuAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorLoginMenu));
		WebElement loginmenu = findElement(By.cssSelector(_cssSelectorLoginMenu));
		List<WebElement> loginmenuButtons = loginmenu.findElements(By
				.cssSelector("div[role=\"label\"]>div[eventproxy^=\"isc_IButton_\"]"));
		List<WebElement> loginmenuFields = loginmenu.findElements(By
				.cssSelector("div>div>form>table>tbody>tr>td>input"));
		LoginmenuAdapter menu = LoginmenuAdapter.createLoginmenuAdapter(loginmenuButtons, loginmenuFields);
		_pageElementAdapters.add(menu);
		return menu;
	}
	
	protected TeleporterWindowAdapter createTeleporterWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorTeleporterWindow));
		WebElement teleporterWindow = findElement(By.cssSelector(_cssSelectorTeleporterWindow));
		WebElement teleporterCloseButton = teleporterWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> teleporterButtons = teleporterWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		TeleporterWindowAdapter window = TeleporterWindowAdapter.createTeleporterWindowAdapter(teleporterWindow,
				teleporterCloseButton, teleporterButtons);
		_pageElementAdapters.add(window);
		return window;
	}

	protected HighlightWindowAdapter createHighlightWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorHighlightWindow));
		WebElement highlightWindow = findElement(By.cssSelector(_cssSelectorHighlightWindow));
		WebElement highlightCloseButton = highlightWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> highlightButtons = highlightWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		HighlightWindowAdapter window = HighlightWindowAdapter.createHighlightWindowAdapter(highlightWindow,
				highlightCloseButton, highlightButtons);
		_pageElementAdapters.add(window);
		return window;
	}

	protected HighlightPresentationWindowAdapter createHighlightPresentationWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorHighlightPresentationWindow));
		WebElement highlightPresentationWindow = findElement(By.cssSelector(_cssSelectorHighlightPresentationWindow));
		WebElement highlightPresentationCloseButton = highlightPresentationWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> highlightPresentationButtons = highlightPresentationWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>img"));
		HighlightPresentationWindowAdapter window = HighlightPresentationWindowAdapter
				.createHighlightPresentationWindowAdapter(highlightPresentationWindow,
						highlightPresentationCloseButton, highlightPresentationButtons);
		_pageElementAdapters.add(window);
		return window;
	}

	protected PenWindowAdapter createPenWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorPenWindow));
		WebElement penWindow = findElement(By.cssSelector(_cssSelectorPenWindow));
		List<WebElement> penButtons = penWindow.findElements(By.cssSelector("div>div>div>div>div>div>img"));
		WebElement closeButton = penWindow.findElement(By.cssSelector("div>div>div[eventproxy*=\"closeButton\"]"));
		PenWindowAdapter window = PenWindowAdapter.createPenWindowAdapter(penWindow, penButtons, closeButton);
		_pageElementAdapters.add(window);
		return window;
	}

	protected ZoomAndPanWindowAdapter createZoomWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorZoomWindow));
		WebElement zoomWindow = findElement(By.cssSelector(_cssSelectorZoomWindow));
		List<WebElement> zoomButtons = zoomWindow.findElements(By.cssSelector("div>div>div>div>div>img"));
		List<WebElement> panButtons = zoomWindow.findElements(By.cssSelector("div>div>div>img[src*=\"png\"]"));
		WebElement eyeButton = zoomWindow.findElement(By.cssSelector("div>div>div>div>div>img"));
		ZoomAndPanWindowAdapter window = ZoomAndPanWindowAdapter.createZoomWindowAdapter(zoomWindow, zoomButtons, panButtons, eyeButton);
		_pageElementAdapters.add(window);
		return window;
	}

	protected MainmenuAdapter createMainMenuAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorMainMenu));
		WebElement mainMenu = findElement(By.cssSelector(_cssSelectorMainMenu));
		List<WebElement> mainMenuButtons = mainMenu.findElements(By.cssSelector("div>div>div>img"));
		MainmenuAdapter menu = MainmenuAdapter.createMainMenuAdapter(mainMenu, mainMenuButtons);
		_pageElementAdapters.add(menu);
		return menu;
	}

	protected MapmenuAdapter createMapMenuAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorMapMenu));
		WebElement mapMenu = findElement(By.cssSelector(_cssSelectorMapMenu));
		List<WebElement> mapMenuButtons = mapMenu.findElements(By.cssSelector("div>div>div>img"));
		MapmenuAdapter menu = MapmenuAdapter.createMapMenuAdapter(mapMenu, mapMenuButtons);
		_pageElementAdapters.add(menu);
		return menu;
	}

	protected TabmenuAdapter createTabMenuAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu));
		WebElement tabMenu = findElement(By.cssSelector(_cssSelectorTabMenu));
		List<WebElement> buttons = tabMenu.findElements(By
				.cssSelector("div[eventproxy^=\"isc_ToolStrip_\"]>div>div>div>table>tbody>tr>td[align]"));
		TabmenuAdapter menu = TabmenuAdapter.createTabMenuAdapter(tabMenu, buttons);
		_pageElementAdapters.add(menu);
		return menu;
	}

	protected ContextmenuAdapter createContextMenuAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorContextMenu));
		WebElement contextMenu = findElement(By.cssSelector(_cssSelectorContextMenu));
		ContextmenuAdapter menu = ContextmenuAdapter.createContextMenuAdapter(contextMenu);
		_pageElementAdapters.add(menu);
		return menu;
	}

	protected DialogueMapAdapter createDialogueMapAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorDialogueMap));
		WebElement dialogueMap = findElement(By.cssSelector(_cssSelectorDialogueMap));
		List<WebElement> dialogueMapCategories = dialogueMap.findElements(By.cssSelector("g>g"));
		WebElement elucidationController = findElement(By.cssSelector(_cssSelectorElucidations));
		DialogueMapAdapter map = DialogueMapAdapter.createDialogueMapAdapter(dialogueMap, dialogueMapCategories,
				elucidationController);
		_pageElementAdapters.add(map);
		return map;
	}

	protected BoundingBoxesAdapter createBoundingBoxesAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorBoundingBoxes));
		List<WebElement> boundingBoxes = findElements(By.cssSelector(_cssSelectorBoundingBoxes));
		BoundingBoxesAdapter boxes = BoundingBoxesAdapter.createBoundingBoxesAdapter(boundingBoxes);
		_pageElementAdapters.add(boxes);
		return boxes;
	}

	protected MapArrowWindowAdapter createMapArrowWindowAdapter() {
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
		MapArrowWindowAdapter window = MapArrowWindowAdapter.createMapArrowWindowAdapter(mapArrowWindow, closeButton,
				sizeButtons, tails, lines, heads);
		_pageElementAdapters.add(window);
		return window;
	}

	protected BasicShapeWindowAdapter createBasicShapeWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorBasicShapeWindow));
		WebElement basicShapeWindow = findElement(By.cssSelector(_cssSelectorBasicShapeWindow));
		WebElement closeButton = basicShapeWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		List<WebElement> sizeButtons = basicShapeWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>img"));
		List<WebElement> shapes = basicShapeWindow
				.findElements(By
						.cssSelector("div>div>div>div>div>div[eventproxy^=\"isc_TabSet\"]>div>div>div>div>div>div[eventproxy^=\"figureList\"]"));
		BasicShapeWindowAdapter window = BasicShapeWindowAdapter.createBasicShapeWindowAdapter(basicShapeWindow,
				closeButton, sizeButtons, shapes);
		_pageElementAdapters.add(window);
		return window;
	}

	protected LoadMapWindowAdapter createLoadMapWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorLoadMapWindow));
		WebElement loadMapWindow = findElement(By.cssSelector(_cssSelectorLoadMapWindow));
		WebElement closeButton = loadMapWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		LoadMapWindowAdapter window = LoadMapWindowAdapter.createLoadMapWindowAdapter(loadMapWindow, closeButton);
		_pageElementAdapters.add(window);
		return window;
	}

	protected ElucidationAttributesWindowAdapter createElucidationAttributesWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorElucidationAttributesWindow));
		WebElement elucidationAttributesWindow = findElement(By.cssSelector(_cssSelectorElucidationAttributesWindow));
		WebElement closeButton = elucidationAttributesWindow.findElement(By
				.cssSelector("div>div>div>div>div[eventproxy*=\"closeButton\"]"));
		ElucidationAttributesWindowAdapter window = ElucidationAttributesWindowAdapter
				.createElucidationAttributesWindowAdapter(elucidationAttributesWindow, closeButton);
		_pageElementAdapters.add(window);
		return window;
	}

	protected AddAttachmentWindowAdapter createAddAttachmentWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorAddAttachmentWindow));
		WebElement addAttachmentWindow = findElement(By.cssSelector(_cssSelectorAddAttachmentWindow));
		WebElement closeButton = addAttachmentWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		WebElement okButton = addAttachmentWindow.findElement(By
				.cssSelector("div>div>div>div>div>div>div>div[eventproxy^=\"isc_Button_\"]"));
		List<WebElement> inputFields = addAttachmentWindow.findElements(By
				.cssSelector("div>div>div>div>div>div>div>div>div>div>iframe"));
		AddAttachmentWindowAdapter window = AddAttachmentWindowAdapter.createAddAttachmentWindowAdapter(
				addAttachmentWindow, closeButton, okButton, inputFields);
		_pageElementAdapters.add(window);
		return window;
	}

	protected AttachmentsWindowAdapter createAttachmentsWindowAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorAttachmentsWindow));
		WebElement attachmentWindow = findElement(By.cssSelector(_cssSelectorAttachmentsWindow));
		WebElement closeButton = attachmentWindow.findElement(By
				.cssSelector("div>div>div>div[eventproxy*=\"closeButton\"]"));
		WebElement newButton = attachmentWindow.findElement(By
				.cssSelector("div>div>div>div>div>div>div>div[eventproxy^=\"isc_Button_\"]"));
		AttachmentsWindowAdapter window = AttachmentsWindowAdapter.createAttachmentsWindowAdapter(attachmentWindow,
				closeButton, newButton);
		_pageElementAdapters.add(window);
		return window;
	}

	protected ColorPickerAdapter createColorPickerAdapter() {
		waitUntilVisible(By.cssSelector(_cssSelectorColorPicker));
		List<WebElement> colorPickers = findElements(By.cssSelector(_cssSelectorColorPicker));
		ColorPickerAdapter picker = ColorPickerAdapter.createColorPickerAdapter(colorPickers);
		_pageElementAdapters.add(picker);
		return picker;
	}

}
