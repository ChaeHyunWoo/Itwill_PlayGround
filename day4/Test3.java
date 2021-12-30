package com.day4;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		// selection sort(��������)
		//int [] num = {50, 42, 37, 26, 5};		// ������ 5���� ������ �����ؼ� �����ϴ¹�
		
		Scanner sc = new Scanner(System.in);	//5���� ���� ��������� �Է¹޴¹�
		
		int i,j,temp;
		int[] num = new int [5];
		
		System.out.print("5���� ���� �Է� : ");
		
		for(i=0; i<num.length; i++) {
			num[i] = sc.nextInt();
		}
	
		System.out.print("Source Data: ");
		for(i=0; i<num.length; i++) {
			System.out.printf("%4d", num[i]);	
		}
		System.out.println();
		System.out.println("----------------------------------");
		
		//-----------------------------------------------------------------------------------
		//Selection Sort
		//���� ���� �⺻ ���� (�ϱ� �ʼ�)!!����for��
		
		for(i=0; i<num.length-1; i++) {
			
			for(j=i+1; j<num.length; j++) {
				//System.out.println(i + ":" + j);
				if(num[i]>num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
				}
			}
			
		}
		//------------------------------------------------------------------
		
		//Ȯ�� for�� @�˻��ؼ� ã�ƺ���
		System.out.print("Sorted Data: ");
		for(int k : num) {					// �迭�� ���� ���� for��
			System.out.printf("%4d", k);	// �迭 for�������� �ڵ����� ���� �����ͼ� �־��ش�
		}
		System.out.println();
	}

}
