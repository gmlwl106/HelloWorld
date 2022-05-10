package starbucks;

import java.io.IOException;
import java.util.Scanner;

public class StarbucksApp {

	public static void main(String[] args) throws IOException {

		
		Menu m = new Menu();
		m.readMenu();
		m.showMenu();
		int price = m.order(m);
		
		System.out.println("총 결제금액은 "+price+"원 입니다.");
		
		System.out.println("스타벅스 회원입니까?(y/n)");
		Scanner sc = new Scanner(System.in);
		String yn = sc.nextLine();
		
		if(yn.equals("y")) {
			System.out.print("휴대폰 번호 뒷자리 4자리를 입력해주세요 > ");
			String number = sc.nextLine();
			
			
			
			
			
		} else if(yn.equals("n")) {
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
