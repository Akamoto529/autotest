package tests;

import Pages.LoginPage;
import Pages.VideoPage.ChannelPage;
import Pages.VideoPage.IChannelPage;
import Pages.VideoPage.IVideoPage;
import Pages.VideoPage.VideoPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangeChannelNameTest extends TestBase {
    private final static String CHANNEL_NAME = "TestName";
    private final static String NEW_CHANNEL_NAME = "ChangedTestName";
    private final static Bot bot = new Bot("technopolisbot1", "technopolis16");
    private IVideoPage videoPage;
    private IChannelPage channelPage;

    @BeforeEach
    private void before() {
        channelPage = new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .getToolBar().clickVideo()
                .createChannel(CHANNEL_NAME);
    }

    @Test
    public void testChannelChange() {
        channelPage.changeChannelName(NEW_CHANNEL_NAME);
        Assertions.assertTrue(channelPage
                .goToMyChannels()
                .isChannelDisplayed(NEW_CHANNEL_NAME));
    }

    @AfterEach
    public void after() {
        new VideoPage(driver).goToMyChannels().goToChannel(NEW_CHANNEL_NAME).deleteChannel();
    }
}
