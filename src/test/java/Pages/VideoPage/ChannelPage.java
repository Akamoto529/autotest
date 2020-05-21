package Pages.VideoPage;

import Wrappers.WithChannelCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChannelPage extends VideoPage {
    private static final By changeChannelButton = By.xpath(".//a[@title = 'edit-album-button']");
    private static final By deleteChannelButton = By.xpath(".//a[@title = 'delete-album-button']");
    private static final By channelNameInputField = By.xpath(".//input[@id = 'field_albName']");
    private static final By submitButton = By.xpath(".//input[@type = 'submit']");
    private String name;

    ChannelPage(WebDriver driver, String channelName){
        super(driver);
        this.name = channelName;
    }

    public ChannelPage changeChannelName(String newName) {
        click(getChannelXPath(name));
        click(changeChannelButton);
        write(newName, channelNameInputField);
        click(submitButton);
        this.name = newName;
        return this;
    }

    public MyChannelsPage deleteChannel() {
        click(getChannelXPath(name));
        click(deleteChannelButton);
        click(submitButton);
        driver.get("https://ok.ru/video/myAlbums");
        //waitUntilNotElementInvisible();
        return new MyChannelsPage(driver);
    }
}
