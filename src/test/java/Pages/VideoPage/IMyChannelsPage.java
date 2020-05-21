package Pages.VideoPage;


public interface IMyChannelsPage extends IVideoPage  {
    boolean isChannelDisplayed(String channelName);
    IChannelPage goToChannel(String channelName);
}
