package Layers;


import Pages.VideoPage.IMyVideoPage;

public interface IVideoLayer {
    VideoLayer typeComment(String text);
    boolean isCommentDisplayed(String text);
    void closeVideo ();
    public VideoLayer waitToGetInHistory ();
}
