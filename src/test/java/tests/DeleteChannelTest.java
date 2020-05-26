package tests;

import Pages.LoginPage;
import Pages.VideoPage.IChannelPage;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteChannelTest extends TestBase {
    private final static String CHANNEL_NAME = "TestName";
    private final static Bot bot = new Bot("technopolisbot1", "technopolis16");
    private IChannelPage channelPage;

    @BeforeEach
    private void before() {
        channelPage = new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .getToolBar().clickVideo()
                .createChannel(CHANNEL_NAME);
    }

    @Test
    public void testChannelDeletion() {
        IMyChannelsPage myChannelsPage = channelPage.deleteChannel().goToMyChannels();
        Assertions.assertFalse(myChannelsPage.isChannelDisplayed(CHANNEL_NAME));
    }

}
