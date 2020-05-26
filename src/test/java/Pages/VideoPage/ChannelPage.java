package Pages.VideoPage;

import Factories.VideoPageFactory;
import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChannelPage extends VideoPage implements IChannelPage {
    private static final By changeChannelButton = By.xpath(".//a[@title = 'edit-album-button']");
    private static final By deleteChannelButton = By.xpath(".//a[@title = 'delete-album-button']");
    private static final By channelNameInputField = By.xpath(".//input[@id = 'field_albName']");
    private static final By submitButton = By.xpath(".//input[@type = 'submit']");

    public ChannelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IChannelPage changeChannelName(String newName) {
        click(changeChannelButton);
        write(newName, channelNameInputField);
        click(submitButton);
        return this;
    }

    @Override
    public IMyChannelsPage deleteChannel() {
        click(deleteChannelButton);
        click(submitButton);
        driver.get("https://ok.ru/video/myAlbums"); //Переписать на ожидание появления элемента
        return VideoPageFactory.getMyChannelsPage(driver);
    }
}
