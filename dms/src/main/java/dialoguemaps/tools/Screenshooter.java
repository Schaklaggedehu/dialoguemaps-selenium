package dialoguemaps.tools;

import java.io.File;
import java.text.DateFormat;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshooter {

	private static List<WebDriver> _drivers;

	public static void setDrivers(List<WebDriver> driver) {
		_drivers = driver;
	}

	private static void screenshot(String testMethodName) {
		for (int i = 0; i < _drivers.size(); i++) {
			String filename = "";
			if (_drivers.size() > 1) {
				filename = "screenshots/" + getCurrentTime() + "_ERROR_USER_"
						+ (i + 1) + "_" + testMethodName + ".png";
			} else {
				filename = "screenshots/" + getCurrentTime() + testMethodName + ".png";
			}
			try {
				File screenshotFile = new File(filename);
				if (!screenshotFile.getParentFile().exists()) {
					screenshotFile.getParentFile().mkdirs();
				}
				File screenshotAsFile = ((TakesScreenshot) _drivers.get(i))
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshotAsFile, screenshotFile);
			} catch (Throwable ex) {
			}
		}
	}

	private static String getCurrentTime() {
		return DateFormat.getInstance().format(System.currentTimeMillis());
	}

	public static void screenshotAssert(String testMethodName) {
		screenshot("_ASSERT_"+testMethodName);
	}
	public static void screenshotRetry(String testMethodName) {
		screenshot("_RETRY_"+testMethodName);
	}

}
