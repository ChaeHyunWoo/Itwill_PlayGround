package com.day3;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		// �迭
		int[] num = new int[5]; //int num[] = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ټ����� ���� : "); // 5  7  9  2  3
		
		
		for(int i=0; i<num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		//�ϴ� �迭�� ���� for�� 2�ٷ� �ٲ�
		/*num[0] = sc.nextInt();
		num[1] = sc.nextInt();
		num[2] = sc.nextInt();
		num[3] = sc.nextInt();
		num[4] = sc.nextInt();*/
		
					//i<num.length; �Ʒ��� ����
		for(int i=0; i<=num.length-1; i++) {
			System.out.println("num["+ i +"]:" + num[i]);//System.out.println("num[1]:" + num[i]);
			
		}
		
		System.out.println("�迭 ���� : " + num.length);// �迭�� length�� ()��ȣ�� ����. 
		
		
		num[3] = 100;
		System.out.println("num[3]:" + num[3]); //num[3]�� ���
		
		int a = num[3] - 30; //�迭 3�� ����ִ¼�(100)���� -30�� ��
		System.out.println("a:" + a);
	}
}