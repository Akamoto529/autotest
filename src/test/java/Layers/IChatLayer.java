package Layers;

public interface IChatLayer {
    ChatLayer clickUserChat(String userName);
    ChatLayer typeMessage(String message);
    boolean checkLastMessage(String text);
}
