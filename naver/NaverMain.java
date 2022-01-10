package com.naver;

import java.util.Scanner;

//score3처럼 List로 네이버 회원가입 만들기 3시20분~6시까지
//메뉴 : 회원가입, 회원전체출력, 아이디검색
//조건 : 회원가입 시 아이디는 8~15자이내, 영문자 숫자 혼용
public class NaverMain {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		NaverImpl ob = new NaverImpl();
		int ch;
		
		while(true) {
			
			do {
				System.out.println("NAVER 회원 가입");
				System.out.println("1.회원가입 2.회원전체출력 3.아이디검색 4.종료");
				System.out.print("선택 : ");
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
				ob.searchId();
				break;
			default:
				System.exit(0); // 프로그램 종료
			}
		}
	}
}