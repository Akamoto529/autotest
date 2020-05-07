package tests;

import Pages.LoginPage;
import Pages.UserPage;
import Pages.VideoPage;
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
        new LoginPage(driver).Login(LOGIN, PASSWORD);
        new UserPage(driver).clickVideoOnToolbar();
        videoPage = new VideoPage(driver);
    }
    @Test
    public void testChannelCreation() {
        videoPage.createChannel(CHANNEL_NAME);
        Assertions.assertTrue(videoPage.isChannelDisplayed(CHANNEL_NAME));
    }
    @Test
    public void testChannelChange() {
        videoPage.changeChannelName(CHANNEL_NAME);
        Assertions.assertTrue(videoPage.isChannelDisplayed(NEW_CHANNEL_NAME));
    }
    @Test
    public void testChannelDeletion() {
        videoPage.deleteChannel(CHANNEL_NAME);
        Assertions.assertFalse(videoPage.isChannelDisplayed(NEW_CHANNEL_NAME));
    }
}