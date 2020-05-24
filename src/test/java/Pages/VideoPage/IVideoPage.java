package Pages.VideoPage;

import Layers.IVideoLayer;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;

public interface IVideoPage {
    IChannelPage createChannel(String name);
    IMyVideoPage downloadVideoByLink(String link);
    IMyVideoPage goToMyVideos();
    IMyChannelsPage goToMyChannels();
    IVideoLayer clickOnVideo(String videoName);
    boolean isVideoDisplayed(String videoByLinkName);
    VideoPage downloadVideoFromFile(String pathToFile);
}
