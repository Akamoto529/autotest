package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VideoCard {
    private final WebDriver driver;
    public VideoCard(String name, WebDriver driver){
        this.driver = driver;
    }
    public By getVideoCardByXPath(String videoCardName){
        return By.xpath(".//div[@data-l = 't,myVideo']//child::a[@title = '"+videoCardName+"']");
    }
}
