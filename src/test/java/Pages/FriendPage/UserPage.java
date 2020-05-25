package Pages.FriendPage;

import Factories.PageFactory;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends MainPage implements IUserPage {

    static final By VIDEO_BUTTON =By.xpath("//a[contains(@hrefattrs,'userFriendVideo')]");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IFriendVideoPage goToFriendVideo() {
        click(VIDEO_BUTTON);
        return PageFactory.getFriendVideoPage(driver);
    }
}
