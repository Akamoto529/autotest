package Pages.VideoPage.MyChannelsPage;

import Pages.VideoPage.ChannelPage;
import Pages.VideoPage.IChannelPage;
import Pages.VideoPage.VideoPage;
import org.openqa.selenium.WebDriver;

public class MyChannelsPage extends VideoPage implements IMyChannelsPage {
    private final ChannelCard channelCard;
    public MyChannelsPage(WebDriver driver){
        super(driver);
        channelCard = new ChannelCard(driver);
    }
    @Override
    public boolean isChannelDisplayed(String channelName) {
        return isChannelCardDisplayed(channelName);
    }
    @Override
    public IChannelPage goToChannel(String channelName){
        click(channelCard.getChannelXPath(channelName));
        return new ChannelPage(driver,channelName);
    }
}
