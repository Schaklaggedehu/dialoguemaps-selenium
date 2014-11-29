package dialoguemaps.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dialoguemaps.pageelements.InterActionWindow;
import dialoguemaps.pageelements.MainMenu;
import dialoguemaps.pageelements.MapMenu;
import dialoguemaps.pageelements.PageElement;
import dialoguemaps.pageelements.PenWindow;
import dialoguemaps.pageelements.TabMenu;
import dialoguemaps.pageelements.ZoomWindow;

/**
 * 
 * @author janis
 */
public class PageElementCreator extends AbstractPage<DMPage> {

	final String _cssSelectorWholeMap = "body>div[eventproxy^=\"isc_VLayout_\"]";

	final String _cssSelectorMainMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div>div>div>div.toolStrip:nth-child(1)";
	MainMenu _mainMenu;

	final String _cssSelectorMapMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div>div>div>div.toolStrip:nth-child(2)";
	MapMenu _mapMenu;

	final String _cssSelectorTabMenu = "body>div[eventproxy^=\"isc_VLayout_\"]>"
			+ "div>div>div[eventproxy^=\"isc_GWTMapElementZoomUI\"]";
	TabMenu _tabMenu;

	final String _cssSelectorDialogueMap = "#DialogueMap";
	DialogueMap _dialogueMap;

	final String _cssSelectorInteractionWindow = "#isc_JR";// TODO temporäre id
															// durch debug-id
															// austauschen
	InterActionWindow _interactionWindow;

	final String _cssSelectorPenWindow = "#isc_9P";// TODO temporäre id durch
													// debug-id austauschen
	PenWindow _penWindow;

	final String _cssSelectorZoomWindow = "#isc_92";// TODO temporäre id durch
													// debug-id austauschen
	ZoomWindow _zoomWindow;

	private static Set<PageElement> _pageElements = new HashSet<>();

	PageElementCreator(WebDriver driver, By pageLocator) {
		super(driver, pageLocator);
	}

	public static void clearAllMenusAndWindows() {
		for (PageElement pageElement : _pageElements) {
			pageElement.clear();
		}
	}

	public void sleepXseconds(final long seconds) {
		for (int i = 0; i < 8; i++) {
			System.out.println("!!DEBUG ONLY!!DEBUG ONLY!!DEBUG ONLY!!    Start sleeping for " + seconds
					+ " seconds.    !!DEBUG ONLY!!DEBUG ONLY!!DEBUG ONLY!!");
		}
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
		}
	}

	public void logIntoMainpage(String name, String password) {
		WebElement nameField = findElement(By.cssSelector("#isc_P"));
		nameField.sendKeys(name);
		nameField.submit();
		WebElement passwordField = findElement(By.cssSelector("#isc_S"));
		passwordField.sendKeys(password);
		passwordField.submit();
		WebElement signIn = findElement(By.cssSelector("#isc_1E"));
		signIn.click();
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu + ">div.normal>div>div>div>div>div>table[width]"));

	}

	protected InterActionWindow getInteractionWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorInteractionWindow));
		WebElement interactionWindow = findElement(By.cssSelector(_cssSelectorInteractionWindow));
		List<WebElement> interactionButtons = findElements(By.cssSelector(_cssSelectorInteractionWindow
				+ ">*>*>*>*>*>*>*>*>*>*>*>img"));
		InterActionWindow window = InterActionWindow.getInterActionWindow(interactionWindow, interactionButtons);
		_pageElements.add(window);
		return window;
	}

	protected PenWindow getPenWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorPenWindow));
		WebElement penWindow = findElement(By.cssSelector(_cssSelectorPenWindow));
		List<WebElement> penButtons = findElements(By.cssSelector(_cssSelectorPenWindow + ">*>*>*>*>*>*>*>img"));
		WebElement penCloseButton = findElements(By.cssSelector(_cssSelectorPenWindow + ">*>*>*>*>*>img")).get(1);
		PenWindow window = PenWindow.getPenWindow(penWindow, penButtons, penCloseButton);
		_pageElements.add(window);
		return window;
	}

	protected ZoomWindow getZoomWindow() {
		waitUntilVisible(By.cssSelector(_cssSelectorZoomWindow));
		WebElement zoomWindow = findElement(By.cssSelector(_cssSelectorZoomWindow));
		List<WebElement> zoomButtons = findElements(By.cssSelector(_cssSelectorZoomWindow + ">*>*>*>img"));
		zoomButtons.addAll(findElements(By.cssSelector(_cssSelectorZoomWindow + ">*>*>*>*>*>img")));
		zoomButtons.add(findElement(By.cssSelector(_cssSelectorZoomWindow + ">*>*>*>*>*>*>*>img")));
		zoomButtons.remove(0);
		ZoomWindow window = ZoomWindow.getZoomWindow(zoomWindow, zoomButtons);
		_pageElements.add(window);
		return window;
	}

	protected MainMenu getMainMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorMainMenu));
		WebElement mainMenu = findElement(By.cssSelector(_cssSelectorMainMenu));
		List<WebElement> mainMenuButtons = findElements(By.cssSelector(_cssSelectorMainMenu + ">div>div>div>img"));
		MainMenu menu = MainMenu.getMainMenu(mainMenu, mainMenuButtons);
		_pageElements.add(menu);
		return menu;
	}

	protected MapMenu getMapMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorMapMenu));
		WebElement mapMenu = findElement(By.cssSelector(_cssSelectorMapMenu));
		List<WebElement> mapMenuButtons = findElements(By.cssSelector(_cssSelectorMapMenu + ">div>div>div>img"));
		MapMenu menu = MapMenu.getMapMenu(mapMenu, mapMenuButtons);
		_pageElements.add(menu);
		return menu;
	}

	protected TabMenu getTabMenu() {
		waitUntilVisible(By.cssSelector(_cssSelectorTabMenu));
		List<WebElement> tabs = findElements(By.cssSelector(_cssSelectorTabMenu
				+ ">div.normal>div>div>div>div>div>table[width]"));
		List<WebElement> buttons = findElements(By.cssSelector(_cssSelectorTabMenu
				+ ">div.toolStrip>div>div>div>table>tbody>tr>td[align]"));
		return TabMenu.getTabMenu(tabs, buttons);
	}

	protected DialogueMap getDialogueMap() {
		waitUntilVisible(By.cssSelector(_cssSelectorDialogueMap));
		WebElement dialogueMap = findElement(By.cssSelector(_cssSelectorDialogueMap));
		List<WebElement> dialogueMapCategories = findElements(By.cssSelector(_cssSelectorDialogueMap + ">g>g"));
		WebElement dmShapeElementCategory = dialogueMapCategories.get(0);
		WebElement dmDrawElementCategory = dialogueMapCategories.get(1);
		DialogueMap map = DialogueMap.getDialogueMap(dialogueMap, dmShapeElementCategory, dmDrawElementCategory);
		_pageElements.add(map);
		return map;
	}

}
