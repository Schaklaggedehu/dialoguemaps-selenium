package dialoguemaps.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author janis
 */
public class Reporter {

	private static final List<String> _items = new ArrayList<>();
	private static int _errorNumber = 0;
	private static String _classname = "";

	public static void appendAssertReport(final String command, final String value) {
		if (!_items.contains(command + " " + value)) {
			_errorNumber++;
			_items.add(command + " " + value);
		}
	}

	static void appendMethodReport(String method, String errormessage) {
		if(_classname.isEmpty()){
			_classname = method.substring(method.indexOf("(")+1, method.indexOf(")"));
		}
		_items.add(method + " " + errormessage);
	}

	static void finish() {
		if (_items.size() > 0) {
			String filename = "reports/" + getCurrentTime()
					+"_"+_classname + "_NUMBER_OF_ERRORS_" + _errorNumber + ".txt";
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