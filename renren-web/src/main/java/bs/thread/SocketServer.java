package bs.thread;

/**
 * socket采集wifi数据测试程序入口
 * Created by 汪本成
 * email: wbc0128@163.com
 * csdn博客: blog.csdn.net/wbcshy
 * github: https://github.com/wbcshy
 * 2017/4/28
 */
public class SocketServer {

    public static void main(String[] args) {
        new ServerListener().start(); //建立实时监听客服端
    }

}
