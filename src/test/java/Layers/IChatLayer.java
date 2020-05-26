package Layers;

import Wrappers.WithChat;

public interface IChatLayer extends WithChat {
    IChatLayer clickUserChat(String userName);
    IChatLayer typeMessage(String message);
}
