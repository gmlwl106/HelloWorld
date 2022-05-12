package starbucks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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
				//결제하고 잔액 출력
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
			System.out.print("회원 등록 하시겠습니까?(y/n)-> ");
			String yesno = sc.nextLine();
			
			if(yesno.equals("y")) {
				System.out.println("<회원 등록>");
				System.out.print("이름> ");
				String addName = sc.nextLine();
				System.out.print("휴대폰번호>");
				String addPhone = sc.nextLine();
				System.out.print("충전할 금액>");
				int addCash = sc.nextInt();
				
				//name, phone, cash, star(0으로 초기화)
				Customer customerAdd = new Customer(addName, addPhone, addCash, 0);
				cList.add(customerAdd);
				System.out.println("<회원 등록 되었습니다.>");
				
				if(customerAdd.getCash() >= total) {
					customerAdd.setCash(customerAdd.getCash()-total);
					System.out.println("잔액은 ["+customerAdd.getCash()+"원] 입니다.");
					
					customerAdd.setStar(customerAdd.getStar()+1); //별갯수 추가
				} else if(customerAdd.getCash() < total) {
					System.out.println("잔액이 부족합니다.");
				}
				
			} else {
				System.out.println("카드 결제가 완료되었습니다.");
			}
		}
		
		//프로그램이 끝나기 전에 DB 업데이트
		Writer cfw = new FileWriter("./customerDB-copy.txt");
		BufferedWriter cbw = new BufferedWriter(cfw);
		
		for(Customer c : cList) {
			if(c == null) {
				break;
			}
			String line = c.getName() + "," + c.getPhone() + "," + c.getCash() + "," + c.getStar();
			cbw.write(line);
			cbw.newLine();
		}
		
		cbw.close();
		
		System.out.println("========================================");
		System.out.println("|       이용해주셔서 감사합니다^^      |");
		System.out.println("========================================");
		
		sc.close();
		cbr.close();
		
		
	
		

	}
}
