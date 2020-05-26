package tests;

import Pages.LoginPage;
import Pages.VideoPage.IMyVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AddVideoFromFileTest extends TestBase{
    private final String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final String VIDEO_NAME = "Cats and Domino";
    private final Bot bot = new Bot("technopolisbot1","technopolis16");
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
        Assert.assertTrue(videoPage.downloadVideoFromFile(PATH_TO_VIDEO)
                .goToMyVideos()
                .getVideoCard(VIDEO_NAME).isVideoDisplayed());
    }

    @AfterEach
    private void after() {
        videoPage.goToMyVideos().deleteVideo(VIDEO_NAME);
    }
}
