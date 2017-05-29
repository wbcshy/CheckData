package io;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 汪本成 on 2017/4/18.
 */
public class demo {

    public static void main(String[] args) {
        Date date = new Date();//获得系统时间.
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
        System.out.println(nowTime);
    }
}
