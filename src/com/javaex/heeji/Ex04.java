package com.javaex.heeji;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		System.out.print("숫자> ");
		int num = sc.nextInt();
		
		//마름모
		
		//마름모 윗부분
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=(num-i); j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=(2*i-1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//마름모 아랫부분
		for(int i=(num-1); i>0; i--) {
			for(int j=(num-i); j>0; j--) {
				System.out.print(" ");
			}
			for(int j=(2*i-1); j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
