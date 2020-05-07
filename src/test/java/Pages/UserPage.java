package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {

    private static final By MESSAGE_BUTTON = By.xpath(".//*[@data-l='t,messages']");
    private static final By VIDEO_BUTTON = By.xpath(".//*[@data-l='t,video']");
    private static final By TEXT_INPUT_FIELD = By.xpath(".//div[@data-placeholder='Напишите сообщение']");
    private static final By SEND_BUTTON = By.xpath(".//button[@title='Отправить' ]");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void clickMessagesOnToolbar() {
        click(MESSAGE_BUTTON);
    }
    public void clickVideoOnToolbar() {
        click(VIDEO_BUTTON);
    }
    public void clickUserChat(String userName) {
        click(By.xpath(".//*[./*[./div[@class='chats_i_h ellip'and text() = '"+userName+"' ]]]"));
    }

    public void typeMessage(String message) {
        write(message, TEXT_INPUT_FIELD);
        click(SEND_BUTTON);
    }

    public boolean checkLastMessage(String text) {
        return isPresent(By.xpath(".//div[@class='msg js-msg soh-s __me __private __collapsed __last']//span[text() = '" + text + "']"));
    }

}
