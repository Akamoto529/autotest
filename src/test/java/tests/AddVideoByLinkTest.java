package tests;

import Pages.LoginPage;
import Pages.VideoPage.VideoPage;
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
        videoPage = new LoginPage(driver).Login(LOGIN, PASSWORD).clickVideo(driver).goToMyVideos();
    }

    @Test
    public void testAddVideoByLink() {
        Assert.assertTrue(videoPage.downloadVideoByLink(VIDEO_LINK)
                .goToMyVideos()
                .isVideoDisplayed(VIDEO_NAME));
        videoPage.deleteVideo(VIDEO_NAME);
    }
    /*@Test
    public void testdeleteVideok() {
        videoPage.goToMyVideos();

        Assert.assertTrue(videoPage.isVideoByLinkDisplayed(VIDEO_NAME));
    }*/

}
