package Factories;

import Layers.*;
import Pages.VideoPage.ChannelPage;
import Pages.VideoPage.IChannelPage;
import Pages.VideoPage.IMyVideoPage;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Pages.VideoPage.MyChannelsPage.MyChannelsPage;
import Pages.VideoPage.MyVideoPage;
import org.openqa.selenium.WebDriver;

public class LayerFactory {
    public static IChatLayer getChatLayer(WebDriver driver) {
        return new ChatLayer(driver);
    }

    public static IConversationsLayer getConversationsLayer(WebDriver driver) {
        return new ConversationsLayer(driver);
    }

    public static INotificationsLayer getNotificationsLayer(WebDriver driver) {
        return new NotificationsLayer(driver);
    }

    public static IVideoLayer getVideoLayer(WebDriver driver) {
        return new VideoLayer(driver);
    }

}
