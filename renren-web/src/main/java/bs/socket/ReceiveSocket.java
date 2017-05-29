package bs.socket;

import io.renren.utils.DBUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 测试采集数据
 * Created by 汪本成
 * email: wbc0128@163.com
 * csdn博客: blog.csdn.net/wbcshy
 * github: https://github.com/wbcshy
 * 2017/4/28
 */
public class ReceiveSocket extends Thread {

    static Socket socket;
    static int getCounter = 0;     //定义接收到的数据大小
    static float tem; //温度值
    static float humi; //湿度值
    static float mq;  //co2值
    //static int state = 1 ; //状态

    public ReceiveSocket(Socket s){
        this.socket = s;
    }

    public void run()
    {
        try {
            boolean connect = true;                     //连接成功了的
            byte getData[] = new byte[5];
            //温度值（1）+湿度值（1）+co2浓度值（1）= 4个字节
            InputStream isTemplet = null;
            OutputStream osTemplet = null;

            while(true)
            {
                try {
                    osTemplet = socket.getOutputStream();
                    isTemplet = socket.getInputStream();

                } catch (Exception e) {
                    connect = false ;
                    System.out.println("Broken A");
                    break;
                }
                if(socket.isConnected()) //判断是否在连接中
                {
                    try
                    {
                        getCounter=isTemplet.read(getData, 0, 5);

                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                        System.out.println("Broken B");
                        connect = false;
                        break;
                    }
                }
                //存入数据库


                tem =getData[1];//得到温度值
                humi = getData[3];  //得到湿度值
                mq = getData[4];
                //state = getData[4];//得到状态值
                System.out.println(tem);
                //System.out.println(state);
                //DB_Connection a =new DB_Connection(tem,humi,mq);
                //System.out.println(getCounter); //打印出接收到的数据个数

//                if(getData[0] == -86 && getData[1] == -86) //0xaa就是-86
//                {
//                    tem =getData[1];//得到温度值
//                    humi = getData[2];  //得到湿度值
//                    mq = getData[3];
//                    state = getData[4];//得到状态值
//                    System.out.println(tem);
//                    System.out.println(state);
//                    DB_Connection a =new DB_Connection(tem,humi,mq,state);
//                    getData[0] = 0; //防止多次进入
//                }
            }



        } catch (Exception e) {
            e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因
        }
    }
}
