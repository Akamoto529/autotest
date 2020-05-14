package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface WithVideoCard {
        default By getVideoCardByXPath(String videoCardName){
        return By.xpath(".//div[@data-l = 't,myVideo']//child::a[@title = '"+videoCardName+"']");
    }
}
