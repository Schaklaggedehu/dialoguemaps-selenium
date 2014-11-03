package dialoguemaps.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * 
 * @author janis
 */
public abstract class AbstractSelenium2Test extends AbstractSeleniumAssertTest {

	private static int MAXIMUM_RETRIES;
	protected static List<WebDriver> _drivers = new ArrayList<>();
	protected static SeleniumAdapter _adapter;
		
	public static void initSelenium2Test(int userCount) {
		Properties prop = PropertyReader.load(); 		
		MAXIMUM_RETRIES = Integer.parseInt((String) prop.get("maximumRetries"));
		_adapter = new SeleniumAdapter();
		for (int i = 0; i < userCount; i++) {
			_adapter.initSelenium();
		}
		_drivers.addAll(_adapter.getDriver());
		Screenshooter.setDrivers(_drivers);
	}

	@Rule
	public RetryTestRule retryTestRule = new RetryTestRule(MAXIMUM_RETRIES);

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