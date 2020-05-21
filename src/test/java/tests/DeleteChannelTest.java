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

public class DeleteChannelTest extends TestBase {
    private final String CHANNEL_NAME = "TestName";
    private final Bot bot = new Bot("technopolisbot1","technopolis16");
    private IChannelPage channelPage;
    @BeforeEach
    private void before(){
        channelPage = new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .clickVideo(driver).createChannel(CHANNEL_NAME);
    }
    @Test
    public void testChannelDeletion() {
        Assertions.assertFalse(channelPage.deleteChannel().isChannelDisplayed(CHANNEL_NAME));
    }

}
