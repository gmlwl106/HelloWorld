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

public class CustomerManager {

	List<Customer> cList;
	
	
	
	public CustomerManager() {
		cList = new LinkedList<Customer>();
		readCustomerDB();
	}



	//customerDB 읽어오기
	public void readCustomerDB() {
		try {
			Reader cfr = new FileReader("./customerDB.txt");
			BufferedReader cbr = new BufferedReader(cfr);

			
			
			//Customer 리스트 만들기
			while(true) {
				String line = cbr.readLine();
				
				if(line == null) {
					break;
				}
				
				String[] customer = line.split(",");
				cList.add(new Customer(customer[0], customer[1], Integer.parseInt(customer[2]), Integer.parseInt(customer[3]))); //name, phone, cash, star
			}
			
			cbr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//고객 찾기
	public Customer searchCustomer(String number, String name) {
		Customer customer = null;
		
		for(Customer c : cList) {
			if(c.getPhone().matches(".*"+number) && c.getName().contains(name)) {
				customer = c;
			}				
		}
		
		return customer;
	}
	
	//고객 등록
	public Customer AddCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("<회원 등록>");
		System.out.print("이름> ");
		String name = sc.nextLine();
		System.out.print("휴대폰번호>");
		String phone = sc.nextLine();
		System.out.print("충전할 금액>");
		int cash = sc.nextInt();
		
		//name, phone, cash, star(0으로 초기화)
		Customer customerAdd = new Customer(name, phone, cash, 0);
		cList.add(customerAdd);
		System.out.println("<회원 등록 되었습니다.>");
		
		sc.close();
		return customerAdd;
	}
	
	//일반 결제
	public void payment() {
		System.out.println("카드 결제가 완료되었습니다.");
	}
	//충전 금액으로 결제
	public void payment(Customer customer, int total) {
		if(customer.getCash() >= total) {
			customer.setCash(customer.getCash()-total);
			System.out.println("잔액은 ["+customer.getCash()+"원] 입니다.");
			
			customer.setStar(customer.getStar()+1); //별갯수 추가
		} else if(customer.getCash() < total) {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	//customerDB 덮어쓰기
	public void writeCustomerDB() {
		//프로그램이 끝나기 전에 DB 업데이트
		try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
