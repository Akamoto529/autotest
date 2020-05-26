package Pages.VideoPage.MyChannelsPage;


import Pages.VideoPage.IChannelPage;
import Pages.VideoPage.IVideoPage;

public interface IMyChannelsPage extends IVideoPage {
    boolean isChannelDisplayed(String channelName);

    IChannelPage goToChannel(String channelName);
}
