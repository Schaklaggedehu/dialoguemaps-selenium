package dialoguemaps.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.DialogueMap;
import dialoguemaps.pageelements.InteractionWindow;
import dialoguemaps.pageelements.Mainmenu;
import dialoguemaps.pageelements.MapMenu;
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
	final String _cssSelectorDialogueMap = "#DialogueMap";
	final String _cssSelectorTeleporterWindow = "body>div[eventproxy^=\"isc_TeleporterView_\"][ role=\"dialog\"]";

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
	MapMenu _mapMenu;
	Tabmenu _tabMenu;
	DialogueMap _dialogueMap;
	InteractionWindow _interactionWindow;
	TeleporterWindow _teleporterWindow;
	PenWindow _penWindow;
	ZoomWindow _zoomWindow;

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
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu + ">div[eventproxy^=\"isc_TabSet_\"]>div>div>div>div>div>table[width]"));

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

	protected MapMenu getMapMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorMapMenu));
		WebElement mapMenu = findElement(By.cssSelector(_cssSelectorMapMenu));
		List<WebElement> mapMenuButtons = mapMenu.findElements(By.cssSelector("div>div>div>img"));
		MapMenu menu = MapMenu.getMapMenu(mapMenu, mapMenuButtons);
		_pageElements.add(menu);
		return menu;
	}

	protected Tabmenu getTabMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu));
		WebElement tabMenu = findElement(By.cssSelector(_cssSelectorTabMenu));
		List<WebElement> tabs = tabMenu.findElements(By.cssSelector("div[eventproxy^=\"isc_TabSet_\"]>div>div>div>div>div>table[width]"));
		List<WebElement> buttons = tabMenu.findElements(By
				.cssSelector("div[eventproxy^=\"isc_ToolStrip_\"]>div>div>div>table>tbody>tr>td[align]"));
		return Tabmenu.getTabMenu(tabs, buttons);
	}

	protected DialogueMap getDialogueMap() {
		waitUntilVisible(By.cssSelector(_cssSelectorDialogueMap));
		WebElement dialogueMap = findElement(By.cssSelector(_cssSelectorDialogueMap));
		List<WebElement> dialogueMapCategories = dialogueMap.findElements(By.cssSelector("g>g"));
		WebElement dmShapeElementCategory = dialogueMapCategories.get(0);
		WebElement dmDrawElementCategory = dialogueMapCategories.get(1);
		DialogueMap map = DialogueMap.getDialogueMap(dialogueMap, dmShapeElementCategory, dmDrawElementCategory);
		_pageElements.add(map);
		return map;
	}

}
