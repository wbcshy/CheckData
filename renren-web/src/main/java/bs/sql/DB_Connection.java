package bs.sql;

import io.renren.utils.DBUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入wifi数据到数据库中
 * Created by 汪本成
 * email: wbc0128@163.com
 * csdn博客: blog.csdn.net/wbcshy
 * github: https://github.com/wbcshy
 * 2017/4/28
 */
public class DB_Connection {

    /*
    String Connection="jdbc:mysql://hdp-node-01:3306/RY?"+
            "user=root&password=&characterEncoding=UTF8";
    String uri = "jdbc:mysql://localhost:3306/RY?";
    String user = "user=root&password=&characterEncoding=UTF8";

    String connet = "jdbc:mysql://xxx.xxx.xxx.xxx:3306/RY?"
            + "user=root&password=&useUnicode=true&characterEncoding=UTF8";
    */

    String inSql = null;    //插入的sql语句
    //初始化此类方法
    public DB_Connection(float tem, float humi, float mq)
    {
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

        /*

        Date date = new Date();//获得系统时间.
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
        Timestamp goodsC_date = Timestamp.valueOf(nowTime);//把时间转换
        //System.out.println(goodsC_date);
        */

        inSql = "insert into bs_wifidata(tem,humi,mq) values(tem,humi,mq)";


        /*
        if(state ==1)
            inSql = "insert into bs_wifidata(tem,humi,mq,state,Dtime) values('" + tem + humi + mq + "','采集正常','" + goodsC_date + "')";
        else {
            inSql = "insert into bs_wifidata(tem,humi,mq,state,Dtime) values('" + tem + humi + mq + "','采集失败','" + goodsC_date + "')";
        }
        */
        try {
            stmt.executeUpdate(inSql);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("插入数据失败！");
            e.printStackTrace();
        }


        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("关闭数据流发生错误！");
            e.printStackTrace();
        }


    }
}
