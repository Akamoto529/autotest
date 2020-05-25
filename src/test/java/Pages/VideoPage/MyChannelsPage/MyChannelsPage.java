package Pages.VideoPage.MyChannelsPage;

import Factories.VideoPageFactory;
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
        return isDisplayed(channelCard.getChannelXPath(channelName));
    }
    @Override
    public IChannelPage goToChannel(String channelName){
        click(channelCard.getChannelXPath(channelName));
        return VideoPageFactory.getChannelPage(driver);
    }
}
