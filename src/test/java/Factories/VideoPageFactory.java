package Factories;

import Pages.VideoPage.*;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Pages.VideoPage.MyChannelsPage.MyChannelsPage;
import org.openqa.selenium.WebDriver;

public class VideoPageFactory {
    public static IMyVideoPage getMyVideoPage(WebDriver driver) {
        return new MyVideoPage(driver);
    }

    public static IChannelPage getChannelPage(WebDriver driver) {
        return new ChannelPage(driver);
    }

    public static IMyChannelsPage getMyChannelsPage(WebDriver driver) {
        return new MyChannelsPage(driver);
    }

    public static IMyVideoHistoryPage getMyVideoHistoryPage(WebDriver driver) {
        return new MyVideoHistoryPage(driver);
    }
}
