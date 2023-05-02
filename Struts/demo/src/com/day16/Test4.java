package com.day16;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

//OutputStreamReaderWriter

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("문자열?");
		Reader rd = new InputStreamReader(System.in);//in으로 읽고(키보드로 받은거)
		Writer wr = new OutputStreamWriter(System.out);//out으로 출력(모니터로 출력)
		
		while((data = rd.read()) != -1) {
			
			
			wr.write(data);
			wr.flush();// flush() : 강제로 내보낸다. - 마지막데이터를 보내준다
		}
	}

}