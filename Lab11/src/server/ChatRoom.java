package server;

public class ChatRoom {

    public static void main(String[] args) {

        ChatServer server = new ChatServer(8088);
        new Thread(server).start();
    }
}
