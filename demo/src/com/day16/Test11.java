package com.day16;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Test11 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos;
			PrintStream ps;
			
			fos = new FileOutputStream("c:\\doc\\out4.txt");
			ps = new PrintStream(fos);
			
			//print �ȉ� ���Ͱ� ���� �����Ͱ� ����
			ps.println("�̼���");
			ps.println("ȫ�浿");
			ps.println("����");
			
			ps.close();
			fos.close();
															//printstream�̶� fileoutputstream�� ���� ���� ���� true�� �� �ִ�.
			fos = new FileOutputStream("c:\\doc\\out4.txt", true);//  true�� ���� �����ض�
			ps = new PrintStream(fos);
			ps.println("�����");
			ps.println("���γ�");
			ps.println("������");
			
			ps.close();
			fos.close();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
