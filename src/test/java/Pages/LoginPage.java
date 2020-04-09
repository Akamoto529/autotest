package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String login, String password) {
        write(login, By.id("field_email"));
        write(password, By.id("field_password"));
        click(By.xpath(".//*[contains(@data-l,'t,sign_in')]"));
    }
}