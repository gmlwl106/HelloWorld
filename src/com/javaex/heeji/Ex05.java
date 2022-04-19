package com.javaex.heeji;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		System.out.print("숫자> ");
		int num = sc.nextInt();
		
		//역피라미드
		for(int i=num; i>0; i--) {
			
			for(int j=num-i; j>0; j--) {
				System.out.print(" ");
			}
			for(int k=i*2-1; k>0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
