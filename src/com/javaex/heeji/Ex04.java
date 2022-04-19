package com.javaex.heeji;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		System.out.print("숫자> ");
		int num = sc.nextInt();
		
		//마름모
		for(int i=1; i<=(num+(num-1)); i++) {
			if(i <= num) {
				for(int j=1; j<=(num-i); j++) {
					System.out.print(" ");
				}
				for(int j=1; j<=(i+(i-1)); j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				for(int j=1; j<=(i-num); j++) {
					System.out.print(" ");
				}
				
			}
		}
	}
}
