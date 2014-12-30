package dialoguemaps.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import dialoguemaps.tools.PropertyReader;

/**
 * Initalize Selenium with the WebDriver. Automatically loads Firefox plugins such as GWT, FireBug and FirePath.
 * The WebDriver API is a tool for automating web application testing.
 * With the WebDriver "driving a browser natively as a user would either locally or on a remote machine" is possible.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 * 
 * @version Dezember 2014
 *
 */
public class SeleniumAdapter {

    Point point = new Point(0, 0);
    private List<WebDriver> _drivers = new ArrayList<>();

    public List<WebDriver> getDriver() {
        return _drivers;
    }

    /**
     * Initalize Selenium with the WebDriver.
     */
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
        String firefoxPath = prop.getProperty("firefoxPath");
        File file = new File(firefoxPath);
        if(!file.exists()){
        	System.out.println(" failed.");
        	System.out.println("Couldn't find firefox executable.");
        	System.out.println("Please edit firefoxPath in selenium.properties.");
        }
        FirefoxBinary bin = new FirefoxBinary(file);
        WebDriver driver = new FirefoxDriver(bin, firefoxProfile);
        driver.manage().window().setPosition(point);
        point.x = point.getX()+30;
        point.y = point.getY()+30;
		driver.manage()
		.window()
		.setSize(
				new Dimension(Integer.parseInt((String) prop.getProperty("width")), 
						Integer.parseInt((String) prop.getProperty("height"))));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        _drivers.add(driver);
    }

    /**
     * Ends the WebDriver.
     */
    public void quit() {
        for (WebDriver driver : _drivers) {
            driver.quit();          
        }
    }
}