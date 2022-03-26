package com.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

//파일 복사
//원본 파일? c:\\doc\\test.txt
//대상 파일? c:\\doc\\out2.txt
//복사완료
public class Test7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int data; //int로 한 이유는 read가 int형으로 받기때문
		String file1, file2;
		
		try {
			
			System.out.print("원본 파일?");
			file1 = sc.next();
			System.out.print("대상 파일?");
			file2 = sc.next();
			
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			//1바이트 씩 읽어내서 
			while((data = fis.read()) != -1) {
				
				//여기서 읽어오면서 복사되고 데이터가 fos가 들어간다. fos에 데이터가 들어가면 덮어씌어지는데 그게 복사
				fos.write(data);//읽어옴
				fos.flush();//남은거 강제로 읽고
			}
			
			fis.close();
			fos.close(); //닫아주고
			System.out.print("파일복사완료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}