package io.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by 汪本成 on 2017/4/19.
 */

//服务器线程类
public class ServerThread extends Thread{



    Socket socket = null;

    String tem = null;
    String humi = null;
    String mq = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    //线程执行操作
    public void run(){
        //获得输入流，并读取客户端信息
        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;


        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);   //将字节流包装为数据流
            bufferedReader = new BufferedReader(inputStreamReader);   //为输入流添加缓冲
            String info = null;
            while(null != (info =bufferedReader.readLine())){
                //System.out.println("采集数据是" + info);
                tem = info.substring(0,4);
                humi = info.substring(5,9);
                mq = info.substring(10,15);
                //System.out.println(mq);
                //System.out.println(info);


            }
            socket.shutdownInput();  //关闭输入流
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);  //包装成打印流
            //printWriter.write("欢迎你！");
            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最终执行的一段代码
            try {
                if (null != printWriter){
                    printWriter.close();
                }
                if (null != outputStream){
                    outputStream.close();
                }
                if (null != inputStreamReader){
                    inputStreamReader.close();
                }
                if (null != inputStream){
                    inputStream.close();
                } if (null != socket){
                    socket.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
