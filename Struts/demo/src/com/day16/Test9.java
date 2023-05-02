package com.day16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test9 {

	public static void main(String[] args) {
		
		try {
			
			////InputStreamReader:1바이트 문자들을 2바이트로 읽어서(문자화) -String으로 받아야함

			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
			
			
			//메모리상에 저장공간 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			String str;
							//String이라서 null써줌 숫자면 -1쓴다
			while((str = br.readLine())!= null) {
				System.out.println(str);
			}
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}