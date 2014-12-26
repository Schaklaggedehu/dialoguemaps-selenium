package dialoguemaps.pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ZoomAndPanWindowAdapter implements PageElementAdapter
{

    private WebElement _zoomWindow;
    private List<WebElement> _zoomButtons;
    private static ZoomAndPanWindowAdapter _window;

    public static ZoomAndPanWindowAdapter createZoomWindowAdapter(WebElement zoomWindow,
            List<WebElement> zoomButtons)
    {
        if (_window == null)
        {
            _window = new ZoomAndPanWindowAdapter(zoomWindow, zoomButtons);
        }
        return _window;
    }

    private ZoomAndPanWindowAdapter(WebElement zoomWindow, List<WebElement> zoomButtons)
    {
        _zoomWindow = zoomWindow;
        _zoomButtons = zoomButtons;
    }

    public WebElement getZoomWindow()
    {
        return _zoomWindow;
    }

    public WebElement getUpButton()
    {
        return _zoomButtons.get(0);
    }

    public WebElement getLeftButton()
    {
        return _zoomButtons.get(1);
    }

    public WebElement getCenterButton()
    {
        return _zoomButtons.get(2);
    }

    public WebElement getRightButton()
    {
        return _zoomButtons.get(3);
    }

    public WebElement getDownButton()
    {
        return _zoomButtons.get(4);
    }

    public WebElement getPlusButton()
    {
        return _zoomButtons.get(5);
    }

    public WebElement getZoomIntoButton()
    {
        return _zoomButtons.get(6);
    }

    public WebElement getHomeButton()
    {
        return _zoomButtons.get(7);
    }

    public WebElement getMinusButton()
    {
        return _zoomButtons.get(8);
    }

    public WebElement getToggleHomeButton()
    {
        return _zoomButtons.get(9);
    }

    @Override
    public void clear()
    {
        _window = null;
    }
}