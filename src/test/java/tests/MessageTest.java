package tests;

import Pages.LoginPage;
import Pages.UserPage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class MessageTest extends TestBase {

    private final String message = "TestMessage";
    private final String login = "technopolisbot1";
    private final String password = "technopolis16";
    private final String userName = "Ольга Бондарева";

    @Test
    public void testMessageSending() {
        Assert.assertTrue(new LoginPage(driver)
                .Login(login, password)
                .clickMessages(driver)
                .clickUserChat(userName)
                .typeMessage(message).checkLastMessage(message));
        Assert.assertTrue(new LoginPage(driver)
                .Login(login, password)
                .clickMessages(driver)
                .clickUserChat(userName)
                .typeMessage(message).checkLastMessage(message));
    }
}