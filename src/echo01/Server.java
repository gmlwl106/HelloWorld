package echo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.10", 10001));
		System.out.println("<서버시작>");
		System.out.println("=============================================");
		System.out.println("[연결을 기다리고 있습니다]");
		
		Socket socket = serverSocket.accept();
		System.out.println("[클라이언트가 연결 되었습니다.]");
		
		
		//스트림
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		
		int randomNum = (int)(Math.random()*100)+1;
		
		while(true) {
			String msg = br.readLine();
			
			if(msg == null) {
				break;
			}
			
			int num = Integer.parseInt(msg);
			System.out.println("클라이언트가 입력한 숫자는 [" + num + "]입니다.");
			
			if(num > randomNum) {
				bw.write("다운");
				bw.newLine();
				bw.flush();
			} else if(num < randomNum) {
				bw.write("업");
				bw.newLine();
				bw.flush();
			} else if(num == randomNum) {
				bw.write("성공");
				bw.newLine();
				bw.flush();
			}
			
		}

		
		System.out.println("<서버종료>");
		br.close();
		bw.close();
		socket.close();
		serverSocket.close();
		
	}
}
