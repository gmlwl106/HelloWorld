package starbucks;

import java.io.IOException;
import java.util.Scanner;

public class StarbucksApp {

	public static void main(String[] args) throws IOException {

		MenuView menuView = new MenuView();
		MenuManager menuManager = new MenuManager();
		
		
		//타이틀과 메뉴 출력
		menuView.showTitle();
		menuView.showMenu(menuManager.getmList());
		
		int total = menuManager.choiceMenu();
		menuView.showTotal(total);

		CustomerManager cManager = new CustomerManager();
		
		

		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.out.print("스타벅스 고객이신가요?(y/n)-> ");
		String yn = sc.nextLine();
		
		//고객일때
		if(yn.equals("y")) {
			
			System.out.print("휴대폰 뒷번호 4자리를 입력하세요-> ");
			String number = sc.nextLine();
			System.out.println("이름을 입력하세요-> ");
			String name = sc.nextLine();
			
			//고객 찾아오기
			Customer customer = cManager.searchCustomer(number, name);
			
			if(customer != null) {
				//결제하고 잔액 출력
				cManager.payment(customer, total);
			} else {
				System.out.println("회원정보가 없습니다.");
			}
			
		
		//고객이 아닐때
		} else if(yn.equals("n")) {
			System.out.print("회원 등록 하시겠습니까?(y/n)-> ");
			String yesno = sc.nextLine();
			
			//회원 등록
			if(yesno.equals("y")) {
				Customer customer = cManager.AddCustomer();
				cManager.payment(customer, total);
				
			//회원 등록 하지않고 결제
			} else {
				cManager.payment();
			}
		}
		
		//customerDB 덮어쓰기
		cManager.writeCustomerDB();
		
		//종료
		menuView.showEnd();
		
		sc.close();
	}
}
