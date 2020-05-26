package tests;

import Pages.LoginPage;
import Pages.VideoPage.IMyVideoHistoryPage;
import Pages.VideoPage.IMyVideoPage;
import Pages.VideoPage.MyVideoHistoryPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CheckVideoHistoryTest extends TestBase {
    private final static String VIDEO_NAME = "Cats and Domino";
    private final static String VIDEO_LINK = "https://www.youtube.com/watch?v=7Nn7NZI_LN4";
    private final static Bot bot = new Bot("technopolisbot1","technopolis16");
    private IMyVideoPage myVideoPage;
    private IMyVideoHistoryPage myVideoHistoryPage;
    @BeforeEach
    private void before(){
        myVideoPage = new LoginPage(driver).Login(bot.getLogin(), bot.getPassword())
                .getToolBar().clickVideo()
                .goToMyVideos()
                .downloadVideoByLink(VIDEO_LINK);
    }
    @Test
    public void testCheckVideoHistoryTest () {
        myVideoPage.goToMyVideos().getVideoCard().clickOnVideo(VIDEO_NAME).waitToGetInHistory().closeVideo();
        myVideoHistoryPage = myVideoPage.goToMyHistory();
        Assert.assertTrue(myVideoHistoryPage.getVideoCard().isVideoDisplayed(VIDEO_NAME));
    }
   @AfterEach
    private void after(){
        myVideoHistoryPage.cleanHistory();
        myVideoPage.goToMyVideos().deleteVideo(VIDEO_NAME);
    }
}
