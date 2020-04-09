package tests;

import Pages.LoginPage;
import Pages.UserPage;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class NewTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        String message = "TestMessage";
        new LoginPage(driver).Login("technopolisbot1","technopolis16");
        UserPage userPage = new UserPage(driver);
        userPage.clickMessagesOnToolbar();
        userPage.clickUserChat();
        userPage.typeMessage(message);
        Assert.assertTrue(userPage.checkLastMessage(message));
    }
}