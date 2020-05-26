package Wrappers;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatMessageWrapper extends BasePage {

    public ChatMessageWrapper(WebDriver driver){
        super(driver);
    }
    public boolean checkLastMessage(String text) {
        return isPresent(getMessageXpath(text));
    }
    private By getMessageXpath(String text){
        return By.xpath(".//div[@class='msg js-msg soh-s __me __private __collapsed __last']//span[text() = '" + text + "']");
    }
}
