package com.day16;
//Test7 다른방법
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test7_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String  str;
		int data;

		try {

			System.out.println("파일 어디있냐?");
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

			// 파일 복사
			// 사용자에게 원본파일 위치를 물어볼거에요.
			// 사용자가 여기다가 
		}

	}