package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By loginField = By.id("field_email");
    private static final By passwordField = By.id("field_password");
    private static final By signInButton = By.xpath(".//*[contains(@data-l,'t,sign_in')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String login, String password) {
        write(login, loginField);
        write(password, passwordField);
        click(signInButton);
    }
}