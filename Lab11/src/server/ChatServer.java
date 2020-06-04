package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer implements Runnable {

    private final int serverPort;
    private final Set<ClientHandler> clients = new CopyOnWriteArraySet<>();
    public static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(50);

    public ChatServer(int serverPort) {
        this.serverPort = serverPort;
    }

    public Set<ClientHandler> getClients() {
        return clients;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Chat server is listening on port " + serverPort);
            while (true) {
                System.out.println("Server ready to accept client connection...");
                Socket client = serverSocket.accept();
                System.out.println("Accepted connection from " + client);
                ClientHandler handler = new ClientHandler(client, this);
                clients.add(handler);
                THREAD_POOL.execute(handler);
            }
        } catch (IOException e) {
            System.out.println("internal server error: " + e.getMessage());
        }
    }
}
