package Wrappers;

import Factories.LayerFactory;
import Layers.IVideoLayer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoCardWrapper {

    private final WebDriver driver;
    private final WebElement videoCard;
    public VideoCardWrapper(WebDriver driver, WebElement videoCard){
        this.driver = driver;
        this.videoCard = videoCard;
    }
    public VideoCardWrapper(WebDriver driver, String videoName){
        this.driver = driver;
        this.videoCard = this.driver.findElement(By.xpath(".//div[@class = 'video-card_n-w']//child::a[@title = '"+videoName+"']"));
    }
    public boolean isVideoDisplayed() {
        return videoCard.isDisplayed();
    }
    public IVideoLayer clickOnVideo(){
        videoCard.click();
        return LayerFactory.getVideoLayer(driver);
    }
}
