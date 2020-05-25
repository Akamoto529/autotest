package tests;

import Pages.LoginPage;
import Pages.VideoPage.IVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OnlyFriendVisibleVideoTrueTest extends TestBase{
    private final String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final String VIDEO_NAME = "Cats and Domino";
    private final String BOT1_URL = "https://ok.ru/profile/585773894922";
    private final String BOT2_URL = "https://ok.ru/profile/564624114686";
    private final String BOT1_VIDEO_URL = "https://ok.ru/profile/585773894922/video";
    private final Bot bot1 = new Bot("technopolisbot1","technopolis16");
    private final Bot bot2 = new Bot("89502254448","test2020");
    private IVideoPage videoPage;
    private IVideoPage friendVideoPage;
   @BeforeEach
    private void before(){
        videoPage = new LoginPage(driver)
                .Login(bot1.getLogin(), bot1.getPassword())
                .clickVideo(driver);
        videoPage.downloadVideoFromFile(PATH_TO_VIDEO).setVisibilityOfVideo("Мои друзья");
        videoPage.addFriend(BOT2_URL);
        driver.quit();
        //videoPage.goToMyVideos();
    }
    @Test
    public void testOnlyFriendVisibleVideoTrue() {
        WebDriver newDriver = new ChromeDriver();
        newDriver.get("https://ok.ru/");
        friendVideoPage = new LoginPage(newDriver)
                .Login(bot2.getLogin(), bot2.getPassword())
                .acceptFriendship()
                .goToFriendVideo(BOT1_VIDEO_URL);
        Assert.assertTrue(friendVideoPage.isVideoDisplayed(VIDEO_NAME));
        driver.quit();
    }
/*
    @AfterEach
    private void after() {
        videoPage.goToMyVideos().deleteVideo(VIDEO_NAME);
    }*/
}
