package Wrappers;

import org.openqa.selenium.By;

public interface WithChannelCard {
    default By getChannelXPath(String name){
        return By.xpath(".//div[@class = 'portlet']//child::div[text() = '"+name+"']");
    }
}
