package com.day5;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//jumin : 941228-2056789
		//check : 234567 892345
		
		// 합 = (9*2) + (4*3)+ .... + (8*5)
		// 합 = 11 - 합 % 11
		// 합 = 합%10
		// 합 == 9
		
		Scanner sc = new Scanner(System.in);
		
		String jumin;
		int [] check = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int i, total, su;
		
		System.out.print("주민번호[xxxxxx-xxxxxxx] : " );
		jumin = sc.next();
		
		if(jumin.length() != 14) { // 주민번호가 14자리가 아니면
			System.out.println("입력 오류!!");
			return; // exit(종료) return;이 있으면 return;
		}
		
		total = 0;
		
		//index : 01234567890123
		//jumin : 941228-2056789
		//check : 234567 892345
		
		for(i=0; i<10; i++) {
			
			if(i>=6) {	// 주민번호 뒷자리
				total+=check[i] * Integer.parseInt(jumin.substring(i+1, i+2));
			} else {//주민번호 앞자리(생년월일)
				total+=check[i] * Integer.parseInt(jumin.substring(i, i+1));
			}
		}
		su = 11 - total % 11;
		su = su % 10;
		
		if(su == Integer.parseInt(jumin.substring(13))) {
			System.out.println("정확한 주민번호!");
		} else {
			System.out.println("틀린 주민번호!");
		}
	}
	
	

}


/*
String str = "seoul korea";
// String은 값을 넣게되면 index가 만들어짐(일련번호가 붙음)
// 	   index :01234567890

System.out.println(str); // seoul korea
System.out.println(str.substring(0, 3)); //seo 가 나옴 / index 0부터 3-1까지(s e o)를 읽어옴
System.out.println(str.substring(6, 8)); // ko 가 나옴 / index 6부터 8-1까지 (k o )를 읽어옴

System.out.println(str.substring(6)); // korea 가 나옴 / index 6부터 끝까지를 읽어옴 */