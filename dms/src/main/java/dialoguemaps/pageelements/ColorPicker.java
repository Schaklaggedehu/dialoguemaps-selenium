package dialoguemaps.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * The DM ZoomWindow.
 * 
 * @author janis
 * @edit Martin
 * 
 * @version November 2014
 */
public class ColorPicker implements PageElement {

	private static WebElement _colorPicker;
	private static WebElement _colorTable;

	public static ColorPicker getColorPicker(WebElement colorPicker, WebElement colorTable) {
		return new ColorPicker(colorPicker, colorTable);
	}

	public ColorPicker(WebElement colorPicker, WebElement colorTable) {
		_colorPicker = colorPicker;
		_colorTable = colorTable;
	}

	public WebElement getColorPicker() {
		return _colorPicker;
	}

	public WebElement getColorButton(int x, int y) {
		return _colorTable.findElement(By.cssSelector("div:nth-child(" + y + ")>div>div:nth-child(" + x + ")"));

	}

	public void clear() {
		// not a singleton therefor no action here.
	}

}