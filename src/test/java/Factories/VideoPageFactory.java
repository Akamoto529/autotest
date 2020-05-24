package Factories;

import Layers.IVideoLayer;
import Layers.VideoLayer;
import Pages.VideoPage.ChannelPage;
import Pages.VideoPage.IChannelPage;
import Pages.VideoPage.IMyVideoPage;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Pages.VideoPage.MyChannelsPage.MyChannelsPage;
import Pages.VideoPage.MyVideoPage;
import org.openqa.selenium.WebDriver;

public class VideoPageFactory {
    public static IMyVideoPage getMyVideoPage(WebDriver driver){
        return new MyVideoPage(driver);
    }
    public static IChannelPage getChannelPage(WebDriver driver, String channelName){
        return new ChannelPage(driver,channelName);
    }
    public static IMyChannelsPage getMyChannelsPage(WebDriver driver){
        return new MyChannelsPage(driver);
    }
}
