package com.day3;

import java.io.IOException;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		//입력한 수까지의 합계를 구하기
		
		Scanner sc = new Scanner(System.in);
		
		int su, sum = 0;
		char ch;
		
		while(true) { //무한루프
			
			do {
				System.out.print("원하는 수 : ");//100
				su = sc.nextInt();
			} while(su<1 || su>5000); //원하는수를 입력하되 while에 조건을 건다
			//조건을 반대로 적어야 while을 빠져나온다.
			
			sum = 0; //한번 연산을 하면 sum값을 초기화 해준다. 초기화를 안하면 값이 누적된다!
			for(int i=1; i<=su; i++) {
				
				sum += i; //sum = sum + i;(sum에 값 누적)
			}
			
			System.out.println("1~" + su + "까지의 합 : " + sum);
			
			System.out.print("계속할래? [Y/N]");// Y,y,N,n
			ch = (char)System.in.read();
			
			if(ch != 'Y' && ch !='y') { //Tip 양쪽이 부정(!=)이 나오면 중간에 ||(or)쓰면 안되고 &&(and)를 써야함.!!!
				System.out.println("프로그램 종료");
				break; //break는 if문, while문, do-while문, for문, switch문 등에 다 사용 가능하다.
			}
		}
	}
}