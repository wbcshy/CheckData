package io.socket;



import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by 汪本成 on 2017/4/18.
 */

// 建立TCP客户端
public class TCPClient {

	private final static String LOCATION = "192.168.43.130";
	private final static int PORT = 8085;


	public static OutputStream getOutputStream(String location, int port) {
        Socket socket = null;
        OutputStream os = null;
		try {
			socket = new Socket(location, port);
			os =  socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return os;
	}



	public static void main(String[] args) {
		try {
			// 1.创建Socket,用于向服务器端发送请求
			Socket socket = new Socket(LOCATION, PORT);
			// 2.创建Socket字节输出流
			OutputStream os = socket.getOutputStream();
			// 3.将字节输出流包装成Print流
			PrintWriter pw = new PrintWriter(os);
			//pw.write("用户名:zh;密码:456");
			pw.flush();
			socket.shutdownOutput(); // 关闭输出流
			// 4.创建输入流接收服务器端响应的数据
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("数据是" + info);
			}
			socket.shutdownInput();// 关闭输入流
			// 5.关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
