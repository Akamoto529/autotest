package Pages.FriendPage;

import Pages.VideoPage.VideoPage;
import Wrappers.VideoCardWrapper;
import org.openqa.selenium.WebDriver;

public class FriendVideoPage extends VideoPage implements IFriendVideoPage {
    protected final VideoCardWrapper videoCard;
    public FriendVideoPage(WebDriver driver) {
        super(driver);
        this.videoCard = new VideoCardWrapper(driver);
    }
    @Override
    public VideoCardWrapper getVideoCard(){
        return this.videoCard;
    }
}
