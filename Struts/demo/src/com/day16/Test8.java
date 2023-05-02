package com.day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test8 {
	
	public boolean fileCopy(String str1, String str2) {
		
		//FileŬ������ ������ �����ϳ� ������ �Ұ���
		File f = new File(str1);
		
		//if���� ��κ� ��������
		if(!f.exists()) { //��� ã�ư����� ������ ������ ����������
			return false;
		}
		
		try {
			//������ ���� �� ����ϴ� �ڵ� 
			FileInputStream fis = new FileInputStream(f); //str1
			FileOutputStream fos = new FileOutputStream(str2);
			//������� - �������� �ִ� ������ �о�� ������ �����ؼ� �������� ���� �ڵ� �߿�!
			int data = 0;
			byte[] buffer = new byte[1024];
			
			while((data = fis.read(buffer, 0, 1024)) != -1) { // buffer���� 0��°���� 1024ũ����� ����.
				fos.write(buffer, 0, data); // buffer���� 0���� dataũ�⸸ŭ ��������
			}
			///�������-----------------------------------------
			fis.close(); //close�� ���� ������ ����� �� �����Ⱚ�� ����ϱ� �ݾ��ش�.
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
		
	}

	public static void main(String[] args) {
		
		Test8 ob = new Test8();
		
		if(ob.fileCopy("c:\\doc\\out2.txt", "c:\\doc\\out5.txt")) {
			System.out.println("���Ϻ��� ����!!");
		} else {
			System.out.println("���Ϻ��� ����!!");
		}
			
	}

}