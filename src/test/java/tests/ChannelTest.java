package tests;

import Pages.LoginPage;
import Pages.VideoPage.ChannelPage;
import Pages.VideoPage.VideoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChannelTest extends TestBase {

    private final String CHANNEL_NAME = "TestName";
    private final String NEW_CHANNEL_NAME = "ChangedTestName";
    private final String LOGIN = "technopolisbot1";
    private final String PASSWORD = "technopolis16";
    private VideoPage videoPage;
    @BeforeEach
    private void before(){
        videoPage = new LoginPage(driver)
                .Login(LOGIN, PASSWORD)
                .clickVideo(driver);
    }
    @Test
    public void testChannelCreation() {
        ChannelPage channelPage = videoPage.createChannel(CHANNEL_NAME);
        Assertions.assertTrue(videoPage.isChannelDisplayed(CHANNEL_NAME));
        channelPage.deleteChannel();
    }
    @Test
    public void testChannelChange() {
        ChannelPage channelPage = videoPage.createChannel(CHANNEL_NAME);
        channelPage.changeChannelName(NEW_CHANNEL_NAME);
        Assertions.assertTrue(videoPage.isChannelDisplayed(NEW_CHANNEL_NAME));
        channelPage.deleteChannel();
    }
    @Test
    public void testChannelDeletion() {
        ChannelPage channelPage = videoPage.createChannel(CHANNEL_NAME);
        channelPage.deleteChannel();
        Assertions.assertFalse(videoPage.isChannelDisplayed(CHANNEL_NAME));
    }
}