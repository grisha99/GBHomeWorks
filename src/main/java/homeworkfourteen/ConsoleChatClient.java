package homeworkfourteen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleChatClient {

    private final String SRV_ADDR;
    private final int SRV_PORT;
    private final String CLIENT_NAME;
    private Thread serverListenerThread;

    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;

    public ConsoleChatClient(String serverAddress, int serverPort) {
        CLIENT_NAME = "Клиент";
        SRV_ADDR = serverAddress;
        SRV_PORT = serverPort;
        try {
            socket = new Socket(serverAddress, SRV_PORT);
        } catch (IOException e) {
            System.out.println("Ошибка подключения.");
            System.out.println("Адрес сервера: " + SRV_ADDR);
            System.out.println("Порт сервера: " + SRV_PORT);
            e.printStackTrace();
            return;
        }

        Runnable serverListener = () -> {       // задача прослушивания сообщений от сервера
            while (true) {
                try {
                    String msgFromServer = dis.readUTF();
                    if (msgFromServer.equalsIgnoreCase("/youCanDisconnect")) {  // ответ сервера что могу остановиться
                        break;
                    }
                    if (msgFromServer.equalsIgnoreCase("/serverStop")) {    // сервер упал
                        System.out.println("Сервер упал. Отключение!");
                        //System.exit(0);
                        break;
                    }
                    System.out.println(msgFromServer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            serverListenerThread = new Thread(serverListener);
            serverListenerThread.start();

            runUserListener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runUserListener() {
        Scanner scn = new Scanner(System.in);

        try {

            while (true) {
                String userMsg = scn.nextLine();
                if (!serverListenerThread.isAlive()) {
                    break;
                }
                if (userMsg.equalsIgnoreCase("exit")) {
                    dos.writeUTF("/iWantDisconnect");       // сообщение серверу что хочу отключиться
                    serverListenerThread.join();                // ожидание ответа что могу выключаться
                    break;
                } else {
                    dos.writeUTF(CLIENT_NAME + ": " + userMsg); // смс на сервер
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        scn.close();
        try {
            dis.close();
            dos.close();
            socket.close();
            System.out.println("Выход");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
