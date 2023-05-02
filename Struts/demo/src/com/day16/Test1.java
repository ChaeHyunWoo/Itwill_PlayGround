package com.day16;

import java.io.IOException;

//Stream
//데이터 입출력 시 모든 데이터를 형태와 관계없이 일련된 흐름으로 전송하는 것 - 파이프라인

//in 
public class Test1 {

	public static void main(String[] args) throws IOException {
		
		int data;
		
		System.out.print("문자 입력 : "); // dfd235
					//System.in,read가 자바에서 제공하는 입력 Stream
		while((data = System.in.read()) != -1) {// 1바이트 문자 1개를 읽어옴
			
			char ch = (char)data;
			System.out.print(ch);
		}
		
	}

}