package com.day15;

import java.util.Random;
import java.util.Scanner;

class MyThread77 extends Thread {
	
	
	
	@Override
	public void run() {
		
		for(int i=1; i<=15; i++) {
			//�ݺ� ������ �۾� "." 15�����
			System.out.print(".");
			
			try {
				sleep(100); //������� sleep �ʼ� 0.01�ʽ���
			} catch (Exception e) {
			}
			
		}
	}
}

public class SelectMember extends MyThread77 {
	
	
	public static void main(String[] args) throws InterruptedException  {
		
		Scanner sc = new Scanner(System.in);//�Է�
		Random rd = new Random(); //����
		MyThread77 t77 = new MyThread77();
		
		String[] name = {"�����","��  ��","������","������","������",
				"�ڰ���","������","�缼��","��â��","������",
				"������","������","������","�輺��","ä����",
				"������","������","�̳���","���ȯ","���Ѽ�"};
		
		
		
		String [] presenter;	// presenter : ��ǥ��
		
		int num, check; // num:��ǥ�� �ο� �� /
		int su = 0;
		
		do{
			System.out.print("��ǥ�� �ο��� : ");
			num = sc.nextInt();
		}while(num<1 || num>20);
		
		presenter = new String[num];//�迭ũ�� ����
		
		while(su<num) {
			
			check = rd.nextInt(19)+1;
			presenter[su] = name[check];
			
			for(int i=0; i<su; i++) {		
				if(presenter[i].equals(presenter[su])) {
					su--;				
					break;				
				}						
			}
			su++;
			
		}
		System.out.print("�����");
		t77.start();
		
		try {
			t77.join();  //t77���������� ��ٸ���
		} catch (Exception e) {
		}
		
		System.out.println();
		System.out.print("�����մϴ�!!, ��ǥ�� �Դϴ�\n");
		System.out.println("----------------------------------");
		
		int j = 1;
		//for(����� �ڷ��� �Ű����� : �迭��){  }
		for(String i:presenter) {
			
			
			System.out.printf("%d��° ��ǥ�� : %s \n", j, i);
			j++;
			Thread.sleep(100);
		}
	
	}

}