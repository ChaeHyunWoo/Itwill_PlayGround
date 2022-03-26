package com.day18;
// 1대 다수 채팅
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTest2 {
	
	private ArrayList<Socket> clients = new ArrayList<>();
	
	public void serverStart() {
		
		try {
			
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("서버시작...");
			
			while(true) {
				
				Socket sc = ss.accept();
				
				WorkThread wt = new WorkThread(sc);
				wt.start();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}	
	
	class WorkThread extends Thread{
		
		private Socket sc;
		
		public WorkThread(Socket sc) {
			this.sc = sc;
		}
		
		@Override
		public void run() {
			
			String ip = null;
			String msg = null;
			
			try {
				
				BufferedReader br = new BufferedReader(new 
						InputStreamReader(sc.getInputStream()));
				
				ip = sc.getInetAddress().getHostAddress();
				
				clients.add(sc);
				
				//다른 클라이언트에게 접속사실을 알림
				msg = ip + "]가 입장했습니다";
				
				for(Socket s : clients) {
					
					if(s==sc) // 그 하나 꺼낸게 나(자신)인가 내 자신이면 건너뛴다.(이번만 생략하고 다시 for문으로올라감)
						continue;
										
					PrintWriter pw = 
							new PrintWriter(s.getOutputStream(),true);
					pw.println(msg);
					
				}
				
				System.out.println(msg);//서버에 보임
				
				
				while((msg = br.readLine())!=null) { //데이터 읽어서 msg에 넣는다
					
					for(Socket s : clients) {
						
						if(s==sc)// 그 하나 꺼낸게 나(자신)인가 내 자신이면 건너뛴다.(이번만 생략하고 다시 for문으로올라감)
							continue;
											
						PrintWriter pw = 
								new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
						
					}
					System.out.println(msg);					
				}
				
			} catch (Exception e) {
				
				msg = ip + "]가 퇴장했습니다.";
				
				try {
					
					for(Socket s : clients) {
						
						if(s==sc)
							continue;
											
						PrintWriter pw = 
								new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
						
					}
					System.out.println(msg);
					sc = null;
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

	public static void main(String[] args) {
		
		new ServerTest2().serverStart();
	}

}
