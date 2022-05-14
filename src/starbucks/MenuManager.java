package starbucks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManager {

	List<Menu> mList;
	int total_baverage = 0;
	
	//생성자
	public MenuManager() {
		mList = new ArrayList<Menu>();
		readMenuDB();
	}

	//gs
	public List<Menu> getmList() {
		return mList;
	}

	public int getTotal_baverage() {
		return total_baverage;
	}

	//메소드
	//MenuDB 읽어오기
	public void readMenuDB() {
		try {
			Reader mfr = new FileReader("./menuDB.txt");
			BufferedReader mbr = new BufferedReader(mfr);
			
			//Menu 리스트 만들기
			while(true) {
				String line = mbr.readLine();
				
				if(line == null) {
					break;
				}
				
				String[] menu = line.split(",");
				//name, price, new_menu
				mList.add(new Menu(menu[0], Integer.parseInt(menu[1]), Integer.parseInt(menu[2]))); 
			}
			mbr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//메뉴 선택
	public int choiceMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		int total = 0;
		
		while(true) {
			System.out.print("메뉴를 선택하세요(종료:0)-> ");
			int num = sc.nextInt();
			
			if(num == 0) {
				break;
			}
			
			int count = 0;
			while(true) {
				System.out.print("갯수를 입력하세요-> ");
				count = sc.nextInt();
				
				if(count != 0) {
					total_baverage += count;
					break;
				}
			}
			
			try {
				total += mList.get(num-1).getPrice()*count;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("번호를 잘못 입력했습니다.");
			}
			
		}
		return total;
	}
}
