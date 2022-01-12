package com.day16;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Test10 {

	public static void main(String[] args) {
		
		try {
			
			//PrintStreamÀ¸·Î µ¤¾î¾º¿î´Ù
			FileOutputStream fos = new FileOutputStream("c:\\doc\\out3.txt");
			
			PrintStream ps = new PrintStream(fos);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("¹®ÀÚ¿­ : ");
			
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
