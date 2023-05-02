package com.day16;

import java.io.File;
import java.io.FileFilter;

// 파일탐색기 - FileFilter (디렉토리 구조를 볼 수 있다.)


class MyFileList implements FileFilter {

	
	private File f;
	
	//의존성 주입
	public MyFileList(String filePath) {
		f = new File(filePath);
		
	}
	
	public void result() {
		
		try {
			
			if(!f.exists()) {
				System.out.println("파일이 존재하지 않습니다");
				return;
			}
			
			System.out.println("절대경로 : " + f.getAbsolutePath());
			System.out.println("파일크키 : " + f.length());
			
			String p = System.getProperty("user.dir"); // 사용자의 디렉토리를 보여줘라
			System.out.println("현재 프로젝트 경로 : " + p);
			
			
			
			if(f.isDirectory()) { //디렉토리가 있으면 읽어라 ( 여기선 파일, 폴더)
				
				//파일,  폴더 구조
				File[] lists = f.listFiles(this);
				
				System.out.println("폴더의 내용...");
				
				for(int i=0; i<lists.length; i++) {
					
					System.out.print(lists[i].getName());
					System.out.println("\t" + lists[i].length());
				}
				
			}
			
			System.out.println("각 파티션 이름...");
			File[] root = File.listRoots();
			
			for(int i=0; i<root.length; i++) {
				
				System.out.println(root[i].getParent());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	@Override
	public boolean accept(File pathname) {
		
		return pathname.isFile() || pathname.isDirectory();
	//		파일만 보여줌					폴더만 보여줌
	}
	
}



public class Test14 {

	public static void main(String[] args) {
		
		MyFileList m = new MyFileList("c:\\doc");
		m.result();

	}

}
