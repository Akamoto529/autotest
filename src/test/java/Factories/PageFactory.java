package Factories;

import Pages.FriendPage.*;
import Pages.MainPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    public static MainPage getMainPage(WebDriver driver) {
        return new MainPage(driver);
    }

    public static IUserPage getUserPage(WebDriver driver) {
        return new UserPage(driver);
    }

    public static IFriendVideoPage getFriendVideoPage(WebDriver driver) {
        return new FriendVideoPage(driver);
    }
}
