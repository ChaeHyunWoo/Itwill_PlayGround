package com.day16;
//������ ������ �� ����ϴ� Stream ���
import java.io.File;
import java.io.FileOutputStream;

public class Test13 {

	public static void main(String[] args) {
		
		String str = "c:\\doc\\temp\\java1\\itwll.txt";
		
		/*
		//���1
								//c:\\doc\\temp\\java1//
		String path = str.substring(0, str.lastIndexOf("\\"));
		//System.out.println(path);
		
		File f = new File(path);
		if(!f.exists()) { //ã�ư��ôµ� ��ΰ� ������
			f.mkdirs();
		}
		*/
		
		//���2
		File f = new File(str);
		if(!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}
		//////////////////////
		
		
		//����(���κ�)
		try {
			
			FileOutputStream fos = new FileOutputStream(str);
			
			System.out.print("���ڿ� �Է�?");
			
			int data;
			while((data = System.in.read()) != -1) {
				fos.write(data);
				fos.flush();
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
