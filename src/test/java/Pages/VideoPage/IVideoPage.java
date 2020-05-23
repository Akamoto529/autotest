package Pages.VideoPage;

import Pages.IVideoLayer;

public interface IVideoPage {
    IChannelPage createChannel(String name);
    IMyVideoPage downloadVideoByLink(String link);
    IMyVideoPage goToMyVideos();
    IMyChannelsPage goToMyChannels();
    IMyVideoHistoryPage goToMyHistory();
    IVideoLayer clickOnVideo(String videoName);
    boolean isVideoDisplayed(String videoByLinkName);
    boolean isChannelCardDisplayed(String channelName); //��������, ���������� � ����������� �� MyChannelPage
    VideoPage downloadVideoFromFile(String pathToFile);
}
