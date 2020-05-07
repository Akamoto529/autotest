package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Channel {
    private final WebDriver driver;

    public Channel(String name, WebDriver driver){
        this.driver = driver;
    }
    private By getChannelXPath(String name){
        return By.xpath(".//div[@class = 'portlet']//child::div[text() = '"+name+"']");
    }
}
