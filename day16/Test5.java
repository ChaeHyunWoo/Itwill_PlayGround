package com.day16;

import java.io.FileInputStream;

//�ſ��߿�
//���� �о���� - FileInputStream - 1����Ʈ�� ���� 1����Ʈ�� �б�
public class Test5 {

	public static void main(String[] args) {
		
		try {
			
			//������ �о fis�� �־���
			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
			
			int data;
			
			//���Ͽ� ���ڰ� ���� �𸣴� while������
			while((data = fis.read()) != -1) {
				
				
				//�̷����ϸ� ������ ����
				//System.out.print((char)data);
				
				//��Ŭ������ �⺻������ ���ڵ��� ANSI�̴�.
				System.out.write(data); // ���͸� �������� �о��
				System.out.flush(); // �ȳ��� �͵� ������ ����
			}
			
			fis.close();
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
		}

	}

}