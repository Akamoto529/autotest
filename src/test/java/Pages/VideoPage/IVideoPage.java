package Pages.VideoPage;

public interface IVideoPage {
    ChannelPage createChannel(String name);
    VideoPage downloadVideoByLink(String link);
    public IMyVideoPage goToMyVideos();
}
