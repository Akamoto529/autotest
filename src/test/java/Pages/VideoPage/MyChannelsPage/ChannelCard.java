package Pages.VideoPage.MyChannelsPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChannelCard extends BasePage {
    public ChannelCard(WebDriver driver) {
        super(driver);
    }

    public By getChannelXPath(String name){
        return By.xpath(".//a[contains(@data-l,'clickDetails,title') and text() = '"+name+"']");
    }
}
