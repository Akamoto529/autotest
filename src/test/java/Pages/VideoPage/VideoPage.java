package Pages.VideoPage;

import Factories.PageFactory;
import Pages.BasePage;
import Pages.IVideoLayer;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Pages.VideoPage.MyChannelsPage.MyChannelsPage;
import Wrappers.ToolBarWrapper;
import Wrappers.WithVideoCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class VideoPage extends BasePage implements  WithVideoCard, IVideoPage {

    //private static final By myVideosButton = By.xpath(".//div[@class = 'nav-side ']//child::a[contains(@hrefattrs,'myVideo')]");
    private static final By CREATE_CHANNEL_BUTTON = By.xpath(".//div[text() = 'Создать канал']");
    private static final By CHANNEL_NAME_INPUT_FIELD = By.xpath(".//input[@id = 'field_albName']");
    protected static final By SUBMIT_BUTTON = By.xpath(".//input[@type = 'submit']");
    private static final By ADD_VIDEO_BY_LINK_BUTTON = By.xpath(".//a[contains(@hrefattrs,'AddVideoByLink')]");
    private static final By LINK_NAME_INPUT_FIELD = By.xpath(".//div[@class = 'video-link-grabber']//child::input[@type = 'text']");
    private static final By DELETE_VIDEO_BUTTON = By.xpath(".//a[@data-l = 't,delete']");
    private static final By ADD_VIDEO_FROM_FILE_BUTTON = By.xpath(".//div[@class = 'video-upload-menu_tx' and text() = 'Видео']");
    private static final By FILE_INPUT = By.xpath(".//input[@type = 'file']");
    private static final By GO_TO_EDIT_BUTTON = By.xpath(".//a[contains(@class,'go-to-editor')]");
    private static final By SIDEMENU_BLOCK = By.xpath(".//div[contains(@class,'navigation')]");
    private static final By CONTENT_BLOCK = By.xpath(".//div[contains(@id,'VideoContentBlock')]");
    private static final By SEARCH_BLOCK = By.xpath(".//div[contains(@class,'it_w search-input')]");
    private ToolBarWrapper toolbar;
    public VideoPage(WebDriver driver) {
        super(driver);
        this.toolbar = new ToolBarWrapper(driver);
        waitUntilPageLoad();
    }

    @Override
    public IChannelPage createChannel(String name) {
        click(CREATE_CHANNEL_BUTTON);
        write(name, CHANNEL_NAME_INPUT_FIELD);
        click(SUBMIT_BUTTON);
        return PageFactory.getChannelPage(driver,name);
    }

    @Override
    public VideoPage downloadVideoFromFile(String pathToFile) {
        click(ADD_VIDEO_FROM_FILE_BUTTON);
        write(pathToFile,FILE_INPUT);
        //driver.findElement(FILE_INPUT).sendKeys(pathToFile);
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(GO_TO_EDIT_BUTTON));
        click(GO_TO_EDIT_BUTTON);
        click(SUBMIT_BUTTON);
        return this;
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
    public IVideoLayer clickOnVideo(String videoName){
        click(getVideoCardByXPath(videoName));
        return PageFactory.getVideoLayer(driver);
    }
    public ToolBarWrapper getToolbar(){
        return this.toolbar;
    }


    public void waitUntilPageLoad() {
        waitUntilElementVisible(CONTENT_BLOCK);
        waitUntilElementVisible(SEARCH_BLOCK);
        waitUntilElementVisible(SIDEMENU_BLOCK);
    }
}
