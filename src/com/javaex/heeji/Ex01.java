package com.javaex.heeji;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		System.out.print("숫자> ");
		int num = sc.nextInt();
		
		//역계단
		for(int i=0; i<num; i++) {
			for(int j=0; j<(num-i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
