package Pages.VideoPage;

import Pages.FriendPage;
import Pages.IVideoLayer;
import Layers.IVideoLayer;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;

public interface IVideoPage {
    IChannelPage createChannel(String name);
    IMyVideoPage downloadVideoByLink(String link);
    IMyVideoPage goToMyVideos();
    IMyChannelsPage goToMyChannels();
    IMyVideoHistoryPage goToMyHistory();
    FriendPage addFriend(String friendUrl);
    void setVisibilityOfVideo(String text);
    IVideoLayer clickOnVideo(String videoName);
    boolean isVideoDisplayed(String videoByLinkName);
    VideoPage downloadVideoFromFile(String pathToFile);
}
