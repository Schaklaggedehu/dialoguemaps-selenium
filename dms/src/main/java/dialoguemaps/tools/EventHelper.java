package dialoguemaps.tools;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author janis
 */
public class EventHelper {
	private WebDriver _driver;
	public EventHelper(WebDriver driver){
		_driver = driver;
	}

	public void clickAndHold(WebElement element){
		Actions actions = new Actions(_driver);
		actions.clickAndHold(element).release().build().perform();		
	}
	public void click(WebElement element){
		Actions actions = new Actions(_driver);
		actions.click(element).build().perform();		
	}
	public void doubleClick(WebElement element){
		Actions actions = new Actions(_driver);
		actions.doubleClick(element).build().perform();		
	}
	public void contextClick(WebElement element){
		Actions actions = new Actions(_driver);
		actions.contextClick(element).build().perform();		
	}
	public void dragAndDrop(WebElement source, WebElement target){
		Actions actions = new Actions(_driver);
		actions.dragAndDrop(source, target).build().perform();		
	}
	public void dragAndDropBy(WebElement element, int xOffset, int yOffset){
		Actions actions = new Actions(_driver);
		actions.dragAndDropBy(element, xOffset, yOffset).build().perform();		
	}
	public void ControlA(){
		Actions actions = new Actions(_driver);
		String keys = Keys.chord(Keys.CONTROL, "a");
		actions.sendKeys(keys).build().perform();		
	}

	public void drawHouse(WebElement element) {
		Actions actions = new Actions(_driver);
		actions.clickAndHold(element).moveByOffset(0, -50).moveByOffset(50, 0).
		moveByOffset(0, 50).moveByOffset(-50, 0).release().build().perform();
	}
}
