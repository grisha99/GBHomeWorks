package homeworkfourteen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleChatServer {

    private String srvName = "Server Chat";
    private ServerSocket serverSocket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;
    Scanner scn;

    private Thread userListenerThread;

    public ConsoleChatServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер \"" + srvName + "\" запущен");

            Runnable userListener = () -> {         // задача прослушивания подключений и сообщений
                while (true) {                      // цикл ожидания подключений
                    try {
                        System.out.println("Ожидпние подключения...");
                        socket = serverSocket.accept();
                        System.out.println("Клиент " +  socket.getInetAddress() + " подключился");
                        dis = new DataInputStream(socket.getInputStream());
                        dos = new DataOutputStream(socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    while (true) {                  // цикл прослушивания входящих смс
                        try {
                            String message = dis.readUTF();
                            if (message.equalsIgnoreCase("/iWantDisconnect")) {  // клиент хочет отключиться
                                dos.writeUTF("/youCanDisconnect");                      // подтверждение отключения
                                System.out.println("Клиент отключен");
                                break;                // прерываем цикл прослушивания, одидаем новых подключений
                            }
                            System.out.println(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {               // клиент отсоединился, закрываем сокет и потоки IO
                        dis.close();
                        dos.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

        userListenerThread = new Thread(userListener);  // поток для задачи прослушивания
        userListenerThread.start();                     // запуск потока

        } catch (IOException e) {
            e.printStackTrace();
        }
        runConsoleListener();       // основной поток приема смс из консоли
    }

    private void runConsoleListener() {

        scn = new Scanner(System.in);
        while (true) {
                String msg = scn.nextLine();
                if (msg.equalsIgnoreCase("exit")) {     // хотим остановить сервер
                    if (socket != null && socket.isConnected()) {
                        try {
                            dos.writeUTF("/serverStop");        // извещаем клиента об остановке

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    scn.close();
                    System.exit(0);       // не нашел как без исключений завершить программу корректно

                }
                try {
                    dos.writeUTF(srvName + ": " + msg); // смс клиенту
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
