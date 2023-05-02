package com.day16;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Test11 {

	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos;
			PrintStream ps;
			
			fos = new FileOutputStream("c:\\doc\\out4.txt");
			ps = new PrintStream(fos);
			
			//print 안됌 엔터가 들어가야 데이터가 나감
			ps.println("이순신");
			ps.println("홍길동");
			ps.println("허준");
			
			ps.close();
			fos.close();
															//printstream이랑 fileoutputstream이 같이 있을 때만 true쓸 수 있다.
			fos = new FileOutputStream("c:\\doc\\out4.txt", true);//  true를 쓰면 누적해라
			ps = new PrintStream(fos);
			ps.println("배수지");
			ps.println("유인나");
			ps.println("아이유");
			
			ps.close();
			fos.close();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
