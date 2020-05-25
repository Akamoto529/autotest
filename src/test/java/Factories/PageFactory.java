package Factories;

import Layers.IVideoLayer;
import Layers.VideoLayer;
import Pages.UserPage;
import Pages.VideoPage.*;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Pages.VideoPage.MyChannelsPage.MyChannelsPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    public static UserPage getUserPage(WebDriver driver) { return new UserPage(driver);}
    public static IMyVideoPage getMyVideoPage(WebDriver driver){
        return new MyVideoPage(driver);
    }
    public static IVideoLayer getVideoLayer(WebDriver driver){
        return new VideoLayer(driver);
    }
    public static IChannelPage getChannelPage(WebDriver driver, String channelName){
        return new ChannelPage(driver,channelName);
    }
    public static IMyChannelsPage getMyChannelsPage(WebDriver driver){
        return new MyChannelsPage(driver);
    }
    public static IMyVideoHistoryPage getMyVideoHistoryPage(WebDriver driver){
        return new MyVideoHistoryPage (driver);
    }
    public static IFriendsVideoPage getFriendVideoPage(WebDriver driver){
        return new FriendsVideoPage(driver);
    }
}
