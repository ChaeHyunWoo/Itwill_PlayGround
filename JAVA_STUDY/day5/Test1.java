package com.day5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		// 10�� �̳��� �̸��� ������ �Է¹޾� ���� ���ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		String [] name;	//�ο��� ��Ȯ���� ������ �̷��Ը� ���� 
		int [] score;
		int [] rank;
		
		int i, j, inwon;
		int temp1;
		do {
			System.out.print("�ο�[1~10] : ");	//���� �ο����� �ް�
			inwon = sc.nextInt();
		} while(inwon<1 || inwon>10);			// 
		
		//�迭�� �޸� �Ҵ�
		name = new String[inwon];  	// �ο����� �°� ���� ����
		score = new int[inwon];
		rank = new int[inwon];
		
		for(i=0; i<inwon; i++) {
			
			System.out.print((i+1) + "��° �̸� : ");
			name[i] = sc.next();	//�迭 name�� i��°�� �о��.
			
			System.out.print("���� : ");
			score[i] = sc.nextInt();
			
		}
		
		//���� �ʱ�ȭ
		for(i=0; i<inwon; i++) {
			rank[i] = 1;	// rank[i]�� 1�� �ʱ�ȭ
		}
		
		//���� ���
		for(i=0; i<inwon-1; i++) {	//���� ����
			for(j=i; j<inwon; j++) {
				
				if(score[i] > score[j]) {	//������ ������ ����ؼ� �迭 score
					rank[j]++; // score[i]�� �� ũ�� ������ rank[j]�� 1������Ų��.
				} else if(score[i] < score[j]) {
					rank[i]++;
				}
				
				if(rank[i]>rank[j]) {
					
					temp1 = rank[i];		//��ŷ����
					rank[i] = rank[j];
					rank[j] = temp1;
					
					
				}
			}
		}
		
		
		
		for(i=0; i<inwon; i++) {
			System.out.printf("%6s %4d %4d %n", name[i], score[i], rank[i]);
		}
	}

}