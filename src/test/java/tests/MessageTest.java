package tests;

import Pages.LoginPage;
import Pages.UserPage;
import Wrappers.Accounts.Bot;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class MessageTest extends TestBase {

    private final String message = "TestMessage";
    private final Bot bot = new Bot("technopolisbot1","technopolis16");
    private final String userName = "Ольга Бондарева";

    @Test
    public void testMessageSending() {
        Assert.assertTrue(new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .clickMessages(driver)
                .clickUserChat(userName)
                .typeMessage(message).checkLastMessage(message));
        Assert.assertTrue(new LoginPage(driver)
                .Login(bot.getLogin(), bot.getPassword())
                .clickMessages(driver)
                .clickUserChat(userName)
                .typeMessage(message).checkLastMessage(message));
    }
}