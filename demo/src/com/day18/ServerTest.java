package com.day18;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest extends Frame implements ActionListener,Runnable{

	private static final long serialVersionUID = 1L;
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	private ServerSocket ss = null;
	private Socket sc = null;
	
	public ServerTest() {
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
				
		setTitle("채팅서버");
		setSize(300, 400);
		setVisible(true);
		
	}	

	public void serverStart() {
		
		try {
			
			ss = new ServerSocket(7777);
			ta.setText("서버시작!!!");

			sc = ss.accept();//클라이언트와 연결
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}	
	
	public static void main(String[] args) {
		new ServerTest().serverStart();
	}

	@Override
	public void run() {
		//데이터를 받을때 
		
		String str;
		String ip;
		
		try {
			
			if(sc==null)
				return;
			
			InputStream is = sc.getInputStream(); 
			BufferedReader br = new BufferedReader(new 
					InputStreamReader(is));
			
			//clientIP
			ip = sc.getInetAddress().getHostAddress();
			ta.append("\r\n[" + ip + "] 접속!!");
			
			while((str=br.readLine())!=null) {
				ta.append("\r\n" + str);
			}			
			
		} catch (Exception e) {
			ta.append("\r\n 클라이언트 연결 종료...");
			sc = null;
			ss = null;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//데이터를 보낼때
		
		String str = tf.getText();
		
		if(str.trim().equals("")) {
			return;
		}
		
		if(sc==null) {
			return;
		}
		
		try {
					
			//true:flush
			PrintWriter pw = new PrintWriter(sc.getOutputStream(),true); // true는 flush랑 같은 역할을 함
			pw.println("서버]" + str); //클라이언트에 전송
			
			ta.append("\r\n서버]:" + str);
			
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			ta.append("\r\n 클라이언트와 접속이 끊겼습니다...");
			sc = null;
		}
			
		
	}

}