package tests;

import Pages.LoginPage;
import Pages.VideoPage.IMyVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AddVideoFromFileTest extends TestBase {
    private final String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final String VIDEO_NAME = "Cats and Domino";
    private final Bot bot = new Bot("technopolisbot1", "technopolis16");
    private IMyVideoPage videoPage;

    @BeforeEach
    void before() {
        videoPage = new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .getToolBar().clickVideo()
                .goToMyVideos();
    }

    @Test
    public void testAddVideoFromFile() {
        videoPage.downloadVideoFromFile(PATH_TO_VIDEO)
                .goToMyVideos();
        Assert.assertTrue(videoPage.getVideoCard(VIDEO_NAME).isVideoDisplayed());
    }

    @AfterEach
    void after() {
        videoPage.goToMyVideos()
                .deleteVideo(VIDEO_NAME);
    }
}
