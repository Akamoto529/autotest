package tests;

import Pages.LoginPage;
import Pages.VideoPage.*;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateChannelTest extends TestBase {
    private final static String CHANNEL_NAME = "TestName";
    private final static Bot bot = new Bot("technopolisbot1", "technopolis16");
    private IVideoPage videoPage;

    @BeforeEach
    private void before() {
        videoPage = new LoginPage(e_driver)
                .Login(bot.getLogin(), bot.getPassword())
                .getToolBar().clickVideo();
    }

    @Test
    public void testChannelCreation() {
        videoPage.createChannel(CHANNEL_NAME);
        Assertions.assertTrue(videoPage
                .goToMyChannels()
                .isChannelDisplayed(CHANNEL_NAME));
    }

    @AfterEach
    public void after() {
        new VideoPage(driver).goToMyChannels().goToChannel(CHANNEL_NAME).deleteChannel();
    }
}
