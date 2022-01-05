package com.score2;

import java.util.Scanner;

public class ScoreImpl implements Score {
	
	private int inwon;
	private Record [] rec;
	
	Scanner sc = new Scanner(System.in);
	

	@Override
	public void set() {
		
		do {
			System.out.print("�ο���?");
			inwon = sc.nextInt();
		} while(inwon < 1 || inwon > 10);
		
		rec = new Record[inwon];
		
	}

	@Override
	public void input() {
		
		for(int i=0; i<inwon; i++) {
			
			rec[i] = new Record();
			
			System.out.print("�й�?");
			rec[i].hak = sc.next();
			
			System.out.print("�̸�?");
			rec[i].name = sc.next();
			
			System.out.print("����?");
			rec[i].kor = sc.nextInt();
			
			System.out.print("����?");
			rec[i].eng = sc.nextInt();
			
			System.out.print("����?");
			rec[i].mat = sc.nextInt();
			
			rec[i].tot = rec[i].kor + rec[i].eng + rec[i].mat;
			
			rec[i].ave = rec[i].tot / 3;
		}
	}
	
	private String panjung(int score) {
		
		String pan = "";
		
		switch(score/10) {
		
		case 10:
		case 9: pan = "A";
		break;
		case 8: pan = "B";
		break;
		case 7: pan = "C";
		break;
		case 6: pan = "D";
		break;
		default: pan = "F";
		break;
		}
		
		return pan;
	}

	@Override
	public void print() {
		//---------------------------------------------------------
		//        �й�   �̸�   ����   ����   ����   ����   ���
		// ���� - 111    suzi   80(B)  40(F)  60(D)  ����   ���
		
		for(int i=0; i<inwon; i++) {
			/*
			System.out.printf("%s %6s %4d(%s) %4d(%s) %4d(%s) %4d %4d\n",rec[i].hak,rec[i].name,rec[i].kor
					,panjung(rec[i].kor),rec[i].eng,panjung(rec[i].eng),rec[i].mat,panjung(rec[i].mat)
					,rec[i].tot,rec[i].ave); */  //�Ʒ� �ڵ��� ���ٷ� ��� ����
			
			System.out.printf("%4s %4s %4s %4s %4s %4s %4s\n",
			           "�й�","�̸�","����","����","����","����","���");
			System.out.printf("%6s", rec[i].hak);//�й�
			System.out.printf("%6s", rec[i].name);//�̸�
			System.out.printf("%4d(%s)", rec[i].kor, panjung(rec[i].kor)); // ����(����)
			System.out.printf("%4d(%s)", rec[i].eng, panjung(rec[i].eng));// ����(����)
			System.out.printf("%4d(%s)", rec[i].mat, panjung(rec[i].mat));// ����(����)
			System.out.printf("%4d��", rec[i].tot);//����
			System.out.printf("%4d��", rec[i].ave);//���
			
		}
	}
}