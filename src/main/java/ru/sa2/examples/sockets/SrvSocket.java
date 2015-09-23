package ru.sa2.examples.sockets;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by AlVyaSmirnov on 04.05.2015.
 */
public class SrvSocket {

    public BufferedReader FROM_SOCKET;
    public PrintStream TO_SOCKET;

    private ServerSocket SRV_SOCKET;
    private Socket SOCK;
    private int port;


    public SrvSocket(@NotNull int port) throws IOException {
        this.port = port;
        SRV_SOCKET = new ServerSocket(this.port);
        SOCK = SRV_SOCKET.accept();

        FROM_SOCKET = new BufferedReader(new InputStreamReader(SOCK.getInputStream()));
        TO_SOCKET   = new PrintStream(SOCK.getOutputStream());
    }


    public void run() throws IOException {

        String MSG = FROM_SOCKET.readLine();
        System.out.println(MSG);

        if (MSG != null){
            TO_SOCKET.println("Message recieved!");
        }

    }

    public static void main(String[] args) throws IOException {
        SrvSocket srv_sock = new SrvSocket(4545);
        srv_sock.run();
    }
}
