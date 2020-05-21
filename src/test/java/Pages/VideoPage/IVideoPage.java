package Pages.VideoPage;

import Pages.IVideoLayer;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;

public interface IVideoPage {
    IChannelPage createChannel(String name);
    IMyVideoPage downloadVideoByLink(String link);
    IMyVideoPage goToMyVideos();
    IMyChannelsPage goToMyChannels();
    IVideoLayer clickOnVideo(String videoName);
    boolean isVideoDisplayed(String videoByLinkName);
    boolean isChannelCardDisplayed(String channelName); //Устарело, переделать в отображение на MyChannelPage
    VideoPage downloadVideoFromFile(String pathToFile);
}
