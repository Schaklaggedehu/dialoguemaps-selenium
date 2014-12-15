package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author janis
 */
public class TeleporterWindow implements PageElement {

	private WebElement _teleporterWindow;
	private List<WebElement> _teleporterButtons;
	private static TeleporterWindow _window;
	private static List<WebElement> _teleporterPaths;
	private static List<WebElement> _teleporterSlides;
	private WebElement _teleporterCloseButton;

	public static TeleporterWindow getTeleporterWindow(WebElement teleporterWindow, WebElement teleporterCloseButton,
			List<WebElement> teleporterButtons, List<WebElement> teleporterPaths, List<WebElement> teleporterSlides) {
		if (_window == null) {
			_window = new TeleporterWindow(teleporterWindow, teleporterCloseButton, teleporterButtons);
		}
		_teleporterPaths = teleporterPaths;
		_teleporterSlides = teleporterSlides;		
		return _window;
	}

	private TeleporterWindow(WebElement teleporterWindow, WebElement teleporterCloseButton, List<WebElement> teleporterButtons) {
		_teleporterWindow = teleporterWindow;
		_teleporterCloseButton = teleporterCloseButton;
		_teleporterButtons = teleporterButtons;
	}

	public WebElement getTeleporterWindow() {
		return _teleporterWindow;
	}
	
	public WebElement getCloseButton(){
		return _teleporterCloseButton;
	}

	public WebElement getPresentationModeButton(){
		return _teleporterButtons.get(0);
	}
	public WebElement getNewSlideButton(){
		return _teleporterButtons.get(1);
	}
	public WebElement getHighlightGroupButton(){
		return _teleporterButtons.get(2);
	}
	public WebElement getNewPathButton(){
		return _teleporterButtons.get(3);
	}
	public List<WebElement> getSlides(){
		return _teleporterSlides;
	}
	public List<WebElement> getPaths(){
		return _teleporterPaths;
	}
	public TeleporterSlide getSlide(int position){
		return new TeleporterSlide(_teleporterSlides.get(position));
	}
	public TeleporterPath getPath(int position){
		return new TeleporterPath(_teleporterPaths.get(position));
	}
	
	@Override
	public void clear() {
		_window = null;
	}
	
	public class TeleporterPath{
		WebElement _path;
		public TeleporterPath(WebElement path){
			_path = path;
		}
		public WebElement getPath(){
			return _path;
		}
		public WebElement getDeleteButton(){
			return _path.findElement(By.cssSelector("td>div>nobr>img"));
		}
		public String getText(){
			return _path.findElement(By.cssSelector("td>div>nobr")).getText();
		}
	}
	public class TeleporterSlide{

		WebElement _slide;
		public TeleporterSlide(WebElement slide) {
			_slide = slide;
		}
		public WebElement getSlide(){
			return _slide.findElement(By.cssSelector("div>div>div>form"));
		}
		public WebElement getDeleteButton(){
			return _slide.findElement(By.cssSelector("div>div>div[eventproxy^=\"isc_Img_\"]"));
		}
		public WebElement getPreviewSVG(){
			return _slide.findElement(By.cssSelector("div>div>div>div>div>div>div>svg"));
		}
		
	}
}
