package starbucks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	//필드
	private String name;
	private int price;
	private int new_menu;
	List<Menu> menuList;
	
	
	
	
	
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
	public void readMenu() throws IOException {
		InputStream is = new FileInputStream("./star.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		menuList = new ArrayList<Menu>();
		
		while(true) {
			String str = br.readLine();
			
			if(str == null) {
				break;
			}
			
			String[] menu = str.split(",");
			String name = menu[0];
			int price = Integer.parseInt(menu[1]);
			int new_menu = Integer.parseInt(menu[2]);
			
			menuList.add(new Menu(name, price, new_menu));
		}
		br.close();
	}
	
	
	
	
	
	public void showMenu() {
		System.out.println("===========================================================");
		int i = 1;
		for(Menu m : menuList) {
			if(m.getNew_menu() == 0) {
				System.out.println(i+"."+m.getName()+"\t가격: "+m.getPrice());
			} else {
				System.out.println("[new]"+i+"."+m.getName()+"\t가격: "+m.getPrice());
			}
			i++;
		}
		System.out.println("===========================================================");
	}
	
	
	public void order(Menu m) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		while(true) {
			System.out.print("주문할 메뉴를 선택하세요(종료:0)> ");
			int num = sc.nextInt();
			
			if(num == 0) {
				break;
			}
			
			System.out.println("갯수> ");
			int count = sc.nextInt();
			
			total += m.menuList.get(num-1).getPrice()*count;
		}
		
		System.out.println(total);
		sc.close();
	}
	
}
