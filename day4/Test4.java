package com.day4;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		// 10�� �̳��� �̸��� ������ �Է¹޾�
		// ������ ����������� ������� ������ ���(���� ��������)
		
		Scanner sc = new Scanner(System.in);
		
		String [] name; //�迭�� ������� ��Ȯ�� �� �� �̷��� �Ѵ�.
		int [] score;  //���⼭ �迭������ϰ� �Ʒ����� �ص������� ������ ������ �������ִ� ���� ���� 
		
		int i, j, people, temp1;// temp1�� ������ �޴´�.(int)
		String temp2;	//temp2�� �̸��� �޴´�.(String)
		
		do {
			System.out.print("�ο� ��[1~10] : "); // 3
			people = sc.nextInt();
		} while(people<1 || people>10);	//1���� �۰ų� 10���� ũ�� �ȵǰԲ�
		
		
	
		//���� �迭�� ����ͼ� ����.
		//�迭 �޸� �Ҵ�(��ü ����)
		name = new String[people];	//���⼭  String [] name = new String[people];
		score = new int[people];	// 		  int [] score = new int[people]; �̷��� ���𰡴� ������ ������ϰ�.
		
		
		for(i=0; i<people; i++) {
			System.out.print("�̸� : "); //suzi
			name[i] = sc.next();
			System.out.print("���� : "); //50
			score[i] = sc.nextInt();
		}
		
		// ���� ����
		for(i=0; i<score.length-1; i++) {
			for(j=i+1; j<score.length; j++) {
				
				if(score[i]<score[j]) {
					
					temp1 = score[i];		//score�ڸ��ٲ�
					score[i] = score[j];
					score[j] = temp1;
					
					temp2 = name[i];		//name �ڸ��ٲ�
					name[i] = name[j];
					name[j] = temp2;
				}
			}
		}
		//2���̻��� �迭�� �����ö��� Ȯ��for���� ���� / �迭 1���϶��� ����
		for(i=0; i<people; i++) {
			System.out.printf("%6s %4d \n", name[i], score[i]);
		}
	}
}