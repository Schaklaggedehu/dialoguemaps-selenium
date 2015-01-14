package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the Dialogue Map. Elements can be
 * e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class DialogueMapAdapter implements PageElementAdapter {

	private WebElement _dialogueMap;
	private List<WebElement> _dialogueMapCategories;
	private WebElement _elucidationController;

	public static DialogueMapAdapter createDialogueMapAdapter(WebElement dialogueMap,
			List<WebElement> dialogueMapCategories, WebElement elucidationController) {
		return new DialogueMapAdapter(dialogueMap, dialogueMapCategories, elucidationController);
	}

	private DialogueMapAdapter(WebElement dialogueMap, List<WebElement> dialogueMapCategories,
			WebElement elucidationController) {
		_dialogueMap = dialogueMap;
		_dialogueMapCategories = dialogueMapCategories;
		_elucidationController = elucidationController;
	}

	public WebElement getMap() {
		return _dialogueMap;
	}

	public List<WebElement> getAllPreviewElements() {
		return _dialogueMapCategories.get(2).findElements(By.cssSelector("svg"));
	}

	public List<WebElement> getAllShapeElements() {
		return _dialogueMapCategories.get(0).findElements((By.cssSelector("g")));
	}

	public List<WebElement> getAllDrawElements() {
		return _dialogueMapCategories.get(1).findElements((By.cssSelector("g")));
	}

	public List<WebElement> getAllElucidationElements() {
		return _elucidationController.findElements(By.cssSelector("g"));
	}

	public WebElement getLastPreviewElement() {
		List<WebElement> previewElements = _dialogueMapCategories.get(2).findElements(By.cssSelector("svg"));
		return previewElements.get(previewElements.size() - 1);
	}

	public WebElement getLastShapeElement() {
		List<WebElement> shapeElements = _dialogueMapCategories.get(0).findElements((By.cssSelector("g")));
		return shapeElements.get(shapeElements.size() - 1);
	}

	public WebElement getLastDrawElement() {
		List<WebElement> drawElements = _dialogueMapCategories.get(1).findElements((By.cssSelector("g")));
		return drawElements.get(drawElements.size() - 1);
	}

	public WebElement getLastElucidationElement() {
		List<WebElement> elucidationElements = _elucidationController.findElements(By.cssSelector("g"));
		return elucidationElements.get(elucidationElements.size() - 1);
	}
}
