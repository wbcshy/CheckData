package bs.thread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 实现socket结束wifi数据线程随JAVAWEB启动而运行
 * Created by wbcshy
 * email: wbc0128@163.com
 * csdn博客: blog.csdn.net/wbcshy
 * github: https://github.com/wbcshy
 * 2017/5/2
 */
public class ListenThread implements ServletContextListener{

    //标注要加载的线程类
    private ServerListener serverListener;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String str = null;
        if (str == null && serverListener == null) {
            serverListener = new ServerListener();
            serverListener.start(); // servlet 上下文初始化时启动 socket
        } else {
            serverListener.start();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (serverListener != null && serverListener.isInterrupted()) {
            serverListener.interrupt();
        }
    }
}
