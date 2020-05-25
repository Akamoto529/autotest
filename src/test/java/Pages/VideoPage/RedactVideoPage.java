package Pages.VideoPage;

import Factories.VideoPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RedactVideoPage  extends VideoPage implements IRedactVideoPage {
    public RedactVideoPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public IRedactVideoPage setVisibilityOfVideo(String text) {
        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        select.selectByVisibleText(text);
        return this;
    }
    @Override
    public IMyVideoPage acceptRedacting() {
        click(SUBMIT_BUTTON);
        return VideoPageFactory.getMyVideoPage(driver);
    }
}
