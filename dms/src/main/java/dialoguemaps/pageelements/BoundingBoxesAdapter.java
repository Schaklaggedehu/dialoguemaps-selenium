package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BoundingBoxesAdapter implements PageElementAdapter {

	private static BoundingBoxesAdapter _boxes;
	private List<WebElement> _boundingBoxes;

	public static BoundingBoxesAdapter createBoundingBoxesAdapter(List<WebElement> boundingBoxes) {
		if (_boxes == null) {
			_boxes = new BoundingBoxesAdapter(boundingBoxes);
		}
		return _boxes;
	}

	private BoundingBoxesAdapter(List<WebElement> boundingBoxes) {
		_boundingBoxes = boundingBoxes;
	}

	public List<WebElement> getBoundingBoxes() {
		return _boundingBoxes;
	}

	public WebElement getLastBoundingBox() {
		return _boundingBoxes.get(_boundingBoxes.size() - 1);
	}

	public WebElement getRectangle(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>rect"));
	}

	public WebElement getResizeButtonNW(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>circle:nth-child(3)"));
	}

	public WebElement getResizeButtonNE(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>circle:nth-child(4)"));
	}

	public WebElement getResizeButtonSW(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>circle:nth-child(5)"));
	}

	public WebElement getResizeButtonSE(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>circle:nth-child(6)"));
	}

	public WebElement getCloseButton(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(1)"));
	}

	public WebElement getContextMenuButton(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(2)"));
	}

	public boolean isAttachmentIconVisible(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(5)")).isDisplayed();
	}

	public boolean isSubmapIconVisible(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(6)")).isDisplayed();
	}

	public WebElement getResizeButtonN(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(3)>rect:nth-child(1)"));
	}

	public WebElement getResizeButtonS(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(3)>rect:nth-child(2)"));
	}

	public WebElement getResizeButtonW(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(4)>rect:nth-child(1)"));
	}

	public WebElement getResizeButtonE(WebElement boundingBox) {
		return boundingBox.findElement(By.cssSelector("g>g>g:nth-child(4)>rect:nth-child(2)"));
	}

	@Override
	public void clear() {
		_boxes = null;
	}
}