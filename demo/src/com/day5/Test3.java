package com.day5;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		//jumin : 941228-2056789
		//check : 234567 892345
		
		// �� = (9*2) + (4*3)+ .... + (8*5)
		// �� = 11 - �� % 11
		// �� = ��%10
		// �� == 9
		
		Scanner sc = new Scanner(System.in);
		
		String jumin;
		int [] check = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int i, total, su;
		
		System.out.print("�ֹι�ȣ[xxxxxx-xxxxxxx] : " );
		jumin = sc.next();
		
		if(jumin.length() != 14) { // �ֹι�ȣ�� 14�ڸ��� �ƴϸ�
			System.out.println("�Է� ����!!");
			return; // exit(����) return;�� ������ return;
		}
		
		total = 0;
		
		//index : 01234567890123
		//jumin : 941228-2056789
		//check : 234567 892345
		
		for(i=0; i<10; i++) {
			
			if(i>=6) {	// �ֹι�ȣ ���ڸ�
				total+=check[i] * Integer.parseInt(jumin.substring(i+1, i+2));
			} else {//�ֹι�ȣ ���ڸ�(�������)
				total+=check[i] * Integer.parseInt(jumin.substring(i, i+1));
			}
		}
		su = 11 - total % 11;
		su = su % 10;
		
		if(su == Integer.parseInt(jumin.substring(13))) {
			System.out.println("��Ȯ�� �ֹι�ȣ!");
		} else {
			System.out.println("Ʋ�� �ֹι�ȣ!");
		}
	}
	
	

}


/*
String str = "seoul korea";
// String�� ���� �ְԵǸ� index�� �������(�Ϸù�ȣ�� ����)
// 	   index :01234567890

System.out.println(str); // seoul korea
System.out.println(str.substring(0, 3)); //seo �� ���� / index 0���� 3-1����(s e o)�� �о��
System.out.println(str.substring(6, 8)); // ko �� ���� / index 6���� 8-1���� (k o )�� �о��

System.out.println(str.substring(6)); // korea �� ���� / index 6���� �������� �о�� */