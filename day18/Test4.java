package com.day18;

import java.net.InetAddress;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String host;
		
		System.out.print("ȣ��Ʈ[www.naver.com]");
		host = sc.next();
		
		try {
			
			InetAddress ia = InetAddress.getByName(host);
			
			System.out.println("ip�ּ� : " + ia.getHostAddress());
			System.out.println("ȣ��Ʈ : " + ia.getHostName());
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
