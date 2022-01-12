package com.day16;

import java.io.IOException;
import java.io.OutputStream;

public class Test2 {
	
	public static void main(String [] args) throws IOException {
		
		OutputStream os = System.out; //System.out은 1바이트씩 내보낸다
		
		
		//OutputStream는 아스키값을 배열에 넣어놓고 배열을 한번에 다 내보낸다.
		byte[] b = new byte[3]; // buffer
		
		b[0] = 65;
		b[1] = 97;
		b[2] = 122;
		//저장 시 자동으로 형변환되서 아스키값으로 들어가짐
		
		//3개의 덩어리가 한꺼번에 나감. os가 내보내는거임 os가 닫으면 출력못함
		os.write(b); // OutputStream의 write()메서드를 이용해서 한번만 출력
		System.out.println("나 보임!?");
		
		os.close(); // close를 하면 System.out도 같이 닫힌다.
		System.out.println("나 보이냐??? ");
	}

}