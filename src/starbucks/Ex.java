package starbucks;

import java.util.ArrayList;
import java.util.List;

public class Ex {

	public static void main(String[] args) {
		List<Customer> cList = new ArrayList<Customer>();
		Customer c = new Customer("박희지", "010-4444-4444",4000,1);
		cList.add(c);
		System.out.println(c.getName()+c.getCash());
		System.out.println(cList.get(0).getCash());
		
		c.setCash(200);
		System.out.println(c.getName()+c.getCash());
		System.out.println(cList.get(0).getCash());
		
	}
	
}
