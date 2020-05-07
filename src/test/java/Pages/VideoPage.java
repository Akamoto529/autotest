package Pages;

import Wrappers.Channel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoPage extends BasePage {

    private static final By videoButton = By.xpath(".//*[@data-l='t,video']");
    private static final By createChannelButton = By.xpath(".//div[text() = 'Создать канал']");
    private static final By channelNameInputField = By.xpath(".//input[@id = 'field_albName']");
    private static final By submitButton = By.xpath(".//input[@type = 'submit']");
    private static final By changeChannelButton = By.xpath(".//a[@title = 'edit-album-button']");
    private static final By deleteChannelButton = By.xpath(".//a[@title = 'delete-album-button']");
    private Channel channel;
    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public void clickVideoOnToolbar() {
        click(videoButton);
    }

    public void createChannel(String name){
        click(createChannelButton);
        write(name,channelNameInputField);
        click(submitButton);
        channel = new Channel(name, driver);
    }
    public boolean isChannelDisplayed(String channelName){
        return isDisplayed(getChannelCard(channelName));
    }
    public void changeChannelName(String newName){
        click(changeChannelButton);
        write(newName,channelNameInputField);
        click(submitButton);
    }
    public void deleteChannel(String name){
        click(getChannelCard(name));
        click(deleteChannelButton);
        click(submitButton);
    }
    private By getChannelCard(String name){
        return By.xpath(".//div[@class = 'portlet']//child::div[text() = '"+name+"']");
    }
}
