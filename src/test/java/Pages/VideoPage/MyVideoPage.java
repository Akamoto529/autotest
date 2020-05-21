package Pages.VideoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MyVideoPage extends VideoPage implements IMyVideoPage{
    private static final By DELETE_VIDEO_BUTTON = By.xpath(".//a[@data-l = 't,delete']");

    public MyVideoPage(WebDriver driver){
        super(driver);
    }

    @Override
    public IMyVideoPage deleteVideo(String name) {
        click(getVideoCardByXPath(name));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(getVideoCardByXPath(name))).pause(1).click(driver.findElement(DELETE_VIDEO_BUTTON)).build().perform();
        //        //click(deleteVideoButton);
        click(SUBMIT_BUTTON);
        return this;
    }
}
