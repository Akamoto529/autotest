package Layers;



public interface IVideoLayer {
    IVideoLayer typeComment(String text);
    boolean isCommentDisplayed(String text);
    void closeVideo ();
    IVideoLayer waitToGetInHistory();
}
