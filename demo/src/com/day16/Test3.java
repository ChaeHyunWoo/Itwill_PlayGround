package com.day16;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

// InputStreamReader
// 1byte Stream을 2byte Stream으로 변환해주는 Stream -1바이트문자를 2바이트 텍스트리 바꾸는거
// 브릿지 스트림이라고도 함 - 교량 다리역할

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("문자열 ? ");
		
		//Reader에 담아놓고
		Reader rd = new InputStreamReader(System.in);
		
		//rd의 데이터를 하나 읽으면 rd.read가 정수로 반환해서 data에 넣는다
		while((data = rd.read()) != -1) {
			
			char ch = (char)data;
			System.out.print(ch);
		}

	}

}
