package tests;

import Pages.LoginPage;
import Pages.VideoPage.IMyVideoPage;
import Pages.VideoPage.IVideoPage;
import Pages.VideoPage.VideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AddVideoFromFileTest extends TestBase{
    private final static String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final static String VIDEO_NAME = "Cats and Domino";
    private final static Bot bot = new Bot("technopolisbot1","technopolis16");
    private IMyVideoPage videoPage;
    @BeforeEach
    private void before(){
        videoPage = new LoginPage(driver)
                    .Login(bot.getLogin(), bot.getPassword())
                    .getToolBar().clickVideo()
                    .goToMyVideos();
    }

    @Test
    public void testAddVideoFromFile() {
        videoPage.downloadVideoFromFile(PATH_TO_VIDEO)
                .goToMyVideos();
        Assert.assertTrue(videoPage
                .getVideoCard()
                .isVideoDisplayed(VIDEO_NAME));
    }

    @AfterEach
    private void after() {
        videoPage.goToMyVideos()
                .deleteVideo(VIDEO_NAME);
    }
}
