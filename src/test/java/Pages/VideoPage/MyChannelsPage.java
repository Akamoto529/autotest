package Pages.VideoPage;

import org.openqa.selenium.WebDriver;

public class MyChannelsPage extends VideoPage implements IMyChannelsPage {
    public MyChannelsPage(WebDriver driver){
        super(driver);
    }
    //Переделать ChannelCard для MyChannels
    @Override
    public boolean isChannelDisplayed(String channelName) {
        return isChannelCardDisplayed(channelName);
    }
    @Override
    public IChannelPage goToChannel(String channelName){
        click(getChannelXPath(channelName));
        return new ChannelPage(driver,channelName);
    }
}
