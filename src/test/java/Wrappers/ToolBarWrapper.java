package Wrappers;

import Factories.LayerFactory;
import Layers.*;
import Pages.*;
import Pages.FriendPage.MyFriendsPage;
import Pages.FriendPage.IMyFriendsPage;
import Pages.VideoPage.ITopVideoPage;
import Pages.VideoPage.TopVideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ToolBarWrapper extends BasePage {
    private static final By TOOLBAR_LOCATOR = By.xpath(".//div[@class = 'toolbar']");
    private static final By VIDEO_BUTTON = By.xpath(".//*[@data-l='t,video']");
    private static final By MESSAGES_BUTTON = By.xpath(".//*[@data-l='t,messages']");
    private static final By CONVERSATIONS_BUTTON = By.xpath("");
    private static final By NOTIFICATIONS_BUTTON = By.xpath("");
    private static final By FRIENDS_BUTTON = By.xpath("");
    private static final By GUESTS_BUTTON = By.xpath("");

    WebElement toolbar;

    public ToolBarWrapper(WebDriver driver){
        super(driver);
        this.toolbar = driver.findElement(TOOLBAR_LOCATOR);
    }
    public ToolBarWrapper(WebDriver driver, WebElement toolbar){
        super(driver);
        this.toolbar = toolbar;
    }

    public IChatLayer clickMessages(){
        toolbar.findElement(MESSAGES_BUTTON).click();
        return LayerFactory.getChatLayer(driver);
    }
    public IConversationsLayer clickConversations(){
        toolbar.findElement(CONVERSATIONS_BUTTON).click();
        return LayerFactory.getConversationsLayer(driver);
    }
    public INotificationsLayer clickNotifications(){
        toolbar.findElement(NOTIFICATIONS_BUTTON).click();
        return LayerFactory.getNotificationsLayer(driver);
    }
    public IMyFriendsPage clickFriends(){
        toolbar.findElement(FRIENDS_BUTTON).click();
        return new MyFriendsPage(driver);
    }
    public IGuestsPage clickGuests(){
        toolbar.findElement(GUESTS_BUTTON).click();
        return new GuestsPage(driver);
    }
    public ITopVideoPage clickVideo(){
        toolbar.findElement(VIDEO_BUTTON).click();
        return new TopVideoPage(driver);
    }
}
