package com.day18;
// 1�� �ټ� ä��
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
			System.out.println("��������...");
			
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
				
				//�ٸ� Ŭ���̾�Ʈ���� ���ӻ���� �˸�
				msg = ip + "]�� �����߽��ϴ�";
				
				for(Socket s : clients) {
					
					if(s==sc) // �� �ϳ� ������ ��(�ڽ�)�ΰ� �� �ڽ��̸� �ǳʶڴ�.(�̹��� �����ϰ� �ٽ� for�����οö�)
						continue;
										
					PrintWriter pw = 
							new PrintWriter(s.getOutputStream(),true);
					pw.println(msg);
					
				}
				
				System.out.println(msg);//������ ����
				
				
				while((msg = br.readLine())!=null) { //������ �о msg�� �ִ´�
					
					for(Socket s : clients) {
						
						if(s==sc)// �� �ϳ� ������ ��(�ڽ�)�ΰ� �� �ڽ��̸� �ǳʶڴ�.(�̹��� �����ϰ� �ٽ� for�����οö�)
							continue;
											
						PrintWriter pw = 
								new PrintWriter(s.getOutputStream(),true);
						pw.println(msg);
						
					}
					System.out.println(msg);					
				}
				
			} catch (Exception e) {
				
				msg = ip + "]�� �����߽��ϴ�.";
				
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
