package com.day16;
//파일을 생성할 때 사용하는 Stream 방법
import java.io.File;
import java.io.FileOutputStream;

public class Test13 {

	public static void main(String[] args) {
		
		String str = "c:\\doc\\temp\\java1\\itwll.txt";
		
		/*
		//방법1
								//c:\\doc\\temp\\java1//
		String path = str.substring(0, str.lastIndexOf("\\"));
		//System.out.println(path);
		
		File f = new File(path);
		if(!f.exists()) { //찾아가봤는데 경로가 없으면
			f.mkdirs();
		}
		*/
		
		//방법2
		File f = new File(str);
		if(!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}
		//////////////////////
		
		
		//공통(사용부분)
		try {
			
			FileOutputStream fos = new FileOutputStream(str);
			
			System.out.print("문자열 입력?");
			
			int data;
			while((data = System.in.read()) != -1) {
				fos.write(data);
				fos.flush();
			}
			
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
