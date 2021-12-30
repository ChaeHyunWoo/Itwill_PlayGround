package com.day4;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Q2_1 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int input, answer = 0, i;
		
		input = rd.nextInt(9)+1;
		
		while(true) {
			for(i=1; i<=3; i++) {
				System.out.printf("정수입력?[%d번째기회] :", i);
				input = sc.nextInt();
				
				if(input == answer) {
					System.out.println("맞았어요!");
					break;
				} else {
					System.out.println("틀렸어요!");
				}
				}
			System.out.printf("정답은 %d입니다.", input);

			System.out.println("계속 할래?[Y/y]");
			answer = (char) System.in.read();

			if (answer != 'Y' && answer != 'y') {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

}