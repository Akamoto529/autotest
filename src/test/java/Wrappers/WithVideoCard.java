package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface WithVideoCard {
        default By getVideoCardByXPath(String videoCardName){
        //return By.xpath(".//div[@data-l = 't,myVideo']//child::a[@title = '"+videoCardName+"']");
            return By.xpath(".//div[@class = 'video-card_n-w']//child::a[@title = '"+videoCardName+"']");
    }
}
