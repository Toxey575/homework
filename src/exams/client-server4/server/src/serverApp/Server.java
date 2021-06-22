package serverApp;

import com.roma.lib.SimpleMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    protected static ArrayList<Connection> clients = new ArrayList();
    private static final int PORT = 8080;

    static void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is up");
            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(new Connection(socket));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server.start();
    }
}

class Connection extends Thread {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public Connection(Socket socket) throws IOException {
        this.output = new ObjectOutputStream(socket.getOutputStream());
        this.input = new ObjectInputStream(socket.getInputStream());
        start();
    }

    @Override
    public void run() {
        SimpleMessage message;
        try {
            while (true) {
                message = (SimpleMessage) input.readObject();
                System.out.println(message); // Чтобы видеть сообщения на сервере

                for (Connection client : Server.clients) {

                    client.output.writeObject(message);
                    client.output.flush();
                }
            }
        } catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace();
        }
    }
}
