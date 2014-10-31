package dialoguemaps.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * 
 * @author janis
 */
public class SeleniumAdapter {

	Point point = new Point(0, 0);
	private List<WebDriver> _drivers = new ArrayList<>();

	public List<WebDriver> getDriver() {
		return _drivers;
	}

	void initSelenium() {
		Properties prop = PropertyReader.load();
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setAcceptUntrustedCertificates(true);
		firefoxProfile.setEnableNativeEvents(true);
		if (Boolean.parseBoolean((String) prop
				.get("enableGWTBrowserPlugin"))) {
			File gwtDevModeExtension = new File(
					"browserPlugins/gwt-dev-plugin-1.26-rc1.xpi");
			try {
				firefoxProfile.addExtension(gwtDevModeExtension);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (Boolean.parseBoolean((String) prop
				.get("enableFirebugAndFirePathBrowserPlugin"))) {
			File firebugExtension = new File("browserPlugins/firebug-1.12.8-fx.xpi");
			File firepathExtension = new File(
					"browserPlugins/firepath-11900-latest.xpi");
			try {
				firefoxProfile.addExtension(firebugExtension);
				firefoxProfile.addExtension(firepathExtension);
			} catch (IOException e) {
				e.printStackTrace();
			}
			firefoxProfile.setPreference("extensions.firebug.currentVersion",
					"1.12.8"); // Avoid firebug extension tab
		}

		File file = new File("/usr/bin/firefox");
		FirefoxBinary bin = new FirefoxBinary(file);
		WebDriver driver = new FirefoxDriver(bin, firefoxProfile);
		driver.manage().window().setPosition(point);
		point.x = point.getX()+30;
		point.y = point.getY()+30;
		driver.manage().window().setSize(new Dimension(1024, 768));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		_drivers.add(driver);
	}

	public void quit() {
		for (WebDriver driver : _drivers) {
			driver.quit();			
		}
	}

	public boolean isElementPresent(final WebElement element) {
		try {
			element.isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
		return true;
	}

}