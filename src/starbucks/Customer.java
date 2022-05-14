package starbucks;

public class Customer {

	//필드
	private String name;
	private String phone;
	private int cash;
	private int star;
	
	
	
	
	
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

	
	
	
}
