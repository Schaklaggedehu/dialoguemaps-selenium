package dialoguemaps.tools;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * This class manages how to react on key and mouse events such as "Drag-and-Drop".
 * 
 * @author Janis Bullert
 * @edit Martin Hinsch
 *
 * @version Dezember 2014
 */
public abstract class EventHelper {
	private static WebDriver _driver;
	public static void setDriver(WebDriver driver) {
		_driver = driver;
	}

	public static class keys{
		public static void controlA(){
			Actions actions = new Actions(_driver);
			String keys = Keys.chord(Keys.CONTROL, "a");
			actions.sendKeys(keys).build().perform();		
		}
		public static void controlAltN(){
			Actions actions = new Actions(_driver);
			String keys = Keys.chord(Keys.CONTROL, Keys.ALT, "n");
			actions.sendKeys(keys).build().perform();		
		}
	}
	
	public static class mouse{
		public static void clickAndHold(WebElement element){
			Actions actions = new Actions(_driver);
			actions.clickAndHold(element).release().build().perform();		
		}
		public static void click(WebElement element){
			Actions actions = new Actions(_driver);
			actions.click(element).build().perform();		
		}
		public static void doubleClick(WebElement element){
			Actions actions = new Actions(_driver);
			actions.doubleClick(element).build().perform();		
		}
		public static void contextClick(WebElement element){
			Actions actions = new Actions(_driver);
			actions.contextClick(element).build().perform();		
		}
		public static void dragAndDrop(WebElement source, WebElement target){
			Actions actions = new Actions(_driver);
			actions.dragAndDrop(source, target).build().perform();		
		}
		public static void dragAndDropBy(WebElement element, int xOffset, int yOffset){
			Actions actions = new Actions(_driver);
			actions.dragAndDropBy(element, xOffset, yOffset).build().perform();		
		}

		public static void drawHouse(WebElement element) {
			Actions actions = new Actions(_driver);
			actions.clickAndHold(element).moveByOffset(0, -50).moveByOffset(25, -30).moveByOffset(25, 30).
			moveByOffset(0, 50).moveByOffset(-50, 0).release().build().perform();
		}
	}
}
