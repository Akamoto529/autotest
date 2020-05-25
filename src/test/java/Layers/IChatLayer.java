package Layers;

public interface IChatLayer {
    IChatLayer clickUserChat(String userName);
    IChatLayer typeMessage(String message);
    boolean checkLastMessage(String text);
}
