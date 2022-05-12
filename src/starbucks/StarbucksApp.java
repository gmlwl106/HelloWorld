package starbucks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StarbucksApp {

	public static void main(String[] args) throws IOException {
		/*
		MenuView menuView = new MenuView();
		MenuManager menuManager = new MenuManager();
		
		
		//타이틀과 메뉴 출력
		menuView.showTitle();
		menuView.showMenu(menuManager.getmList());
		
		int total = menuManager.choiceMenu();
		menuView.showTotal(total);
		*/
		
		
		
		int total = 4500;

		Reader cfr = new FileReader("./customerDB.txt");
		BufferedReader cbr = new BufferedReader(cfr);

		List<Customer> cList = new LinkedList<Customer>();
		
		//Customer 리스트 만들기
		while(true) {
			String line = cbr.readLine();
			
			if(line == null) {
				break;
			}
			
			String[] customer = line.split(",");
			cList.add(new Customer(customer[0], customer[1], Integer.parseInt(customer[2]), Integer.parseInt(customer[3]))); //name, phone, cash, star
		}
		

		Scanner sc = new Scanner(System.in);
		System.out.print("스타벅스 고객이신가요?(y/n)-> ");
		String yn = sc.nextLine();
		
		//고객일때
		if(yn.equals("y")) {
			
			System.out.print("휴대폰 뒷번호 4자리를 입력하세요-> ");
			String number = sc.nextLine();
			System.out.println("이름을 입력하세요-> ");
			String name = sc.nextLine();
			
			Customer customer = null;
			
			for(Customer c : cList) {
				if(c.getPhone().matches(".*"+number) && c.getName().contains(name)) {
					customer = c;
				}				
			}
			
			if(customer != null) {
				if(customer.getCash() >= total) {
					customer.setCash(customer.getCash()-total);
					System.out.println("잔액은 ["+customer.getCash()+"원] 입니다.");
					
					customer.setStar(customer.getStar()+1); //별갯수 추가
				} else if(customer.getCash() < total) {
					System.out.println("잔액이 부족합니다.");
				}
			} else {
				System.out.println("회원정보가 없습니다.");
			}
			
		
			//고객이 아닐때
		} else if(yn.equals("n")) {
			System.out.println("회원 등록 하시겠습니까?-> ");
			String yesno = sc.nextLine();
			
			System.out.println("<회원 등록>");
			System.out.println("이름> ");
			System.out.println("휴대폰번호>");
			System.out.println("충전할 금액>");
			if(yesno.equals("y")) {
				
				
				
				
			} else {
				System.out.println("카드 결제가 완료되었습니다.");
			}
		}
		
		//프로그램이 끝나기 전에 DB 업데이트
		
		
		System.out.println("========================================");
		System.out.println("|       이용해주셔서 감사합니다^^      |");
		System.out.println("========================================");
		
		sc.close();
		cbr.close();
		
		
	
		

	}
}
