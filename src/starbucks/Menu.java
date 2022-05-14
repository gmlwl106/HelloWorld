package starbucks;

public class Menu {

	//필드
	private String name;
	private int price;
	private int new_menu;
	
	
	
	
	
	
	//생성자
	public Menu() {
	}
	public Menu(String name, int price, int new_menu) {
		this.name = name;
		this.price = price;
		this.new_menu = new_menu;
	}
	
	
	//메소드 gs
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNew_menu() {
		return new_menu;
	}
	public void setNew_menu(int new_menu) {
		this.new_menu = new_menu;
	}
	
	
	//메소드 일반

	
}
