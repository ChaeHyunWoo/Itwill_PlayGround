package com.day16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test9 {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream fis = new FileInputStream("c:\\doc\\test.txt");
													////InputStreamReader:2����Ʈ�� �о(����ȭ) -String���� �޾ƾ���
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			String str;
							//String�̶� null���� ���ڸ� -1����
			while((str = br.readLine())!= null) {
				System.out.println(str);
			}
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}