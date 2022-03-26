package com.day4;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*
2번문제
1~10사이의 난수를 발생시켜 발생시킨 난수를 3번 안에 알아 맞추는 게임
(3번 안에 알아맞추지 못하면 발생된 난수를 출력)
 */
public class Q2 {

	public static void main(String[] args) throws IOException {
		
			Scanner sc = new Scanner(System.in);
			Random rd = new Random();

			int[] num = new int[3];
			int a;
			char ch;

			a = rd.nextInt(10) + 1;	// 1

			while (true) {

				for (int i = 0; i < 3; i++) {

					System.out.printf("정수입력?[%d번째 기회] : ", i + 1);
					num[i] = sc.nextInt();

					if (a == num[i]) {
						System.out.println("맞았어요!");
						break;
					} else {
						System.out.println("틀렸어요!");
					}

				}

				System.out.printf("정답은 %d입니다.", a);

				System.out.println("계속 할래?[Y/y]");
				ch = (char) System.in.read();

				if (ch != 'Y' && ch != 'y') {
					System.out.println("프로그램 종료");
					break;
				}
			}

		}

	}