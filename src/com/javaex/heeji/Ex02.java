package com.javaex.heeji;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		System.out.print("숫자> ");
		int num = sc.nextInt();
		
		//반대계단
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				if((num-j) >= i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
