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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//다중 인터페이스
public class ClientTest extends Frame implements ActionListener,Runnable{

	private static final long serialVersionUID = 1L;
	
	private TextArea ta = new TextArea();
	private TextField tf = new TextField();
	
	// 클라이언트는 소켓만 필요
	private Socket sc = null;
	private String host = "localhost";//localhost(127.0.0.1)192.168.16.0
	private int port = 7777;
	
	
	// 기본 생성자를 통해 ActionListener의 기본값을 설정
	public ClientTest() {
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		//텍스트입력창에 리스너
		tf.addActionListener(this);
		
		//종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
				
		setTitle("채팅클라이언트");
		setSize(300, 400);
		setVisible(true);
		
	}	

	public void connect() {
		
		try {
			
			sc = new Socket(host, port); //(서버의 ip , 포트)
			
			Thread th = new Thread(this);
			th.start();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}	
	
	// 실행되면 main문을 가장 먼저 찾아간다.
	public static void main(String[] args) {
		new ClientTest().connect();
	}

	@Override
	public void run() {
		//데이터를 받을때 
		
		String str;
				
		try {
			
			if(sc==null)
				return;
			
			InputStream is = sc.getInputStream();
			BufferedReader br = new BufferedReader(new 
					InputStreamReader(is));
						
			while((str=br.readLine())!=null) {
				ta.append("\r\n" + str);
			}			
			
		} catch (Exception e) {
			ta.append("\r\n 서버 연결 종료...");
			sc = null;
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
			PrintWriter pw = new PrintWriter(sc.getOutputStream(),true);
			pw.println("수지]" + str); //클라이언트에 전송
			
			ta.append("\r\n수지]:" + str);
			
			tf.setText("");
			tf.requestFocus();
			
		} catch (Exception e2) {
			ta.append("\r\n 서버와 접속이 끊겼습니다...");
			sc = null;
		}
		
				
	}

}