package Layers;

import Wrappers.WithChat;

public interface IChatLayer extends WithChat {
    IChatLayer typeMessage(String message);
}
