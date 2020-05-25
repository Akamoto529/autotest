package Pages.VideoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyVideoHistoryPage extends VideoPage implements IMyVideoHistoryPage {
    private static final By CLEAR_HISTORY_BUTTON = By.xpath(".//a[contains(@hrefattrs,'ClearViewHistory')]");

    public MyVideoHistoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IMyVideoHistoryPage cleanHistory() {
        click(CLEAR_HISTORY_BUTTON);
        click(SUBMIT_BUTTON);
        return this;
    }
}
