package io.wifi;

import io.utils.LogInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.TooManyListenersException;

import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;

/**
 * Created by 汪本成 on 2017/4/20.
 */

//接收串口数据Demo
public class ReadSerialPort{

    static String retValue = "000000";

    public void init() {
        try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("COM6");
            // 直接取得COM3端口
            System.out.println(portId.getName() + ":开启");
            LogInfo.appendLog(portId.getName() + ":开启");
            @SuppressWarnings("unused")
            Read reader = new Read(portId);
        } catch (Exception ex) {
            ex.printStackTrace();
            LogInfo.appendLog(ex.getMessage());
        }
    }

    class Read implements Runnable, SerialPortEventListener {

        InputStream inputStream;
        SerialPort serialPort;
        Thread readThread;

        public Read(CommPortIdentifier portId) throws InterruptedException {
            try {
                serialPort = (SerialPort) portId.open("MyReader", 2000);
                //portId.open("串口所有者名称", 超时等待时间);
            } catch (PortInUseException e) {
                //如果端口被占用就抛出这个异常
                e.printStackTrace();
                LogInfo.appendLog(e.getMessage());
            }

            try {
                inputStream = serialPort.getInputStream();
                //从COM3获取数据
            } catch (IOException e) {
                LogInfo.appendLog(e.getMessage());
            }

            try {
                serialPort.addEventListener(this);
                //添加监听器
            } catch (TooManyListenersException e) {
            }

            serialPort.notifyOnDataAvailable(true);
            /*
             * 侦听到串口有数据,触发串口事件
             */
            try {
                serialPort.setSerialPortParams(2400,//波特率
                        SerialPort.DATABITS_8,//数据位数
                        SerialPort.STOPBITS_1,//停止位
                        SerialPort.PARITY_NONE);//校验
            } catch (UnsupportedCommOperationException e) {
            }
            readThread = new Thread(this);
            readThread.start();
            //启动线程
        }

        public void run() {
            try {
                Thread.sleep(2000);
                serialPort.close();
                System.out.println("COM1:关闭");
                //设定30秒后端口关闭，程序随之结束
            } catch (InterruptedException e) {
                LogInfo.appendLog(e.getMessage());
            }
        }

        /**
         * BI -通讯中断. CD -载波检测. CTS -清除发送. DATA_AVAILABLE -有数据到达. DSR -数据设备准备好.
         * FE -帧错误. OE -溢位错误. OUTPUT_BUFFER_EMPTY -输出缓冲区已清空. PE -奇偶校验错. RI -
         * 振铃指示. 一般最常用的就是DATA_AVAILABLE--串口有数据到达事件。
         */
        public void serialEvent(SerialPortEvent event) {

            switch (event.getEventType()) {
                case SerialPortEvent.BI:
                case SerialPortEvent.OE:
                case SerialPortEvent.FE:
                case SerialPortEvent.PE:
                case SerialPortEvent.CD:
                case SerialPortEvent.CTS:
                case SerialPortEvent.DSR:
                case SerialPortEvent.RI:
                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                    break;
                case SerialPortEvent.DATA_AVAILABLE:
                    byte[] readBuffer = new byte[20];

                    try {
                        while (inputStream.available() > 0) {
                            //int numBytes = inputStream.read(readBuffer);
                            //System.out.println("numBytes" + numBytes);
                            //retValue = new String(readBuffer).trim();
                            //System.out.println(retValue);
                            BufferedReader comReader = new BufferedReader(new InputStreamReader(inputStream));
                            String temp = comReader.readLine().trim();
                            System.out.println(comReader.read() + ":" + temp);
                            if (temp.indexOf("#0") >= 0 || temp.indexOf("#8") >= 0) {
                                int p = temp.indexOf("#");
                                temp = temp.substring(p + 3, temp.length()).replace(" ", "").trim();
                                try {
                                    Integer.parseInt(temp);
                                } catch (Exception e) {
                                    System.out.println("忽略次数据:" + temp);
                                    LogInfo.appendLog("忽略次数据:" + temp);
                                    retValue = "0";
                                    return;
                                }
                                System.out.println(temp);
                                retValue = String.valueOf(Integer.parseInt(temp.substring(1, 5))) + "." + temp.substring(5, 6);
                                System.out.println(retValue);
                            }
                        }
                        //strWGT = new String(readBuffer).trim();
                        //System.out.println(strWGT);
                        //输出读入的字符
                    } catch (IOException e) {
                        LogInfo.appendLog(e.getMessage());
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ReadSerialPort reader = new ReadSerialPort();
        reader.init();
        reader.retValue = "0";
        //(reader.retValue);
    }
}
