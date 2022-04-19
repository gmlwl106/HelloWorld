package com.javaex.heeji;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		System.out.print("숫자> ");
		int num = sc.nextInt();
		
		//피라미드
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i+(i-1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
