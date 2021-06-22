package clientApp;

import com.roma.lib.SimpleMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 8080;
    private static Scanner scanner = new Scanner(System.in);
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static String name;

    public static void start() {
        try {
            Socket socket = new Socket(IP, PORT);
            if (socket.isConnected()) {
                System.out.println("Connection established");
            }
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            System.out.println("Enter your name");
            name = scanner.nextLine();

            Writer writer = new Writer();
            writer.start();

            Reader reader = new Reader();
            reader.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static class Writer extends Thread {

        @Override
        public void run() {

            SimpleMessage message;

            try {
                while (true) {
                    System.out.println("Enter your message");
                    String text = scanner.nextLine();

                    message = new SimpleMessage(name, text);

                    Client.output.writeObject(message);
                    Client.output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    static class Reader extends Thread {

        @Override
        public void run() {

            SimpleMessage message;

            try {
            while (true) {
                message = (SimpleMessage) input.readObject();
                System.out.println(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }  catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}

