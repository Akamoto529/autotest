package Pages.VideoPage;

import org.openqa.selenium.WebDriver;

public class MyChannelsPage extends VideoPage {
    public MyChannelsPage(WebDriver driver){
        super(driver);
    }
    //���������� ChannelCard ��� MyChannels
    public boolean isChannelDisplayed(String channelName) {
        return isDisplayed(getChannelXPath(channelName));
    }
}
