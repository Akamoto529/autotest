package tests;

import Pages.LoginPage;
import Pages.VideoPage.IMyVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AddVideoByLinkTest extends TestBase {
    private final static String VIDEO_NAME = "Cats and Domino";
    private final static String VIDEO_LINK = "https://www.youtube.com/watch?v=7Nn7NZI_LN4";
    private final static Bot bot = new Bot("technopolisbot1", "technopolis16");
    private IMyVideoPage myVideoPage;

    @BeforeEach
    private void before() {
        myVideoPage = new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .getToolBar().clickVideo()
                .goToMyVideos();
    }

    @Test
    public void testAddVideoByLink() {
        myVideoPage.downloadVideoByLink(VIDEO_LINK);
        Assert.assertTrue(myVideoPage.getVideoCard().isVideoDisplayed(VIDEO_LINK));
    }

    @AfterEach
    private void after() {
        myVideoPage.goToMyVideos()
                .deleteVideo(VIDEO_NAME);
    }
}
