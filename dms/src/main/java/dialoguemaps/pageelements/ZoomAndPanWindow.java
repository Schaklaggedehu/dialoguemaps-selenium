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
public class ZoomAndPanWindow implements PageElement
{

    private WebElement _zoomWindow;
    private List<WebElement> _zoomButtons;
    private static ZoomAndPanWindow _window;


    /**
     * Creates a ZoomWindow as a singleton.
     * 
     * @param zoomWindow
     * @param zoomButtons
     * @return
     */
    public static ZoomAndPanWindow getZoomWindow(WebElement zoomWindow,
            List<WebElement> zoomButtons)
    {
        if (_window == null)
        {
            _window = new ZoomAndPanWindow(zoomWindow, zoomButtons);
        }
        return _window;
    }


    /**
     * 
     * @param zoomWindow
     * @param zoomButtons
     */
    private ZoomAndPanWindow(WebElement zoomWindow, List<WebElement> zoomButtons)
    {
        _zoomWindow = zoomWindow;
        _zoomButtons = zoomButtons;
    }


    /**
     * 
     * @return
     */
    public WebElement getZoomWindow()
    {
        return _zoomWindow;
    }


    /**
     * 
     * @return
     */
    public WebElement getUpButton()
    {
        return _zoomButtons.get(0);
    }


    /**
     * 
     * @return
     */
    public WebElement getLeftButton()
    {
        return _zoomButtons.get(1);
    }


    /**
     * 
     * @return
     */
    public WebElement getCenterButton()
    {
        return _zoomButtons.get(2);
    }


    /**
     * 
     * @return
     */
    public WebElement getRightButton()
    {
        return _zoomButtons.get(3);
    }


    /**
     * 
     * @return
     */
    public WebElement getDownButton()
    {
        return _zoomButtons.get(4);
    }


    /**
     * 
     * @return
     */
    public WebElement getPlusButton()
    {
        return _zoomButtons.get(5);
    }


    /**
     * 
     * @return
     */
    public WebElement getZoomIntoButton()
    {
        return _zoomButtons.get(6);
    }


    /**
     * 
     * @return
     */
    public WebElement getHomeButton()
    {
        return _zoomButtons.get(7);
    }


    /**
     * 
     * @return
     */
    public WebElement getMinusButton()
    {
        return _zoomButtons.get(8);
    }


    /**
     * 
     * @return
     */
    public WebElement getToggleHomeButton()
    {
        return _zoomButtons.get(9);
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