package tests;

import Pages.FriendPage.IFriendVideoPage;
import Pages.LoginPage;
import Pages.VideoPage.IVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EverybodyVisibleVideoTest extends TestBase {
    private final static String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final static String VIDEO_NAME = "Cats and Domino";
    private final static String BOT1_URL = "https://ok.ru/profile/585773894922";
    private final static Bot bot1 = new Bot("technopolisbot1", "technopolis16");
    private final static Bot bot2 = new Bot("TechoBot7", "TechnoPolis19");
    private IVideoPage videoPage;
    private IFriendVideoPage friendVideoPage;

    @BeforeEach
    void before() {
        videoPage = new LoginPage(driver)
                .Login(bot1.getLogin(), bot1.getPassword())
                .getToolBar().clickVideo()
                .downloadVideoFromFile(PATH_TO_VIDEO)
                .acceptRedacting();
    }

    @Test
    public void testVisibilityOfVideo() {
        WebDriver newDriver = new ChromeDriver();
        newDriver.get("https://ok.ru/");
        friendVideoPage = new LoginPage(newDriver)
                .Login(bot2.getLogin(), bot2.getPassword())
                .goToFriendPage(BOT1_URL)
                .goToFriendVideo();
        Assert.assertFalse(friendVideoPage.getVideoCard(VIDEO_NAME).isVideoDisplayed());
        newDriver.quit();
    }

    @AfterEach
    void after() {
        videoPage.goToMyVideos()
                .deleteVideo(VIDEO_NAME);
    }

}
