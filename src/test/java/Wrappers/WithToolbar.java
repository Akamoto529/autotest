package Wrappers;
import Pages.ChatLayer;
import Pages.VideoPage.VideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface WithToolbar {
    By VIDEO_BUTTON = By.xpath(".//*[@data-l='t,video']");
    By MESSAGE_BUTTON = By.xpath(".//*[@data-l='t,messages']");

    default ChatLayer clickMessages(WebDriver driver){
        driver.findElement(MESSAGE_BUTTON).click();
        return new ChatLayer(driver);
    }
    default VideoPage clickVideo(WebDriver driver){
        driver.findElement(VIDEO_BUTTON).click();
        return new VideoPage(driver);
    }
}
