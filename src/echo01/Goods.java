package echo01;

public class Goods {

	//필드
	private String name;
	private int price;
	private int count;
	
	
	
	
	//생성자
	public Goods() {
	}
	public Goods(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	//메소드 일반
	public void showGoods() {
		System.out.println("[상품명:"+name+" 가격:"+price+" 갯수:"+count+"]");
	}
	
	
}
