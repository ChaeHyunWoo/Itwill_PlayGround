package com.day4;
//3. 1~3사이의 난수를 발생시켜 가위,바위,보 게임 프로그램 작성
//1:가위, 2:바위, 3:보

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		 System.out.print("(1)가위, (2)바위, (3)보");
	        Scanner sc = new Scanner(System.in);
	        int user = sc.nextInt(); 
	        int com = (int) (Math.random() * 3) + 1;  // 
	        
	        System.out.println("컴퓨터:" + com + "사람:" + user);
	        
	        switch (user-com) {
	            case 2: case -1:   
	                System.out.println("컴퓨터가 이겼습니다.");
	                break;
	            case 1: case -2:
	                System.out.println("당신이 이겼습니다");
	                break;
	            case 0:
	                System.out.println("비겼습니다.");
	                break; 
	        }
	  } 
}