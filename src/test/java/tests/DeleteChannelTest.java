package tests;

import Pages.LoginPage;
import Pages.VideoPage.ChannelPage;
import Pages.VideoPage.VideoPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteChannelTest extends TestBase {
    private final String CHANNEL_NAME = "TestName";
    private final String NEW_CHANNEL_NAME = "ChangedTestName";
    private final String LOGIN = "technopolisbot1";
    private final String PASSWORD = "technopolis16";
    private VideoPage videoPage;
    private ChannelPage channelPage;
    @BeforeEach
    private void before(){
        videoPage = new LoginPage(driver)
                .Login(LOGIN, PASSWORD)
                .clickVideo(driver);
        channelPage = videoPage.createChannel(CHANNEL_NAME);
    }
    @Test
    public void testChannelDeletion() {
        channelPage.deleteChannel();
        Assertions.assertFalse(videoPage.isChannelDisplayed(CHANNEL_NAME));
    }

}
