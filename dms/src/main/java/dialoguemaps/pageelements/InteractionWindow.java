package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * 
 * @author janis
 */
public class InteractionWindow implements PageElement{

	private WebElement _interactionWindow;
	private List<WebElement> _interactionButtons;
	private static InteractionWindow _window;
	
	public static InteractionWindow getInterActionWindow(WebElement interactionWindow,
			List<WebElement> interactionButtons) {
		if(_window==null){
			_window = new InteractionWindow(interactionWindow, interactionButtons);
		}
		return _window;
	}	
	
	private InteractionWindow(WebElement interactionWindow,
			List<WebElement> interactionButtons) {
				_interactionWindow = interactionWindow;
				_interactionButtons = interactionButtons;
	}
	public WebElement getInteractionWindow(){
		return _interactionWindow;
	}
	public WebElement getShapesButton(){
		return _interactionButtons.get(0);
	}
	
	public WebElement getArrowsButton(){
		return _interactionButtons.get(1);
	}
	
	public WebElement getTextButton(){
		return _interactionButtons.get(2);
	}
	
	public WebElement getBasicShapesButton(){
		return _interactionButtons.get(3);
	}
	
	public WebElement getPenButton(){
		return _interactionButtons.get(4);
	}
	
	public WebElement getDrawingVisibilityButton(){
		return _interactionButtons.get(5);
	}
	
	public WebElement getSelectAllButton(){
		return _interactionButtons.get(6);
	}
	
	public WebElement getMultiselectionButton(){
		return _interactionButtons.get(7);
	}
	
	public WebElement getCopyButton(){
		return _interactionButtons.get(8);
	}
	
	public WebElement getPasteButton(){
		return _interactionButtons.get(9);
	}
	
	public WebElement getMagneticLinesButton(){
		return _interactionButtons.get(10);
	}
	
	public WebElement getDeleteButton(){
		return _interactionButtons.get(11);
	}
	
	public WebElement getShowElucidationButton(){
		return _interactionButtons.get(12);
	}
	
	public WebElement getFlipHorizontallyButton(){
		return _interactionButtons.get(14);
	}
	
	public WebElement getFlipVerticallyButton(){
		return _interactionButtons.get(15);
	}
	
	public WebElement getRotateLeftButton(){
		return _interactionButtons.get(16);
	}
	
	public WebElement getRotateRightButton(){
		return _interactionButtons.get(17);
	}
	
	public WebElement getAlignBottomHorizontallyButton(){
		return _interactionButtons.get(18);
	}
	
	public WebElement getAlignCenterHorizontallyButton(){
		return _interactionButtons.get(19);
	}
	
	public WebElement getAlignTopHorizontallyButton(){
		return _interactionButtons.get(20);
	}
	
	public WebElement getAlignLeftVerticallyButton(){
		return _interactionButtons.get(21);
	}
	
	public WebElement getAlignCenterVerticallyButton(){
		return _interactionButtons.get(22);
	}
	
	public WebElement getAlignRightVerticallyButton(){
		return _interactionButtons.get(23);
	}
	
	public WebElement getEqualGapsHorizontallyButton(){
		return _interactionButtons.get(24);
	}
	
	public WebElement getRemoveGapsHorizontallyButton(){
		return _interactionButtons.get(25);
	}
	
	public WebElement getEqualHightButton(){
		return _interactionButtons.get(26);
	}
	
	public WebElement getEqualGapsVerticallyButton(){
		return _interactionButtons.get(27);
	}
	
	public WebElement getRemoveGapsVerticallyButton(){
		return _interactionButtons.get(28);
	}
	
	public WebElement getEqualWidthButton(){
		return _interactionButtons.get(29);
	}
	
	public WebElement getLineButton(){
		return _interactionButtons.get(30);
	}
	
	public WebElement getCircleButton(){
		return _interactionButtons.get(31);
	}
	
	public WebElement getLeftColorPickerButton(){
		return _interactionButtons.get(33);
	}	
	public WebElement getRightColorPickerButton(){
		return _interactionButtons.get(34);
	}
	@Override
	public void clear() {
		_window = null;
	}
}