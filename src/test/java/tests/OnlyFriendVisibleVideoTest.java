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

public class OnlyFriendVisibleVideoTest extends TestBase {
    private final String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final String VIDEO_NAME = "Cats and Domino";
    private final String BOT1_URL = "https://ok.ru/profile/585773894922";
    private final Bot bot1 = new Bot("technopolisbot1","technopolis16");
    private final Bot bot2 = new Bot("TechoBot7","TechnoPolis19");
    private IVideoPage videoPage;
    private IFriendVideoPage friendVideoPage;
    @BeforeEach
    private void before(){
        videoPage = new LoginPage(driver)
                .Login(bot1.getLogin(), bot1.getPassword())
                .getToolBar().clickVideo();
        videoPage.downloadVideoFromFile(PATH_TO_VIDEO).setVisibilityOfVideo("Мои друзья").acceptRedacting();
    }

    @Test
    public void testOnlyFriendVisibleVideo() {
        WebDriver newDriver = new ChromeDriver();
        newDriver.get("https://ok.ru/");
        friendVideoPage = new LoginPage(newDriver)
                .Login(bot2.getLogin(), bot2.getPassword()).goToFriendPage(BOT1_URL).goToFriendVideo();
        Assert.assertFalse(friendVideoPage.getVideoCard(VIDEO_NAME).isVideoDisplayed());
        newDriver.quit();
    }
    @AfterEach
    private void after() {
        videoPage.goToMyVideos().deleteVideo(VIDEO_NAME);
    }
}
