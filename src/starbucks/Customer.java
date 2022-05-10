package starbucks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Customer {

	//필드
	private String name;
	private String phone;
	private int cash;
	private int star;
	private List<Customer> cList;
	
	
	
	
	//생성자
	public Customer() {
	}
	public Customer(String name, String phone, int cash, int star) {
		this.name = name;
		this.phone = phone;
		this.cash = cash;
		this.star = star;
	}
	
	
	//메소드 gs
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	
	//메소드 일반
	public void readCustomerDB() throws IOException {
		InputStream is = new FileInputStream("./customerDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			String readDb = br.readLine();
			
			if(readDb == null) {
				break;
			}
			
			String[] cus = readDb.split(",");
			cList.add(new Customer(cus[0],cus[1],Integer.parseInt(cus[2]),Integer.parseInt(cus[3])));
		}

		br.close();
	}
	
	
	
}
