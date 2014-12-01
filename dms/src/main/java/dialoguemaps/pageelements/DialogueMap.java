package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DialogueMap implements PageElement {

	private static DialogueMap _map;
	private WebElement _dialogueMap;
	private WebElement _dmShapeElementCategory;
	private WebElement _dmdrawElementCategory;

	@Override
	public void clear() {
		// Not a singleton, therefore no need for action
	}

	public static DialogueMap getDialogueMap(WebElement dialogueMap, WebElement dmShapeElementCategory,
			WebElement dmdrawElementCategory) {
		if(_map==null){
			_map = new DialogueMap(dialogueMap, dmShapeElementCategory, dmdrawElementCategory);
		}
		return _map;
	}

	private DialogueMap(WebElement dialogueMap, WebElement dmShapeElementCategory, WebElement dmdrawElementCategory) {
		_dialogueMap = dialogueMap;
		_dmShapeElementCategory = dmShapeElementCategory;
		_dmdrawElementCategory = dmdrawElementCategory;
	}

	public WebElement getMap() {
		return _dialogueMap;
	}

	public WebElement getCategoryDMShapes() {
		return _dmShapeElementCategory;
	}

	public WebElement getCategoryDMDrawings() {
		return _dmdrawElementCategory;
	}

	public List<WebElement> getAllShapeElements() {
		return _dmShapeElementCategory.findElements(By.cssSelector("g"));
	}

	public List<WebElement> getAllDrawElements() {
		return _dmdrawElementCategory.findElements(By.cssSelector("g"));
	}

}
