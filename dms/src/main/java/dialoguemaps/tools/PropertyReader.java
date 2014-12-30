package dialoguemaps.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class reads the client specific Selenium properties.
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version Dezember 2014
 */
public class PropertyReader {

	public static Properties load(){
	Properties prop = new Properties();
		try(FileInputStream input = new FileInputStream("configSelenium/selenium.properties"))
	{
		prop.load(input);
	} catch (IOException e1) {
		e1.printStackTrace();
	}
		return prop;
	}
}
