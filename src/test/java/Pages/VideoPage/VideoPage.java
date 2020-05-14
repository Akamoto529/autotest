package Pages.VideoPage;

import Pages.BasePage;
import Pages.VideoLayer;
import Wrappers.ToolBarWrapper;
import Wrappers.WithChannelCard;
import Wrappers.WithVideoCard;
import Wrappers.WithToolbar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoPage extends BasePage implements WithToolbar, WithChannelCard,WithVideoCard {

    private static final By myVideosButton = By.xpath(".//div[@class = 'nav-side ']//child::a[contains(@hrefattrs,'myVideo')]");
    private static final By CREATE_CHANNEL_BUTTON = By.xpath(".//div[text() = 'Создать канал']");
    private static final By CHANNEL_NAME_INPUT_FIELD = By.xpath(".//input[@id = 'field_albName']");
    private static final By SUBMIT_BUTTON = By.xpath(".//input[@type = 'submit']");
    private static final By ADD_VIDEO_BY_LINK_BUTTON = By.xpath(".//a[contains(@hrefattrs,'AddVideoByLink')]");
    private static final By LINK_NAME_INPUT_FIELD = By.xpath(".//div[@class = 'video-link-grabber']//child::input[@type = 'text']");
    private ToolBarWrapper toolbar;
    public VideoPage(WebDriver driver) {
        super(driver);
        this.toolbar = new ToolBarWrapper(driver);
    }


    public ChannelPage createChannel(String name) {
        click(CREATE_CHANNEL_BUTTON);
        write(name, CHANNEL_NAME_INPUT_FIELD);
        click(SUBMIT_BUTTON);
        return new ChannelPage(driver, name);
    }

    public boolean isChannelDisplayed(String channelName) {
        return isDisplayed(getChannelXPath(channelName));
    }

    public VideoPage downloadVideoByLink(String link) {
        click(ADD_VIDEO_BY_LINK_BUTTON);
        write(link, LINK_NAME_INPUT_FIELD);
        //new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(submitButton));
        click(SUBMIT_BUTTON);
        return this;
    }

    public VideoPage deleteVideo(String name) {
        click(getVideoCardByXPath(name));
        //click(deleteVideoButton);
        //click(submitButton);
        return this;
    }

    public boolean isVideoByLinkDisplayed(String videoByLinkName) {
        return isDisplayed(getVideoCardByXPath(videoByLinkName));
    }

    public VideoPage goToMyVideos() {
        driver.get("https://ok.ru/video/myVideo");
        return this;
        /*try {
            driver.wait(10);
        }
        catch (InterruptedException e){
            System.out.println("KEKW");
        }
        click(myVideosButton);
        return this;*/
    }
    public VideoLayer clickOnVideo(String videoName){
        click(getVideoCardByXPath(videoName));
        return new VideoLayer(driver);
    }
    public ToolBarWrapper getToolbar(){
        return this.toolbar;
    }
}
