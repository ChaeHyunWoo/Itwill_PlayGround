package com.day19;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerTest {
	
	class WorkThread extends Thread {
		
		private Socket sc = null;
		
		public WorkThread(Socket sc) {
			
			this.sc = sc;
			
		}
		
		@Override
		public void run() {
			
			try {
				
				
				//직렬화된 데이터가 넘어옴
				ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
				
				System.out.println(sc.getInetAddress().getAddress() + "접속....");
				
				FileOutputStream fos = null;
				Object ob = null;
				
				while((ob = ois.readObject()) != null) {
					
					if(ob instanceof FileInfo) {
						
						FileInfo info = (FileInfo)ob;
						
						if(info.getCode() == 100) { //파일전송시작
							
							String str = new String(info.getData()); // getData를 받아와서 문자화 한다
							
							fos = new FileOutputStream(str); // 파일 생성
							
							System.out.println(str + "파일 전송 시작!!");
							
							
							
							
						} else if(info.getCode() == 110) {//파일전송중
							
							if(fos == null)
								break;
							
							fos.write(info.getData(), 0, info.getSize());
							
							System.out.println(info.getSize() + "bytes 받는중...");
							
							
						} else if(info.getCode() == 200) { // 파일전송끝
							
							if(fos == null)
								break;
							
							String str = new String(info.getData());
							
							fos.close();
							
							System.out.println(str + "파일전송 끝");
							
							break; //파일 전송이 다끝났으니 while문 나오기 위해 break사용
							
						}
					} 
				}
				
				
				

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	public void serverStart() {
		
		try {
			
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("클라이언트 접속 대기중...");
			
			Socket sc = ss.accept();
			
			WorkThread wt = new WorkThread(sc);
			wt.start(); // 서버 끝
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public static void main(String[] args) {
		
		new FileServerTest().serverStart();

	}

}
