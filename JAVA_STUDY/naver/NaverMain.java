package com.naver;

import java.util.Scanner;

//score3ó�� List�� ���̹� ȸ������ ����� 3��20��~6�ñ���
//�޴� : ȸ������, ȸ����ü���, ���̵�˻�
//���� : ȸ������ �� ���̵�� 8~15���̳�, ������ ���� ȥ��
public class NaverMain {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		NaverImpl ob = new NaverImpl();
		int ch;
		
		while(true) {
			
			do {
				System.out.println("NAVER ȸ�� ����");
				System.out.println("1.ȸ������ 2.ȸ����ü��� 3.���̵�˻� 4.����");
				System.out.print("���� : ");
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
				System.exit(0); // ���α׷� ����
			}
		}
	}
}