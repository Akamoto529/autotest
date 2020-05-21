package Pages.VideoPage;

import Pages.IVideoLayer;

public interface IVideoPage {
    IChannelPage createChannel(String name);
    IMyVideoPage downloadVideoByLink(String link);
    IMyVideoPage goToMyVideos();
    IVideoLayer clickOnVideo(String videoName);
    boolean isVideoDisplayed(String videoByLinkName);
    boolean isChannelCardDisplayed(String channelName); //Устарело, переделать в отображение на MyChannelPage
}
