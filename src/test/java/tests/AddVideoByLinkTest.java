package tests;

import Pages.LoginPage;
import Pages.VideoPage.IMyVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class AddVideoByLinkTest extends TestBase{
    private final String VIDEO_NAME = "Cats and Domino";
    private final String VIDEO_LINK = "https://www.youtube.com/watch?v=7Nn7NZI_LN4";
    private final Bot bot = new Bot("technopolisbot1","technopolis16");
    private IMyVideoPage myVideoPage;
    @BeforeEach
    private void before(){
        myVideoPage = new LoginPage(driver).Login(bot.getLogin(), bot.getPassword()).clickVideo(driver).goToMyVideos();
    }

    @Test
    public void testAddVideoByLink() {
        Assert.assertTrue(myVideoPage.downloadVideoByLink(VIDEO_LINK)
                .isVideoDisplayed(VIDEO_NAME));
        myVideoPage.deleteVideo(VIDEO_NAME);
    }
    /*@Test
    public void testdeleteVideok() {
        videoPage.goToMyVideos();

        Assert.assertTrue(videoPage.isVideoByLinkDisplayed(VIDEO_NAME));
    }*/

}
