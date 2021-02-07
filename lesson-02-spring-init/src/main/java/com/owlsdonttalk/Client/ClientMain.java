package com.owlsdonttalk.Client;

import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

@Service
public class ClientMain  {
    final private String IP_ADPRESS = "localhost";
    final private int PORT = 8189;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public ClientMain(){

        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket(IP_ADPRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read input thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    String mes = sc.nextLine();
                    sendMsg(mes);
                }
            }
        }).start();

        try {
            while (true) {
                String str = in.readUTF();
                System.out.println("Server: " + str);
                if (str.equals("/serverClosed")) break;
            }
        } catch (
        IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String mes) {
        try {
            out.writeUTF(mes);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
