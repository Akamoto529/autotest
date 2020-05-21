package Pages.VideoPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoSideBarWrapper extends BasePage {
    private static final By TOP_VIDEO_BUTTON =By.xpath("");
    private static final By LIVEAPP_BUTTON =By.xpath("");
    private static final By SUGGESTED_ALBUMS_BUTTON =By.xpath("");
    private static final By NEW_BUTTON =By.xpath("");
    private static final By LIVE_BUTTON =By.xpath("");
    private static final By SPORT_BUTTON =By.xpath("");
    private static final By EDUCATION_BUTTON =By.xpath("");
    private static final By CHANNELS_BUTTON =By.xpath("");
    private static final By MY_VIDEO_BUTTON =By.xpath("");
    public VideoSideBarWrapper(WebDriver driver){
        super(driver);
    }

    public ITopVideoPage goToTopVideo(){
        click(TOP_VIDEO_BUTTON);
        return new TopVideoPage(driver);
    }
    public IMyVideoPage goMyVideo(){
        click(MY_VIDEO_BUTTON);
        return new MyVideoPage(driver);
    }
}
