package com.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

//���� ����
//���� ����? c:\\doc\\test.txt
//��� ����? c:\\doc\\out2.txt
//����Ϸ�
public class Test7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int data; //int�� �� ������ read�� int������ �ޱ⶧��
		String file1, file2;
		
		try {
			
			System.out.print("���� ����?");
			file1 = sc.next();
			System.out.print("��� ����?");
			file2 = sc.next();
			
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			//1����Ʈ �� �о�� 
			while((data = fis.read()) != -1) {
				
				//���⼭ �о���鼭 ����ǰ� �����Ͱ� fos�� ����. fos�� �����Ͱ� ���� ��������µ� �װ� ����
				fos.write(data);//�о��
				fos.flush();//������ ������ �а�
			}
			
			fis.close();
			fos.close(); //�ݾ��ְ�
			System.out.print("���Ϻ���Ϸ�");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}