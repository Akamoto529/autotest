package tests;

import Pages.LoginPage;
import Pages.VideoPage.ChannelPage;
import Pages.VideoPage.IChannelPage;
import Pages.VideoPage.VideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChannelTest extends TestBase {

    private final String CHANNEL_NAME = "TestName";
    private final String NEW_CHANNEL_NAME = "ChangedTestName";
    private final Bot bot = new Bot("technopolisbot1","technopolis16");
    private VideoPage videoPage;
    @BeforeEach
    private void before(){
        videoPage = new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .clickVideo(driver);
    }
    @Test
    public void testChannelCreation() {
        IChannelPage channelPage = videoPage.createChannel(CHANNEL_NAME);
        Assertions.assertTrue(videoPage.isChannelCardDisplayed(CHANNEL_NAME));
        channelPage.deleteChannel();
    }
    @Test
    public void testChannelChange() {
        IChannelPage channelPage = videoPage.createChannel(CHANNEL_NAME);
        channelPage.changeChannelName(NEW_CHANNEL_NAME);
        Assertions.assertTrue(videoPage.isChannelCardDisplayed(NEW_CHANNEL_NAME));
        channelPage.deleteChannel();
    }
    @Test
    public void testChannelDeletion() {
        IChannelPage channelPage = videoPage.createChannel(CHANNEL_NAME);
        channelPage.deleteChannel();
        Assertions.assertFalse(videoPage.isChannelCardDisplayed(CHANNEL_NAME));
    }
}