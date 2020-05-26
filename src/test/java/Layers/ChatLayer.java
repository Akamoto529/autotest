package Layers;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatLayer extends BasePage implements IChatLayer {
    private static final By TEXT_INPUT_FIELD = By.xpath(".//div[@data-placeholder='�������� ���������']");
    private static final By SEND_BUTTON = By.xpath(".//button[@title='���������' ]");

    public ChatLayer(WebDriver driver){
        super(driver);
    }

    @Override
    public IChatLayer clickUserChat(String userName) {
        click(By.xpath(".//div[@class='chats_i_h ellip'and text() =  '"+userName+"' ]"));
        return this;
    }

    @Override
    public IChatLayer typeMessage(String message) {
        write(message, TEXT_INPUT_FIELD);
        click(SEND_BUTTON);
        return this;
    }

    @Override
    public boolean checkMessageByText(String text) {
        return isDisplayed(By.xpath(".//div[@class='msg js-msg soh-s __me __private __collapsed __last']//span[text() = '" + text + "']"));
    }
}
