package Pages;

import Factories.PageFactory;
import Pages.FriendPage.IUserPage;
import org.openqa.selenium.By;
import Wrappers.ToolBarWrapper;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage implements IMainPage {
    private static final By ACCEPT_FRIENDSHIP_BUTTON = By.xpath(".//span[@data-l = 't,growl_link']");
    private final ToolBarWrapper toolbar;

    public MainPage(WebDriver driver) {
        super(driver);
        this.toolbar = new ToolBarWrapper(driver);
    }

    @Override
    public ToolBarWrapper getToolBar() {
        return toolbar;
    }

    @Override
    public IUserPage goToFriendPage(String friendUrl) {
        driver.get(friendUrl);
        return PageFactory.getUserPage(driver);
    }

    public IMainPage acceptFriendship() {
        click(ACCEPT_FRIENDSHIP_BUTTON);
        return this;
    }
}
