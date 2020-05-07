package tests;

import Pages.LoginPage;
import Pages.UserPage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class NewTest extends TestBase {

    private final String message = "TestMessage";
    private final String login = "technopolisbot1";
    private final String password = "technopolis16";
    private final String userName = "Ольга Бондарева";

    @Test
    public void testMessageSending() {
        new LoginPage(driver).Login(login, password);
        UserPage userPage = new UserPage(driver);
        userPage.clickMessagesOnToolbar();
        userPage.clickUserChat(userName);
        userPage.typeMessage(message);
        Assert.assertTrue(userPage.checkLastMessage(message));
    }
}