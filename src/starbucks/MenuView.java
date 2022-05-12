package starbucks;

import java.util.List;

public class MenuView {


	//메소드 일반
	//타이틀 출력
	public void showTitle() {
		System.out.println("========================================");
		System.out.println("|     어서오세요. 스타벅스 입니다^^    |");
		System.out.println("========================================");
	}
	
	//메뉴판 출력
	public void showMenu(List<Menu> mList) {
		
		int i = 1;
		for(Menu m : mList) {
			if(m.getNew_menu() == 0) {
				System.out.println(i+"."+m.getName()+"  가격: "+m.getPrice());
			} else {
				System.out.println("[new]"+i+"."+m.getName()+"  가격: "+m.getPrice());
			}
			i++;
		}
	}
	
	//총금액 출력
	public void showTotal(int total) {
		if(total != 0) {
			System.out.println("총 금액은 [" + total + "]원 입니다."); //total이 0일때 프로그램 종료하게 만들기
		} else {
			System.out.println("메뉴가 선택되지 않았습니다.");
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
	}

}


