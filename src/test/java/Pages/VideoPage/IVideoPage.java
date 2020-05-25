package Pages.VideoPage;

import Pages.FriendPage;
import Pages.IVideoLayer;

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
    boolean isChannelCardDisplayed(String channelName); //��������, ���������� � ����������� �� MyChannelPage
    VideoPage downloadVideoFromFile(String pathToFile);
}
