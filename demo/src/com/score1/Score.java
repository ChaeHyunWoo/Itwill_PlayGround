package com.score1;

import java.util.Scanner;

public class Score {
	
	int inwon;	//int������ �ڷ����̶� �����ϸ� ����
	Record [] rec;	// Record ������ �ڷ����̶� �����ϸ� ����.
	//Ŭ������ �⺻ ���� null�̴�.
	Scanner sc = new Scanner(System.in);
	
	
	public void set() {
		
		//Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("�ο� �� : "); // 3
			inwon = sc.nextInt();
		} while(inwon<1 || inwon>10);
		
		rec = new Record[inwon];// �ο��� ��ŭ �迭�� ������.
	}
	
	
	public void input() {
		
		String [] title = {"���� : ", "���� : ", "���� : "};
		
		
		for(int i=0; i<inwon; i++) {
			
			rec [i] = new Record(); // ��ü ����
			
			System.out.print("�̸� : "); //suzi
			rec[i].name = sc.next();
			
			
			for(int j=0; j<3; j++) {
				
				 System.out.print(title[j]);
				 rec[i].score[j] = sc.nextInt();
				 
				/* �Ʒ��ڵ��� �����ϰ��ϸ� ���� �ڵ�
				System.out.print("���� : ");
				rec[i].score[j] = sc.nextInt();
				
				System.out.print("���� : ");
				rec[i].score[j] = sc.nextInt();
				
				System.out.print("���� : ");
				rec[i].score[j] = sc.nextInt();
				*/
				 
				 //����
				 rec[i].tot += rec[i].score[j];
				
				}
				//���
				rec[i].ave = rec[i].tot / 3; //����� ������ �� ���Ǿ�� ���ͼ� for�� �ۿ� �����Ѵ�.	
			
		}
	}
	
	
	//���� ���ϱ�
	private void ranking() {
		
		int i,j; // ��������(���ú���) �� ���� �������� ��밡��
		
		for(i=0; i<inwon; i++) {	//���� 1�� �ʱ�ȭ
			rec[i].rank = 1;
		}
		
		//���� selection sort
		for(i=0; i<inwon-1; i++) {
			for(j=i+1; j<inwon; j++) {
				
				if(rec[i].tot>rec[j].tot) {
					rec[j].rank++;
				} else if(rec[i].tot<rec[j].tot) {
					rec[i].rank++;
				}
			}
		}
	}
	
	
	
	//���
	public void print() {
		
		ranking(); // �޼ҵ� �ȿ��� �ٸ� �޼ҵ� ȣ�Ⱑ�� ( print�޼ҵ�ȿ��� ranking�޼ҵ� ȣ��)
		
		for(int i=0; i<inwon; i++) {
			
			System.out.printf("%6s", rec[i].name);
			
			for(int j=0; j<3; j++) {
				
				System.out.printf("%4d", rec[i].score[j]);
			}
			
			System.out.printf("%5d", rec[i].tot);//����
			System.out.printf("%4d", rec[i].ave);//���
			System.out.printf("%4d\n", rec[i].rank);//����
		}
	}
	
	
}
