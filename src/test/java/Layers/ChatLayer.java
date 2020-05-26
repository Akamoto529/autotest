package Layers;

import Pages.BasePage;
import Wrappers.ChatMessageWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatLayer extends BasePage implements IChatLayer {
    private static final By TEXT_INPUT_FIELD = By.xpath(".//div[@data-placeholder='Напишите сообщение']");
    private static final By SEND_BUTTON = By.xpath(".//button[@title='Отправить' ]");

    ChatMessageWrapper chatMessage;

    public ChatLayer(WebDriver driver){
        super(driver);
        this.chatMessage = new ChatMessageWrapper(driver);
    }

    @Override
    public IChatLayer clickUserChat(String userName) {
        click(By.xpath(".//*[./*[./div[@class='chats_i_h ellip'and text() = '"+userName+"' ]]]"));
        return this;
    }

    @Override
    public IChatLayer typeMessage(String message) {
        write(message, TEXT_INPUT_FIELD);
        click(SEND_BUTTON);
        return this;
    }

    @Override
    public ChatMessageWrapper getChatMessage(){
        return chatMessage;
    }
}
