package com.day16;
//Test7 �ٸ����
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test7_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String  str;
		int data;

		try {

			System.out.println("���� ����ֳ�?");
			str = sc.next();
			
			sc.nextLine();

			FileInputStream fis = new FileInputStream(str);
	
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out2.txt");
			
			
			while((data=fis.read())!=-1) { 
				fos.write(data);
				fos.flush();
			}


			} catch (Exception e) {
				// TODO: handle exception
			}

			// ���� ����
			// ����ڿ��� �������� ��ġ�� ����ſ���.
			// ����ڰ� ����ٰ� 
		}

	}