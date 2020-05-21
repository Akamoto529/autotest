package Pages.VideoPage;

import Factories.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChannelPage extends VideoPage implements IChannelPage {
    private static final By changeChannelButton = By.xpath(".//a[@title = 'edit-album-button']");
    private static final By deleteChannelButton = By.xpath(".//a[@title = 'delete-album-button']");
    private static final By channelNameInputField = By.xpath(".//input[@id = 'field_albName']");
    private static final By submitButton = By.xpath(".//input[@type = 'submit']");
    private String name;

    public ChannelPage(WebDriver driver){
        super(driver);
        //this.name = channelName; //Нахождение имени
    }
    public ChannelPage(WebDriver driver, String channelName){
        super(driver);
        this.name = channelName;
    }

    @Override
    public IChannelPage changeChannelName(String newName) {
        click(getChannelXPath(name));
        click(changeChannelButton);
        write(newName, channelNameInputField);
        click(submitButton);
        this.name = newName;
        return this;
    }

    @Override
    public IMyChannelsPage deleteChannel() {
        click(getChannelXPath(name));
        click(deleteChannelButton);
        click(submitButton);
        driver.get("https://ok.ru/video/myAlbums"); //Переписать на ожидание появления элемента
        return PageFactory.getMyChannelsPage(driver);
    }
}
