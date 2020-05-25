package Pages.VideoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MyVideoPage extends VideoPage implements IMyVideoPage{

    private static final By DELETE_VIDEO_BUTTON = By.xpath(".//a[@data-l = 't,delete']");
    private static final By VIDEO_CARD = By.xpath(".//div[@class = 'video-card_play']");

    public MyVideoPage(WebDriver driver){
        super(driver);
    }

    @Override
    public IMyVideoPage deleteVideo(String name) {
        moveToElementAndClick(VIDEO_CARD, DELETE_VIDEO_BUTTON);
        click(SUBMIT_BUTTON);
        return this;
    }

}
