package Pages.FriendPage;

import Pages.VideoPage.VideoPage;
import Wrappers.VideoCardWrapper;
import org.openqa.selenium.WebDriver;

public class FriendVideoPage extends VideoPage implements IFriendVideoPage {
    public FriendVideoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public VideoCardWrapper getVideoCard(String videoName) {
        return new VideoCardWrapper(driver, videoName);
    }
}
