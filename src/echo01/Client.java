package echo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		System.out.println("<클라이언트 시작>");
		System.out.println("=============================================");
		
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.0.10", 10001));
		System.out.println("[서버에 연결되었습니다.]");
		
		
		//스트림
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("<<<<<업다운 게임>>>>>");
		
		while(true) {
			String num = sc.nextLine();
			
			if(num.equals("/q")) {
				break;
			}
			bw.write(num);
			bw.newLine();
			bw.flush();
			
			String msg = br.readLine();
			
			System.out.println(msg);
			if(msg.equals("성공")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
		}
		
		
		System.out.println("=============================================");
		System.out.println("<클라이언트 종료>");
		sc.close();
		br.close();
		bw.close();
		socket.close();
	}
	
}
