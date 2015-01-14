package dialoguemaps.pageelements;

import org.openqa.selenium.WebElement;

public class InfoWindowAdapter implements PageElementAdapter {

	private WebElement _infoWindow;
	private WebElement _modalmask;

	public static InfoWindowAdapter createInfoWindowAdapter(WebElement infoWindow, WebElement modalmask) {
		return new InfoWindowAdapter(infoWindow, modalmask);
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
}
