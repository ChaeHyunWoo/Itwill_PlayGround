package com.day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test8 {
	
	public boolean fileCopy(String str1, String str2) {
		
		File f = new File(str1);
		
		if(!f.exists()) { //경로 찾아가봐서 파일이 없으면 실행하지마
			return false;
		}
		
		try {
			
			FileInputStream fis = new FileInputStream(f); //str1
			FileOutputStream fos = new FileOutputStream(str2);
			//여기부터 - 파일을에 있는 내용을 읽어내고 내용을 수정해서 내보낼때 쓰는 코딩 중요!
			int data = 0;
			byte[] buffer = new byte[1024];
			
			while((data = fis.read(buffer, 0, 1024)) != -1) { // buffer에서 0번째부터 1024크기만큼
				fos.write(buffer, 0, data); // buffer에서 0부터 data크기만금 내보내라
			}
			///여기까지
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
		
	}

	public static void main(String[] args) {
		
		Test8 ob = new Test8();
		
		if(ob.fileCopy("c:\\doc\\test.txt", "c:\\doc\\out6.txt")) {
			System.out.println("파일복사 성공!!");
		} else {
			System.out.println("파일복사 실패!!");
		}
			
	}

}