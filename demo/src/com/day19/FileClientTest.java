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
			
			System.out.print("������ ���ϰ�� �� ���ϸ� : "); // d:\\doc\\a.txt
			filePath = scn.next();
			
			//��θ� ã�ư��µ� ������ ������ ������ �����ϱ�
			File f = new File(filePath);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
