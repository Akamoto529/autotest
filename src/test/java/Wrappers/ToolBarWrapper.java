package Wrappers;

import Factories.LayerFactory;
import Layers.*;
import Pages.*;
import Pages.VideoPage.ITopVideoPage;
import Pages.VideoPage.TopVideoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ToolBarWrapper extends BasePage {
    static final By VIDEO_BUTTON = By.xpath(".//*[@data-l='t,video']");
    static final By MESSAGES_BUTTON = By.xpath(".//*[@data-l='t,messages']");
    static final By CONVERSATIONS_BUTTON = By.xpath("");
    static final By NOTIFICAATIONS_BUTTON = By.xpath("");
    static final By FRIENDS_BUTTON = By.xpath("");
    static final By GUESTS_BUTTON = By.xpath("");

    public ToolBarWrapper(WebDriver driver){
        super(driver);
    }

    public IChatLayer clickMessages(){
        driver.findElement(MESSAGES_BUTTON).click();
        return LayerFactory.getChatLayer(driver);
    }
    public IConversationsLayer clickConversations(){
        driver.findElement(CONVERSATIONS_BUTTON).click();
        return LayerFactory.getConversationsLayer(driver);
    }
    public INotificationsLayer clickNotifications(){
        driver.findElement(NOTIFICAATIONS_BUTTON).click();
        return LayerFactory.getNotificationsLayer(driver);
    }
    public IFriendsPage clickFriends(){
        driver.findElement(VIDEO_BUTTON).click();
        return new FriendsPage(driver);
    }
    public IGuestsPage clickGuests(){
        driver.findElement(VIDEO_BUTTON).click();
        return new GuestsPage(driver);
    }
    public ITopVideoPage clickVideo(){
        driver.findElement(VIDEO_BUTTON).click();
        return new TopVideoPage(driver);
    }
}
