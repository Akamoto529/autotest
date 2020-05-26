package tests;

import Layers.IVideoLayer;
import Pages.LoginPage;
import Pages.VideoPage.IMyVideoPage;
import Pages.VideoPage.MyVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CommentTest extends TestBase{
    private final String VIDEO_NAME = "Cats and Domino";
    private final String COMMENT_TEXT = "TestCommentary";
    private final String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final Bot bot = new Bot("TechoBot7","TechnoPolis19");
    private IMyVideoPage myVideoPage;
    private IVideoLayer videoLayer;
    @BeforeEach
    private void before(){
        myVideoPage = new LoginPage(driver).Login(bot.getLogin(), bot.getPassword())
                .getToolBar().clickVideo()
                .goToMyVideos()
                .downloadVideoFromFile(PATH_TO_VIDEO)
                .acceptRedacting();
    }

    @Test
    public void testCommentSending() {
        videoLayer = new MyVideoPage(driver).getVideoCard(VIDEO_NAME).clickOnVideo();
        Assert.assertTrue(videoLayer
                .typeComment(COMMENT_TEXT)
                .isCommentDisplayed(COMMENT_TEXT));
    }

    @AfterEach
    public void after() {
        videoLayer.deleteComment(COMMENT_TEXT);
        myVideoPage.goToMyVideos().deleteVideo(VIDEO_NAME);
    }
}
