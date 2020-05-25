package Pages;

import Pages.FriendPage.IUserPage;
import Wrappers.WithToolbar;

public interface IMainPage extends WithToolbar {
    IUserPage goToFriendPage(String FriendUrl);
}
