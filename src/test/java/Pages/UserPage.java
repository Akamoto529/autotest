package Pages;

import Factories.PageFactory;
import Pages.VideoPage.IFriendsVideoPage;
import Wrappers.WithToolbar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage implements WithToolbar {
    private static final By ACCEPT_FRIENDSHIP_BUTTON = By.xpath(".//span[@data-l = 't,growl_link']");

    public UserPage(WebDriver driver) {
        super(driver);
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
