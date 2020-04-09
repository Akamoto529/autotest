package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {
    private static final By PHOTO_ADD_BUTTON = By.xpath(".//input[@type = 'file' and @name = 'photo']");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        //todo
    }

    public void clickMessagesOnToolbar() {
        click(By.xpath(".//*[@data-l='t,messages']"));
    }
    public void clickUserChat() {
        click(By.xpath(".//*[./*[./div[@class='chats_i_h ellip'and text() = 'Ольга Бондарева' ]]]"));
    }
    public void typeMessage(String message){
        write(message, By.xpath(".//div[@data-placeholder='Напишите сообщение']"));
        click(By.xpath(".//button[@title='Отправить' ]"));
    }
    public boolean checkLastMessage(String text){
        return isPresent(By.xpath(".//div[@class='msg js-msg soh-s __me __private __collapsed __last']//span[text() = 'TestMessage']"));
    }
    /**
     * Загружает фото
     */
    public void addPhoto(String pathname) {
        driver.findElement(PHOTO_ADD_BUTTON).sendKeys(pathname);
    }
}
