package com.day4;
//3. 1~3������ ������ �߻����� ����,����,�� ���� ���α׷� �ۼ�
//1:����, 2:����, 3:��

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		 System.out.print("(1)����, (2)����, (3)��");
	        Scanner sc = new Scanner(System.in);
	        int user = sc.nextInt(); 
	        int com = (int) (Math.random() * 3) + 1;  // 
	        
	        System.out.println("��ǻ��:" + com + "���:" + user);
	        
	        switch (user-com) {
	            case 2: case -1:   
	                System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
	                break;
	            case 1: case -2:
	                System.out.println("����� �̰���ϴ�");
	                break;
	            case 0:
	                System.out.println("�����ϴ�.");
	                break; 
	        }
	  } 
}