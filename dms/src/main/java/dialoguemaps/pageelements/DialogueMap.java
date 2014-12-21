package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class DialogueMap implements PageElement {

	private static DialogueMap _map;
	private WebElement _dialogueMap;
	private static List<WebElement> _shapeElements;
	private static List<WebElement> _drawElements;
	private static List<WebElement> _previewElements;
	private static List<WebElement> _elucidationElements;

	public static DialogueMap getDialogueMap(WebElement dialogueMap, List<WebElement> dmShapeElements,
			List<WebElement> dmdrawElements, List<WebElement> previewElements, List<WebElement> elucidationElements) {
		if (_map == null) {
			_map = new DialogueMap(dialogueMap);
		}
		_shapeElements = dmShapeElements;
		_drawElements = dmdrawElements;
		_previewElements = previewElements;
		_elucidationElements = elucidationElements;

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

	public List<WebElement> getAllElucidationElements() {
		return _elucidationElements;
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

	public WebElement getLastElucidationElement() {
		return _elucidationElements.get(_elucidationElements.size() - 1);
	}

	@Override
	public void clear() {
		_map = null;
	}

}
