package Pages.VideoPage;

import Factories.PageFactory;
import Pages.BasePage;
import Pages.IVideoLayer;
import Wrappers.ToolBarWrapper;
import Wrappers.WithChannelCard;
import Wrappers.WithVideoCard;
import Wrappers.WithToolbar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoPage extends BasePage implements WithToolbar, WithChannelCard,WithVideoCard, IVideoPage {

    //private static final By myVideosButton = By.xpath(".//div[@class = 'nav-side ']//child::a[contains(@hrefattrs,'myVideo')]");
    private static final By CREATE_CHANNEL_BUTTON = By.xpath(".//div[text() = 'Создать канал']");
    private static final By CHANNEL_NAME_INPUT_FIELD = By.xpath(".//input[@id = 'field_albName']");
    protected static final By SUBMIT_BUTTON = By.xpath(".//input[@type = 'submit']");
    private static final By ADD_VIDEO_BY_LINK_BUTTON = By.xpath(".//a[contains(@hrefattrs,'AddVideoByLink')]");
    private static final By LINK_NAME_INPUT_FIELD = By.xpath(".//div[@class = 'video-link-grabber']//child::input[@type = 'text']");

    private ToolBarWrapper toolbar;
    public VideoPage(WebDriver driver) {
        super(driver);
        this.toolbar = new ToolBarWrapper(driver);
    }

    @Override
    public IChannelPage createChannel(String name) {
        click(CREATE_CHANNEL_BUTTON);
        write(name, CHANNEL_NAME_INPUT_FIELD);
        click(SUBMIT_BUTTON);
        return PageFactory.getChannelPage(driver,name);
    }

    @Override
    public boolean isChannelCardDisplayed(String channelName) {
        return isDisplayed(getChannelXPath(channelName));
    }

    @Override
    public IMyVideoPage downloadVideoByLink(String link) {
        click(ADD_VIDEO_BY_LINK_BUTTON);
        write(link, LINK_NAME_INPUT_FIELD);
        //new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(submitButton));
        click(SUBMIT_BUTTON);
        return PageFactory.getMyVideoPage(driver);
    }
    @Override
    public boolean isVideoDisplayed(String videoByLinkName) {
        return isDisplayed(getVideoCardByXPath(videoByLinkName));
    }

    public IMyVideoPage goToMyVideos() {
        driver.get("https://ok.ru/video/myVideo");
        return PageFactory.getMyVideoPage(driver);
    }
    @Override
    public IVideoLayer clickOnVideo(String videoName){
        click(getVideoCardByXPath(videoName));
        return PageFactory.getVideoLayer(driver);
    }

    public ToolBarWrapper getToolbar(){
        return this.toolbar;
    }
}
