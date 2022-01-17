package com.day19;

import java.io.File;
import java.net.Socket;
import java.util.Scanner;

public class FileClientTest {

	public static void main(String[] args) {
		
		int port = 777;
		String host = "local host";
		Socket sc = null; 
		
		Scanner scn = new Scanner(System.in);
		
		String filePath;
		
		try {
			
			System.out.print("전송할 파일경로 및 파일명 : "); // d:\\doc\\a.txt
			filePath = scn.next();
			
			//경로를 찾아갔는데 파일이 없을수 있으니 검증하기
			File f = new File(filePath);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
