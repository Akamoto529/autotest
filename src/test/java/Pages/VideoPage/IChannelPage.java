package Pages.VideoPage;

public interface IChannelPage extends IVideoPage {
    IChannelPage changeChannelName(String newName);
    IMyChannelsPage deleteChannel();
}