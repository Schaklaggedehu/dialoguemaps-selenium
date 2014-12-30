package dialoguemaps.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This class gets some reporting information such as the current time and the class name. 
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version Dezember 2014
 */
public class Reporter {

	private static final List<String> _items = new ArrayList<>();
	private static int _numberAsserts, _numberFails, _numberRetries = 0;
	private static String _classname = "";

	public static void appendAssertReport(final String path, final String value) {
		if (!_items.contains(path + " " + value)) {
			_numberAsserts++;
			_items.add(path + " " + value);
		}
	}

	public static void appendMethodReport(String path, String errormessage) {
		if (_classname.equals("")) {
			_classname = getClassname(path);
		}
		if(errormessage.contains(": giving up after")){
		_numberFails++;
		}else{
		_numberRetries++;
	}
		_items.add(path + " " + errormessage);
	}

	private static String getClassname(String path) {
		return path.substring(0, path.lastIndexOf("."));
	}

	public static void finish() {
		if (_items.size() > 0) {
			String filename = "reports/" + getCurrentTime() + "_" + "FAILS:" + _numberFails+" ASSERTS:" + _numberAsserts
					+ " RETRIES:" + _numberRetries+ "_"+ _classname + ".txt";
			try {
				File reportFile = new File(filename);
				if (!reportFile.getParentFile().exists()) {
					reportFile.getParentFile().mkdirs();
				}
			} catch (Throwable ex) {
			}
			try (FileWriter writer = new FileWriter(filename)) {
				for (String item : _items) {
					writer.write(item + System.lineSeparator());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getCurrentTime() {
		return DateFormat.getInstance().format(System.currentTimeMillis());
	}

}