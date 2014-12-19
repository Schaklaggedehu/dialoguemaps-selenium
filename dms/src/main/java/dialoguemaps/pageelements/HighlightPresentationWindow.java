package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * 
 * The DM ZoomWindow.
 * 
 * @author janis
 * @edit Martin
 * 
 * @version November 2014
 */
public class HighlightPresentationWindow implements PageElement
{

    private WebElement _highlightPresentationWindow;
    private List<WebElement> _highlightPresentationButtons;
	private WebElement _highlightPresentationCloseButton;
    private static HighlightPresentationWindow _window;


    /**
     * Creates a ZoomWindow as a singleton.
     * 
     * @param zoomWindow
     * @param zoomButtons
     * @return
     */
    public static HighlightPresentationWindow getHighlightPresentationWindow(WebElement highlightPresentationWindow,
            WebElement highlightPresentationCloseButton, List<WebElement> highlightPresentationButtons)
    {
        if (_window == null)
        {
            _window = new HighlightPresentationWindow(highlightPresentationWindow, highlightPresentationCloseButton, highlightPresentationButtons);
        }
        return _window;
    }


    /**
     * 
     * @param zoomWindow
     * @param zoomButtons
     */
    private HighlightPresentationWindow(WebElement highlightPresentationWindow, WebElement highlightPresentationCloseButton, List<WebElement> highlightPresentationButtons)
    {
    	_highlightPresentationWindow = highlightPresentationWindow;
    	_highlightPresentationCloseButton = highlightPresentationCloseButton;
        _highlightPresentationButtons = highlightPresentationButtons;
    }


    public WebElement getCloseButton(){
    	return _highlightPresentationCloseButton;
    }
    /**
     * 
     * @return
     */
    public WebElement getHighlightPresentationWindow()
    {
        return _highlightPresentationWindow;
    }


    /**
     * 
     * @return
     */
    public WebElement getPreviousButton()
    {
        return _highlightPresentationButtons.get(0);
    }


    /**
     * 
     * @return
     */
    public WebElement getNextButton()
    {
        return _highlightPresentationButtons.get(1);
    }


    /**
     * 
     * @return
     */
    public WebElement getAddPreviousButton()
    {
        return _highlightPresentationButtons.get(2);
    }


    /**
     * 
     * @return
     */
    public WebElement getAddNextButton()
    {
        return _highlightPresentationButtons.get(3);
    }


    /**
     * 
     */
    @Override
    public void clear()
    {
        _window = null;
    }
}