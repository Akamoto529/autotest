package Pages.VideoPage;

import Factories.VideoPageFactory;
import Pages.BasePage;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import Wrappers.ToolBarWrapper;
import Wrappers.VideoCardWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoPage extends BasePage implements IVideoPage {

    private static final By CREATE_CHANNEL_BUTTON = By.xpath(".//div[text() = 'Создать канал']");
    private static final By CHANNEL_NAME_INPUT_FIELD = By.xpath(".//input[@id = 'field_albName']");
    protected static final By SUBMIT_BUTTON = By.xpath(".//input[@type = 'submit']");
    private static final By ADD_VIDEO_BY_LINK_BUTTON = By.xpath(".//a[contains(@hrefattrs,'AddVideoByLink')]");
    private static final By LINK_NAME_INPUT_FIELD = By.xpath(".//div[@class = 'video-link-grabber']//child::input[@type = 'text']");
    private static final By ADD_VIDEO_FROM_FILE_BUTTON = By.xpath(".//a[contains(@href,'/video/manager')]");
    private static final By FILE_INPUT = By.xpath(".//input[@type = 'file']");
    private static final By GO_TO_EDIT_BUTTON = By.xpath(".//a[contains(@class,'go-to-editor')]");
    private static final By SIDEMENU_BLOCK = By.xpath(".//div[contains(@class,'navigation')]");
    private static final By CONTENT_BLOCK = By.xpath(".//div[contains(@id,'VideoContentBlock')]");
    private static final By SEARCH_BLOCK = By.xpath(".//div[contains(@class,'it_w search-input')]");

    protected VideoCardWrapper videoCard;
    protected ToolBarWrapper toolbar;

    public VideoPage(WebDriver driver) {
        super(driver);
        this.toolbar = new ToolBarWrapper(driver);
        this.videoCard = new VideoCardWrapper(driver);
        //waitUntilPageLoad();
    }

    @Override
    public IChannelPage createChannel(String name) {
        click(CREATE_CHANNEL_BUTTON);
        write(name, CHANNEL_NAME_INPUT_FIELD);
        click(SUBMIT_BUTTON);
        return VideoPageFactory.getChannelPage(driver);
    }

    @Override
    public IRedactVideoPage downloadVideoFromFile(String pathToFile)  {
        waitUntilPageLoad();
        click(ADD_VIDEO_FROM_FILE_BUTTON);
        hardSleep();
        driver.findElement(FILE_INPUT).sendKeys(pathToFile);
        waitUntilElementClickable(GO_TO_EDIT_BUTTON);
        click(GO_TO_EDIT_BUTTON);
        hardSleep();
        return VideoPageFactory.getRedactVideoPage(driver);
    }
    @Override
    public IMyVideoPage downloadVideoByLink(String link) {
        click(ADD_VIDEO_BY_LINK_BUTTON);
        write(link, LINK_NAME_INPUT_FIELD);
        click(SUBMIT_BUTTON);
        return VideoPageFactory.getMyVideoPage(driver);
    }

    @Override
    public IMyChannelsPage goToMyChannels(){
        driver.get("https://ok.ru/video/myAlbums");
        return VideoPageFactory.getMyChannelsPage(driver);
    }
    @Override
    public IMyVideoPage goToMyVideos() {
        driver.get("https://ok.ru/video/myVideo");
        return VideoPageFactory.getMyVideoPage(driver);
    }
    @Override
    public IMyVideoHistoryPage goToMyHistory() {
        driver.get("https://ok.ru/video/history");
        return VideoPageFactory.getMyVideoHistoryPage(driver);
    }
    @Override
    public VideoCardWrapper getVideoCard(){
        return videoCard;
    }
    @Override
    public ToolBarWrapper getToolBar(){
        return this.toolbar;
    }

    public void waitUntilPageLoad() {
        waitUntilElementVisible(CONTENT_BLOCK);
        waitUntilElementVisible(SEARCH_BLOCK);
        waitUntilElementVisible(SIDEMENU_BLOCK);
    }
}
