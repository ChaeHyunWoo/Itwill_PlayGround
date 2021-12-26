package com.day2;

import java.util.*;
public class Test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor;
		
		System.out.println("이름 : ");
		name = sc.next();
		
		System.out.println("국어 : ");
		kor = sc.nextInt();
		
		String pan;
		
		if(kor>=90) {
			pan = "수";
		} else if(kor>=80) {
			pan = "우";
		} else if(kor>=70) {
			pan = "리";
		} else if(kor>=60) {
			pan = "양";
		} else {
			pan = "가";
		}
		
		System.out.println(name + ":" + pan);
		
		sc.close();
	
		
	}

}
