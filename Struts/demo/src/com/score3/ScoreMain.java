package com.score3;
//day12에 만든 패키지
import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//인터페이스이름 
		Score ob = new ScoreImpl();
		
		int ch;
		
		while(true) {
			
			do {
				System.out.print("1.입력 2.출력 3.학번검색 4.이름검색 5.종료");
				ch = sc.nextInt();
			} while(ch<1);
			
			switch(ch) {
			case 1:
				ob.input();
				break;
			case 2:
				ob.print();
				break;
			case 3:
				ob.searchHak();
				break;
			case 4:
				ob.searchName();
				break;
			default:
				System.exit(0); // 프로그램 종료
			}
		}
	}

}