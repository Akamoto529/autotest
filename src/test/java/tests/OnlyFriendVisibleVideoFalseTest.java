package tests;

import Pages.LoginPage;
import Pages.VideoPage.IVideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OnlyFriendVisibleVideoFalseTest extends TestBase {
    private final String PATH_TO_VIDEO = "C:\\Cats and Domino.mp4";
    private final String VIDEO_NAME = "Cats and Domino";
    private final String FRIEND_URL = "https://ok.ru/profile/585773894922";
    private final String FRIEND_VIDEO_URL = "https://ok.ru/profile/585773894922/video";
    private final Bot bot = new Bot("technopolisbot1","technopolis16");
    private final Bot friendBot = new Bot("89502254448","test2020");
    private IVideoPage videoPage;
    private IVideoPage friendVideoPage;
    @BeforeEach
    private void before(){
        videoPage = new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .clickVideo(driver);
        videoPage.downloadVideoFromFile(PATH_TO_VIDEO).setVisibilityOfVideo("��� ������");
        //videoPage.goToMyVideos();
        //��������� ���
    }

    @Test
    public void testOnlyFriendVisibleVideoFalse() {
        WebDriver newDriver = new ChromeDriver();
        newDriver.get("https://ok.ru/");
        friendVideoPage = new LoginPage(newDriver)
                .Login(friendBot.getLogin(), friendBot.getPassword()).goToFriendVideo(FRIEND_VIDEO_URL);
        Assert.assertFalse(friendVideoPage.isVideoDisplayed(VIDEO_NAME));
    }
/*
    @AfterEach
    private void after() {
        videoPage.goToMyVideos().deleteVideo(VIDEO_NAME);
    }*/
}
