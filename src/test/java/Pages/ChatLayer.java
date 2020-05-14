package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatLayer extends BasePage {
    private static final By TEXT_INPUT_FIELD = By.xpath(".//div[@data-placeholder='Напишите сообщение']");
    private static final By SEND_BUTTON = By.xpath(".//button[@title='Отправить' ]");

    public ChatLayer(WebDriver driver){
        super(driver);
    }
    public ChatLayer clickUserChat(String userName) {
        click(By.xpath(".//*[./*[./div[@class='chats_i_h ellip'and text() = '"+userName+"' ]]]"));
        return this;
    }
    public ChatLayer typeMessage(String message) {
        write(message, TEXT_INPUT_FIELD);
        click(SEND_BUTTON);
        return this;
    }
    public boolean checkLastMessage(String text) {
        return isPresent(By.xpath(".//div[@class='msg js-msg soh-s __me __private __collapsed __last']//span[text() = '" + text + "']"));
    }
}
