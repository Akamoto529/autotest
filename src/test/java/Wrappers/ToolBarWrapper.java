package Wrappers;

import Pages.BasePage;
import Pages.ChatLayer;
import Pages.VideoPage.VideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ToolBarWrapper extends BasePage {
    static final By VIDEO_BUTTON = By.xpath(".//*[@data-l='t,video']");
    static final By MESSAGE_BUTTON = By.xpath(".//*[@data-l='t,messages']");

    public ToolBarWrapper(WebDriver driver){
        super(driver);
    }
    public ChatLayer clickMessages(){
        driver.findElement(MESSAGE_BUTTON).click();
        return new ChatLayer(driver);
    }
    public VideoPage clickVideo(){
        driver.findElement(VIDEO_BUTTON).click();
        return new VideoPage(driver);
    }
}
