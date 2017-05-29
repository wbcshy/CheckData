package bs.thread;

import bs.socket.ReceiveSocketWifi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通信线程
 * Created by 汪本成
 * email: wbc0128@163.com
 * csdn博客: blog.csdn.net/wbcshy
 * github: https://github.com/wbcshy
 * 2017/4/28
 */
public class ServerListener extends Thread{
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8085); //端口
            while(true){
                //每当有一个客服端连接就有一个socket
                Socket socket =  serverSocket.accept();//阻塞
                System.out.println("链接上客户端，开始插入数据-------");
                ReceiveSocketWifi cs = new ReceiveSocketWifi(socket);//新线程
                cs.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
