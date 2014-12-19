package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class DialogueMap implements PageElement {

	private static DialogueMap _map;
	private WebElement _dialogueMap;
	private static List<WebElement> _shapeElements;
	private static List<WebElement> _drawElements;
	private static List<WebElement> _previewElements;

	public static DialogueMap getDialogueMap(WebElement dialogueMap, List<WebElement> dmShapeElements,
			List<WebElement> dmdrawElements, List<WebElement> previewElements) {
		if (_map == null) {
			_map = new DialogueMap(dialogueMap);
		}
		_shapeElements = dmShapeElements;
		_drawElements = dmdrawElements;
		_previewElements = previewElements;

		return _map;
	}

	private DialogueMap(WebElement dialogueMap) {
		_dialogueMap = dialogueMap;
	}

	public WebElement getMap() {
		return _dialogueMap;
	}

	public List<WebElement> getAllPreviewElements() {
		return _previewElements;
	}

	public List<WebElement> getAllShapeElements() {
		return _shapeElements;
	}

	public List<WebElement> getAllDrawElements() {
		return _drawElements;
	}

	public WebElement getLastPreviewElement() {
		return _previewElements.get(_previewElements.size() - 1);
	}

	public WebElement getLastShapeElement() {
		return _shapeElements.get(_shapeElements.size() - 1);
	}

	public WebElement getLastDrawElement() {
		return _drawElements.get(_drawElements.size() - 1);
	}

	@Override
	public void clear() {
		_map = null;
	}

}
