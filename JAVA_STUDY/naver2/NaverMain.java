package com.navar;

import java.util.Scanner;

public class NaverMain {

	public NaverMain() {}
	public void menu() {
		Naver naver = new NaverImpl();	
		
	try {
		Scanner sc = new Scanner(System.in);
		int choice;	
		while(true) {
			do {
				System.out.print("�޴� : 1.ȸ������ 2.ȸ����ü��� 3.���̵�˻� > ");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					naver.join();
					break;
				case 2:
					naver.print();
					break;
				case 3:
					naver.idfind();
					break;
				}
			} while(!(choice >= 1 && choice <= 3));
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			try {
				naver.join();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
	}
	public static void main(String[] args) {
		new NaverMain().menu();
	}
}
