package bs.socket;

import io.renren.utils.DBUtils;
import io.renren.utils.UUIDBuild;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by 汪本成
 * email: wbc0128@163.com
 * csdn博客: blog.csdn.net/wbcshy
 * github: https://github.com/wbcshy
 * 2017/4/28
 */
public class ReceiveSocketWifi extends Thread {

    static Socket socket;
    Long id;   //主键
    String tem;   //温度值
    String humi; //湿度值
    String mq;  //co2浓度
    String nowTime;  //现在的日期时间
    String wTime;   //未来三天时间
    String insql = "";


    public ReceiveSocketWifi(Socket s){
        this.socket = s;
    }

    public void run() {
        //获得输入流，并读取客户端信息
        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        int i = 1;
        //id = 2L;


        java.sql.Connection conn = null;
        java.sql.Statement stmt =null;

        try {
            //建立一个连接
            conn = DBUtils.getConnection();
            //创建表达式
            stmt= conn.createStatement();
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);   //将字节流包装为数据流
            bufferedReader = new BufferedReader(inputStreamReader);   //为输入流添加缓冲
            String info = null;

            while (null != (info = bufferedReader.readLine())) {
                //System.out.println("采集数据是" + info);

                Date date = new Date();//获得当前系统时间.
                nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
                //Timestamp goodsC_date = Timestamp.valueOf(nowTime);//把时间转换为数据库存入的datetime格式
                //获取三天后此时的系统时间
//                Calendar calendar = Calendar.getInstance();
//                calendar.set(Calendar.DAY_OF_YEAR,
//                        calendar.get(Calendar.DAY_OF_YEAR) + 3);
//                wTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
                wTime = nowTime;



                //id = UUIDBuild.getLongId();
                tem = info.substring(0, 4);
                humi = info.substring(5, 9);
                mq = info.substring(10, 15);


//                tem = Float.parseFloat(tem_val);
//                humi = Float.parseFloat(humi_val);
//                mq = Float.parseFloat(mq_val);
                //System.out.println(tem);
                //System.out.println(info);


                //DB_Connection a =new DB_Connection(tem,humi,mq);

                insql = "insert into wdata(tem,humi,mq,dateStr,date) values('"+ tem + "','"+humi+"'" + ",'" + mq + "','"+nowTime+"','"+wTime+"')";
                //insql = "insert into bs_wifidata(tem,humi,mq) values(tem,humi,mq)";

                try {
                    int result = stmt.executeUpdate(insql);
                    conn.commit();
                    if(result == 1){
                        System.out.println("插入第"+ i +"条数据成功，继续下一条数据插入");
                        System.out.println("第"+ i +"条采集数据是：" + info);
                        i++;
                    }


                    //采集数据时间的限制，模拟户外定时采集数据功能
                    try {
                        Thread.sleep(1000 * 60);  //一分钟采集一回
                        //Thread.sleep(1000 * 60 * 2);
                    }catch (InterruptedException e) {
                        System.out.println("线程休眠失败！");
                    }
                    //System.out.println(result);
                } catch (SQLException e) {
                    System.out.println("插入数据失败！");
                    e.printStackTrace();
                }


            }


            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭数据流发生错误！");
                e.printStackTrace();
            }
            socket.shutdownInput();  //关闭输入流
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);  //包装成打印流
            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } /*finally {
            //最终执行的一段代码
            try {
                if (null != printWriter) {
                    printWriter.close();
                }
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != inputStreamReader) {
                    inputStreamReader.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != socket) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}
