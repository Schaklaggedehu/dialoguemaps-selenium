package dialoguemaps.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import dialoguemaps.tools.PropertyReader;
import dialoguemaps.tools.Reporter;
import dialoguemaps.tools.Screenshooter;

/**
 * Abtract class for assertion tests with Selenium.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 * 
 * @version Dezember 2014
 */
public abstract class AbstractSelenium2Test extends AbstractSeleniumAssertTest {

	private static int MAXIMUM_RETRIES;
	private static boolean SHOW_PRINTOUTS;
	protected static List<WebDriver> _drivers = new ArrayList<>();
	protected static SeleniumAdapter _adapter;

	/**
	 * Initalize the Selenium test with user counts.
	 * 
	 * @param userCount
	 */
	public static void initSelenium2Test(int userCount) {
		Properties prop = PropertyReader.load(); 		
		MAXIMUM_RETRIES = Integer.parseInt((String) prop.get("maximumRetries"));
		SHOW_PRINTOUTS = Boolean.parseBoolean((String) prop.get("showPrintouts"));
		System.out.print("Initiating Selenium...");
		_adapter = new SeleniumAdapter();
		for (int i = 0; i < userCount; i++) {
			_adapter.initSelenium();
		}
		System.out.println(" Success.");
		_drivers.addAll(_adapter.getDriver());
		Screenshooter.setDrivers(_drivers);
	}

	@Rule
	public RetryTestRule retryTestRule = new RetryTestRule(MAXIMUM_RETRIES, SHOW_PRINTOUTS);

	@AfterClass
	public static void tearDownSelenium2Test() {
		try {
			 _adapter.quit();
			 _drivers.clear();
				Screenshooter.setDrivers(_drivers);
		} catch (WebDriverException e) {
		}
		Reporter.finish();
	}
}