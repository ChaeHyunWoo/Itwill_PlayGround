package com.score1_1;

import java.util.Scanner;

import com.score1.Record;

public class ScoreHealth {
	
	int inwon;
	RecordHealth [] rec;
	Scanner sc = new Scanner(System.in);
	
	
	//(1)
	public void check() {	//�ο��� ����
		
		do {
			System.out.print("ȸ�� �� : ");
			inwon = sc.nextInt();
		} while(inwon<1 || inwon>20);	//�ο��� 1~20������ ����
		
		  rec = new RecordHealth[inwon];
	}
	
	
	//(2) ȸ�� ��ü���� 
	public void body() {
		
		String [] list = {"Ű : ", "������ : "};
		
		for(int i=0; i<inwon; i++) {
			
			rec [i] = new RecordHealth(); // ��ü ����
			
			System.out.print("�̸� : "); //hyuenwoo
			rec[i].name = sc.next();
			
			for(int j=0; j<2; j++) {
				
				 System.out.print(list[j]);
				 rec[i].num[j] = sc.nextInt();
				 
				
			}
			
		}
	}
	
	private void bmi() {
		
		int i;
		
		for(i=0; i<inwon; i++) {
			rec[i].bmi = 1;
			rec[i].bmi = rec[i].num[1] / (rec[i].num[0] * rec[i].num[0]/10000);
		}
	}
	
	//bmi�������� �׶��� ��ŷ
	public void ranking() {
		bmi();
		
		int i, j;
		
		for(i=0; i<inwon; i++) {	//���� 1�� �ʱ�ȭ
			rec[i].rank = 1;
		}
		
		//���� selection sort
		for(i=0; i<inwon-1; i++) {
			for(j=i+1; j<inwon; j++) {
				
				if(rec[i].bmi>rec[j].bmi) {
					rec[j].rank++;
				} else if(rec[i].bmi<rec[j].bmi) {
					rec[i].rank--;
				}
			}
		}
	}
	
	
	//���
		public void print() {
			
			bmi();// �޼ҵ� �ȿ��� �ٸ� �޼ҵ� ȣ�Ⱑ�� ( print�޼ҵ�ȿ��� ranking�޼ҵ� ȣ��)
			
			
			for(int i=0; i<inwon; i++) {
				
				System.out.printf("%6s", rec[i].name);
				
				for(int j=0; j<2; j++) {
					
					System.out.printf("%4d", rec[i].num[j]);
				}
				
				System.out.printf("%4d", rec[i].bmi);//bmi
				System.out.printf("%4d\n", rec[i].rank);//����
			}
		}
}

