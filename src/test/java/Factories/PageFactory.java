package Factories;

import Pages.IVideoLayer;
import Pages.VideoLayer;
import Pages.VideoPage.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {
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
}
