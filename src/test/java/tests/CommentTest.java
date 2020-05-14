package tests;

import Pages.LoginPage;
import Pages.UserPage;
import Pages.VideoLayer;
import Pages.VideoPage.VideoPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CommentTest extends TestBase{
    private final String VIDEO_NAME = "Cats and Domino";
    private final String COMMENT_TEXT = "TestCommentary";
    private final String LOGIN = "technopolisbot1";
    private final String PASSWORD = "technopolis16";
    private VideoLayer videoLayer;
    @BeforeEach
    private void before(){
        new LoginPage(driver).Login(LOGIN, PASSWORD);
        new UserPage(driver).clickVideo(driver);
        videoLayer = new VideoPage(driver).goToMyVideos().clickOnVideo(VIDEO_NAME);
    }

    @Test
    public void testAddVideoByLink() {
        videoLayer.typeComment(COMMENT_TEXT);
        Assert.assertTrue(videoLayer.isCommentDisplayed(COMMENT_TEXT));
    }
    /*@Test
    public void testdeleteVideok() {
        videoPage.goToMyVideos();

        Assert.assertTrue(videoPage.isVideoByLinkDisplayed(VIDEO_NAME));
    }*/

}
