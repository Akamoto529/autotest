package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChatMessageWrapper {

    private final WebDriver driver;
    private final WebElement chatMessage;

    public ChatMessageWrapper(WebDriver driver, WebElement chatMessage){
        this.driver = driver;
        this.chatMessage = chatMessage;
    }
    public ChatMessageWrapper(WebDriver driver, String messageText){
        this.driver = driver;
        this.chatMessage = driver.findElement(By.xpath(".//div[@class='msg js-msg soh-s __me __private __collapsed __last']//span[text() = '" + messageText + "']"));
    }
    public boolean checkLastMessage(String text) {
        return chatMessage.isDisplayed();
    }
}
