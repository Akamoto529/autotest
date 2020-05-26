package Pages.VideoPage;

import Pages.VideoPage.MyChannelsPage.IMyChannelsPage;

public interface IChannelPage extends IVideoPage {
    IChannelPage changeChannelName(String newName);

    IMyChannelsPage deleteChannel();
}