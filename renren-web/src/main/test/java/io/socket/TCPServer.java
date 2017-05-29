package io.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 汪本成 on 2017/4/19.
 */

//建立TCP服务端
public class TCPServer {

    private final static boolean flag = true;
    private static int count = 0;    //记录客户端的数量
    private static Socket socket = null;

    public static ServerSocket getSocket(int port) {
        ServerSocket serverSocket = null;
        try {
            //1.创建服务器端socket,即ServerSocket,并绑定指定的端口，并在端口进行监听
            serverSocket = new ServerSocket(port);
            System.out.println("***服务器即将启动,等待客户端的连接***");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverSocket;
    }

    public static void main(String[] args) {
        int port = 8085;
        try {
            ServerSocket serverSocket = getSocket(port);
            //循环监听等待客户端的响应
            while(flag){
                //通过accept()方法对客户端进行监听，等待客户端连接
                socket = serverSocket.accept();   //返回的实例与客户端进行通信
                ServerThread serverThread = new ServerThread(socket);

                //启动线程
                serverThread.start();
                count++;
                System.out.println("客户端数量: "+count);
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP: "+ address.getHostAddress());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
