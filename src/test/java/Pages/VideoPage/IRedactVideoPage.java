package Pages.VideoPage;

public interface IRedactVideoPage extends IVideoPage {
    IRedactVideoPage setVisibilityOfVideo(String text);

    IMyVideoPage acceptRedacting();
}
