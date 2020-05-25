package Pages;

import Factories.PageFactory;
import Pages.VideoPage.IFriendsVideoPage;
import Wrappers.WithToolbar;
import org.openqa.selenium.By;
import Wrappers.ToolBarWrapper;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage implements IUserPage{
    private static final By ACCEPT_FRIENDSHIP_BUTTON = By.xpath(".//span[@data-l = 't,growl_link']");
    private final ToolBarWrapper toolBar;
    public UserPage(WebDriver driver) {
        super(driver);
        this.toolBar = new ToolBarWrapper(driver);
    }

    public ToolBarWrapper getToolBar() {
        return toolBar;
    }

    public IFriendsVideoPage goToFriendVideo(String friendUrl) {
        driver.get(friendUrl);
        return PageFactory.getFriendVideoPage(driver);
    }

    /*public FriendPage goToFriendPage(String friendUrl) {
        driver.get(friendUrl);
        return new FriendPage(driver);
    }*/
    public UserPage acceptFriendship() {
        click(ACCEPT_FRIENDSHIP_BUTTON);
        return this;
    }
}
