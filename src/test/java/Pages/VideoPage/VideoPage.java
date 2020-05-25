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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VideoPage extends BasePage implements WithToolbar, WithChannelCard,WithVideoCard, IVideoPage {

    private static final By CREATE_CHANNEL_BUTTON = By.xpath(".//div[text() = 'Создать канал']");
    private static final By CHANNEL_NAME_INPUT_FIELD = By.xpath(".//input[@id = 'field_albName']");
    protected static final By SUBMIT_BUTTON = By.xpath(".//input[@type = 'submit']");
    private static final By ADD_VIDEO_BY_LINK_BUTTON = By.xpath(".//a[contains(@hrefattrs,'AddVideoByLink')]");
    private static final By LINK_NAME_INPUT_FIELD = By.xpath(".//div[@class = 'video-link-grabber']//child::input[@type = 'text']");
    private static final By DELETE_VIDEO_BUTTON = By.xpath(".//a[@data-l = 't,delete']");
    private static final By ADD_VIDEO_FROM_FILE_BUTTON = By.xpath(".//a[contains(@href,'/video/manager')]");
    private static final By FILE_INPUT = By.xpath(".//input[@type = 'file']");
    private static final By GO_TO_EDIT_BUTTON = By.xpath(".//a[contains(@class,'go-to-editor')]");
    private static final By SIDEMENU_BLOCK = By.xpath(".//div[contains(@class,'navigation')]");
    private static final By CONTENT_BLOCK = By.xpath(".//div[contains(@id,'VideoContentBlock')]");
    private static final By SEARCH_BLOCK = By.xpath(".//div[contains(@class,'it_w search-input')]");

    private ToolBarWrapper toolbar;
    public VideoPage(WebDriver driver) {
        super(driver);
        this.toolbar = new ToolBarWrapper(driver);
        //waitUntilPageLoad();
    }

    @Override
    public IChannelPage createChannel(String name) {
        click(CREATE_CHANNEL_BUTTON);
        write(name, CHANNEL_NAME_INPUT_FIELD);
        click(SUBMIT_BUTTON);
        return PageFactory.getChannelPage(driver,name);
    }

    @Override
    public VideoPage downloadVideoFromFile(String pathToFile)  {
        waitUntilPageLoad();
        click(ADD_VIDEO_FROM_FILE_BUTTON);
        hardSleep();
        driver.findElement(FILE_INPUT).sendKeys(pathToFile);
        waitUntilElementClickable(GO_TO_EDIT_BUTTON);
        click(GO_TO_EDIT_BUTTON);
        return this;
    }
    @Override
    public IMyVideoPage downloadVideoByLink(String link) {
        click(ADD_VIDEO_BY_LINK_BUTTON);
        write(link, LINK_NAME_INPUT_FIELD);
        click(SUBMIT_BUTTON);
        return PageFactory.getMyVideoPage(driver);
    }

    @Override
    public boolean isVideoDisplayed(String videoByLinkName) {
        return isDisplayed(getVideoCardByXPath(videoByLinkName));
    }
    @Override
    public boolean isChannelCardDisplayed(String channelName) {
        return isDisplayed(getChannelXPath(channelName));
    }

    @Override
    public IMyChannelsPage goToMyChannels(){
        driver.get("https://ok.ru/video/myAlbums");
        return new MyChannelsPage(driver);
    }
    @Override
    public IMyVideoPage goToMyVideos() {
        driver.get("https://ok.ru/video/myVideo");
        return PageFactory.getMyVideoPage(driver);
    }
    @Override
    public IMyVideoHistoryPage goToMyHistory() {
        driver.get("https://ok.ru/video/history");
        return PageFactory.getMyVideoHistoryPage(driver);
    }
    @Override
    public IVideoLayer clickOnVideo(String videoName){
        click(getVideoCardByXPath(videoName));
        return PageFactory.getVideoLayer(driver);
    }

    public ToolBarWrapper getToolbar(){
        return this.toolbar;
    }

    @Override
    public void setVisibilityOfVideo(String text) {
        hardSleep();
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        select.selectByVisibleText(text);
        click(SUBMIT_BUTTON);
    }

    public void waitUntilPageLoad() {
        waitUntilElementVisible(CONTENT_BLOCK);
        waitUntilElementVisible(SEARCH_BLOCK);
        waitUntilElementVisible(SIDEMENU_BLOCK);
    }
}
