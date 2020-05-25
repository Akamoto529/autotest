package tests;

import Layers.IVideoLayer;
import Pages.LoginPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CommentTest extends TestBase{
    private final String VIDEO_NAME = "Cats and Domino";
    private final String COMMENT_TEXT = "TestCommentary";
    private final Bot bot = new Bot("technopolisbot1","technopolis16");
    private IVideoLayer videoLayer;
    @BeforeEach
    private void before(){
        videoLayer = new LoginPage(driver)
                    .Login(bot.getLogin(), bot.getPassword())
                    .getToolBar().clickVideo()
                    .goToMyVideos()
                    .getVideoCard().clickOnVideo(VIDEO_NAME);
    }

    @Test
    public void testAddVideoByLink() {
        videoLayer.typeComment(COMMENT_TEXT);
        Assert.assertTrue(videoLayer.isCommentDisplayed(COMMENT_TEXT));
    }

}
