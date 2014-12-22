package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ColorPickerAdapter implements PageElementAdapter {

	private static ColorPickerAdapter _picker;
	private List<WebElement> _colorPickers;
	private WebElement _colorPicker;

	public static ColorPickerAdapter getColorPicker(List<WebElement> colorPickers) {
		if (_picker == null) {
			_picker = new ColorPickerAdapter(colorPickers);
		}
		return _picker;
	}

	public ColorPickerAdapter(List<WebElement> colorPickers) {
		_colorPickers = colorPickers;
	}

	public WebElement getColorPicker() {
		for (WebElement webElement : _colorPickers) {
			if (!"hidden".equals(webElement.getAttribute("visibility"))) {
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

	public void clear() {
		_picker = null;
	}

}