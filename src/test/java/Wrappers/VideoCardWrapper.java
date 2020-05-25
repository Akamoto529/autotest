package Wrappers;

import Factories.LayerFactory;
import Layers.IVideoLayer;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoCardWrapper extends BasePage {
    public VideoCardWrapper(WebDriver driver){
        super(driver);
    }
    public boolean isVideoDisplayed(String videoByLinkName) {
        return isDisplayed(getVideoCardByXPath(videoByLinkName));
    }
    protected By getVideoCardByXPath(String videoCardName){
        return By.xpath(".//div[@class = 'video-card_n-w']//child::a[@title = '"+videoCardName+"']");
    }
    public IVideoLayer clickOnVideo(String videoName){
        click(getVideoCardByXPath(videoName));
        return LayerFactory.getVideoLayer(driver);
    }
}
