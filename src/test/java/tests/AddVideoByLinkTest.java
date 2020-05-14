package tests;

import Pages.LoginPage;
import Pages.UserPage;
import Pages.VideoPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AddVideoByLinkTest extends TestBase{
    private final String VIDEO_NAME = "Cats and Domino";
    private final String VIDEO_LINK = "https://www.youtube.com/watch?v=7Nn7NZI_LN4";
    private final String LOGIN = "technopolisbot1";
    private final String PASSWORD = "technopolis16";
    private VideoPage videoPage;
    @BeforeEach
    private void before(){
        new LoginPage(driver).Login(LOGIN, PASSWORD);
        new UserPage(driver).clickVideoOnToolbar();
        videoPage = new VideoPage(driver);
    }

    @Test
    public void testAddVideoByLink() {
        videoPage.downloadVideoByLink(VIDEO_LINK);
        videoPage.goToMyVideos();
        Assert.assertTrue(videoPage.isVideoByLinkDisplayed(VIDEO_NAME));
    }

    public void testAddVideoByIncorrectLink() {
        videoPage.downloadVideoByLink("123");

    }
}
