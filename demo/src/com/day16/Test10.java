package com.day16;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Test10 {

	public static void main(String[] args) {
		
		try {
			//PrintStream을 읽어낼 때는 BufferedReader를 꼭 써야함
			//PrintStream으로 덮어씌운다 - 애 자체만으로는 출력할수없어서 FileOutputStream이 꼭 있어야함
			FileOutputStream fos = new FileOutputStream("c:\\doc\\out3.txt");
			
			PrintStream ps = new PrintStream(fos);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("문자열 : ");
			
			String str;
			
			while((str = br.readLine()) != null) {
				ps.println(str);
			}
			
			ps.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
