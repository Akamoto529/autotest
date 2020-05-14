package Pages;

import Wrappers.Channel;
import Wrappers.VideoCard;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPage extends BasePage {

    private static final By videoButton = By.xpath(".//*[@data-l='t,video']");
    private static final By createChannelButton = By.xpath(".//div[text() = 'Создать канал']");
    private static final By channelNameInputField = By.xpath(".//input[@id = 'field_albName']");
    private static final By submitButton = By.xpath(".//input[@type = 'submit']");
    private static final By changeChannelButton = By.xpath(".//a[@title = 'edit-album-button']");
    private static final By deleteChannelButton = By.xpath(".//a[@title = 'delete-album-button']");
    private static final By addVideoByLinkButton = By.xpath(".//a[contains(@hrefattrs,'AddVideoByLink')]");
    private static final By linkNameInputField = By.xpath(".//div[@class = 'video-link-grabber']//child::input[@type = 'text']");
    private static final By myVideosButton = By.xpath(".//div[@class = 'nav-side ']//child::a[contains(@hrefattrs,'myVideo')]");

    private Channel channel;
    VideoCard videoCard;

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public void clickVideoOnToolbar() {
        click(videoButton);
    }

    public void createChannel(String name) {
        click(createChannelButton);
        write(name, channelNameInputField);
        click(submitButton);
        channel = new Channel(name, driver);
    }

    public boolean isChannelDisplayed(String channelName) {
        return isDisplayed(getChannelCard(channelName));
    }

    public void changeChannelName(String newName) {
        click(changeChannelButton);
        write(newName, channelNameInputField);
        click(submitButton);
    }

    public void deleteChannel(String name) {
        click(getChannelCard(name));
        click(deleteChannelButton);
        click(submitButton);
    }

    private By getChannelCard(String name) {
        return By.xpath(".//div[@class = 'portlet']//child::div[text() = '" + name + "']");
    }

    public void downloadVideoByLink(String link) {
        click(addVideoByLinkButton);
        write(link, linkNameInputField);
        //new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(submitButton));
        click(submitButton);
    }

    public boolean isVideoByLinkDisplayed(String videoByLinkName) {
        return isDisplayed(videoCard.getVideoCardByXPath(videoByLinkName));
    }

    public void goToMyVideos() {
        click(myVideosButton);
    }
}
