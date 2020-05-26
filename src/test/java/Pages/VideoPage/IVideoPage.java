package Pages.VideoPage;

import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Wrappers.WithToolbar;
import Wrappers.WithVideoCard;

public interface IVideoPage extends WithToolbar, WithVideoCard {
    IChannelPage createChannel(String name);

    IMyVideoPage downloadVideoByLink(String link);

    IMyVideoPage goToMyVideos();

    IMyChannelsPage goToMyChannels();

    IMyVideoHistoryPage goToMyHistory();

    IRedactVideoPage downloadVideoFromFile(String pathToFile);
}
