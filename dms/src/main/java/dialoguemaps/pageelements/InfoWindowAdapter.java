package dialoguemaps.pageelements;

import org.openqa.selenium.WebElement;

public class InfoWindowAdapter implements PageElementAdapter {

	private static InfoWindowAdapter _window;
	private WebElement _infoWindow;
	private WebElement _modalmask;

	public static InfoWindowAdapter createInfoWindowAdapter(WebElement infoWindow, WebElement modalmask) {
		if (_window == null) {
			_window = new InfoWindowAdapter(infoWindow, modalmask);
		}
		return _window;
	}

	private InfoWindowAdapter(WebElement infoWindow, WebElement modalmask) {
		_infoWindow = infoWindow;
		_modalmask = modalmask;
	}

	public WebElement getInfoWindow() {
		return _infoWindow;
	}

	public WebElement getModalmask() {
		return _modalmask;
	}

	@Override
	public void clear() {
		_window = null;
	}
}
