package ru.sa2.examples.sockets;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by AlVyaSmirnov on 04.05.2015.
 */
public class ClientSocket {

    public BufferedReader FROM_SOCKET;
    public PrintStream TO_SOCKET;

    private Socket SOCK;
    private int port;


    public ClientSocket(String host, @NotNull int port) throws IOException {
        this.port = port;
        SOCK = new Socket(host, port);

        FROM_SOCKET = new BufferedReader(new InputStreamReader(SOCK.getInputStream()));
        TO_SOCKET   = new PrintStream(SOCK.getOutputStream());
    }


    public void run() throws IOException {

        TO_SOCKET.println("Hello!");

        String MSG = FROM_SOCKET.readLine();
        System.out.println(MSG);
    }

    public static void main(String[] args) throws IOException {
        ClientSocket cl_sock = new ClientSocket("localhost", 4545);
        cl_sock.run();
    }
}
