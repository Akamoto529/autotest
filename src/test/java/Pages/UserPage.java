package Pages;

import Wrappers.ToolBarWrapper;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {
    private final ToolBarWrapper toolBar;
    public UserPage(WebDriver driver) {
        super(driver);
        this.toolBar = new ToolBarWrapper(driver);
    }

    public ToolBarWrapper getToolBar() {
        return toolBar;
    }
}
