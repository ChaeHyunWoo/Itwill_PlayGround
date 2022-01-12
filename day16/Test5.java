package com.day16;

import java.io.FileInputStream;

//매우중요
//파일 읽어오기 - FileInputStream - 1바이트씩 쓰고 1바이트씩 읽기
public class Test5 {

	public static void main(String[] args) {
		
		try {
			
			//파일을 읽어서 fis에 넣었음
			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
			
			int data;
			
			//파일에 몇자가 들어간지 모르니 while문으로
			while((data = fis.read()) != -1) {
				
				
				//이렇게하면 파일이 깨짐
				//System.out.print((char)data);
				
				//이클립스는 기본적으로 인코딩이 ANSI이다.
				System.out.write(data); // 엔터를 기준으로 읽어옴
				System.out.flush(); // 안나온 것들 강제로 빼줌
			}
			
			fis.close();
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
		}

	}

}