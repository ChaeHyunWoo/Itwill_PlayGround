package com.day16;

import java.io.FileOutputStream;

//FileOutputStream - ������ ������ �� ����.


public class Test6 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("c:\\doc\\out1.txt");
			
			int data;
			System.out.print("���ڿ� : "); //abcd
			
			while((data = System.in.read()) != -1) {
				
				fos.write(data);
			}
			
			fos.close();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
