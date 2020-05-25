package Pages.VideoPage;

import Pages.FriendPage.IUserPage;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Wrappers.WithToolbar;
import Wrappers.WithVideoCard;

public interface IVideoPage extends WithToolbar, WithVideoCard {
    IChannelPage createChannel(String name);
    IMyVideoPage downloadVideoByLink(String link);
    IMyVideoPage goToMyVideos();
    IMyChannelsPage goToMyChannels();
    IMyVideoHistoryPage goToMyHistory();
    IUserPage addFriend(String friendUrl);
    void setVisibilityOfVideo(String text);
    IMyVideoPage downloadVideoFromFile(String pathToFile);
}
