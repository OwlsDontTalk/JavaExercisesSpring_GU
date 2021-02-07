package com.owlsdonttalk.Server;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

@Service
public class ServerMain {
    private ClientHandler client;
    Scanner sc = new Scanner(System.in);

    public ServerMain(){
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            //output thread
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        if(client!=null){
                            String s = sc.nextLine();
                            client.sendMsg(s);
                        }
                    }
                }
            }).start();

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                client = new ClientHandler(this,socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
