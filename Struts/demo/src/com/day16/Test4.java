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
		System.out.print("���ڿ�?");
		Reader rd = new InputStreamReader(System.in);//in���� �а�(Ű����� ������)
		Writer wr = new OutputStreamWriter(System.out);//out���� ���(����ͷ� ���)
		
		while((data = rd.read()) != -1) {
			
			
			wr.write(data);
			wr.flush();// flush() : ������ ��������. - �����������͸� �����ش�
		}
	}

}