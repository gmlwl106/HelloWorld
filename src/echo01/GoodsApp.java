package echo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodsApp {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		List<Goods> gArray = new ArrayList<Goods>();
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("============[상품 관리 시스템]============");
			System.out.println("1. 상품등록");
			System.out.println("2. 상품검색");
			System.out.println("3. 전체상품");
			System.out.println("4. 종료");
			System.out.println("==========================================");
			System.out.print(">");
			
			int num = sc.nextInt();
			
			switch(num) {
			
				case 1: //상품등록
					System.out.println("===============[상품 등록]================");
					sc.nextLine();
					System.out.println("[상품명,가격,갯수]를 입력해주세요. (종료:/q)");
					while(true) {
						String str = sc.nextLine();
						
						if(str.equals("/q")) {
							break;
						} else {
							
							String[] goods = str.split(",");
							String name = goods[0];
							int price = Integer.parseInt(goods[1]);
							int count = Integer.parseInt(goods[2]);
							
							gArray.add(new Goods(name, price, count));				
						}
					}
					break;
					
				case 2: //상품검색
					System.out.println("===============[상품 검색]================");
					sc.nextLine();
					System.out.println("찾고싶은 상품명을 입력하세요> ");
					String name = sc.nextLine();
					
					for(Goods g : gArray) {
						if(g.getName().equals(name)) {
							g.showGoods();
						}
					}
					break;
					
				case 3: //전체상품 출력
					System.out.println("=============[전체 상품 출력]=============");
					for(Goods g : gArray) {
						g.showGoods();
					}
					System.out.println("==========================================");
					break;
					
				case 4:
					System.out.println("시스템을 종료합니다.");
					flag = false;
					break;
				
				default:
					System.out.println("잘못된 입력입니다.");
					break;	
			}
		}
			
		
		sc.close();
		
	}
}
