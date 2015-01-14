package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * An adapter class to get the elements of the color picker. Elements can be
 * e.g. the window itself, buttons, fields, etc.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version January 2015
 */
public class ColorPickerAdapter implements PageElementAdapter {

	private List<WebElement> _colorPickers;
	private WebElement _colorPicker;

	public static ColorPickerAdapter createColorPickerAdapter(List<WebElement> colorPickers) {
		return new ColorPickerAdapter(colorPickers);
	}

	private ColorPickerAdapter(List<WebElement> colorPickers) {
		_colorPickers = colorPickers;
	}

	public WebElement getColorPicker() {
		for (WebElement webElement : _colorPickers) {
			if (webElement.isDisplayed()) {
				_colorPicker = webElement;
				break;
			}
		}
		return _colorPicker;
	}

	public WebElement getColorButton(int x, int y) {
		WebElement colorTable = _colorPicker.findElement(By.cssSelector("div>div>div>div>div>div>div>div>div>div>div"));
		return colorTable.findElement(By.cssSelector("div:nth-child(" + y + ")>div>div:nth-child(" + x + ")"));
	}
}