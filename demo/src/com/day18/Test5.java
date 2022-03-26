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
import java.net.URL;
import java.net.URLConnection;

public class Test5 extends Frame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private TextArea ta;
	private TextField tf;
	
	
	public Test5() {
		
		ta = new TextArea();
		add(ta);
		
		tf = new TextField();
		tf.addActionListener(this);
		add(tf,BorderLayout.NORTH);
		
		//종료버튼
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}
		});
		
		setTitle("HTML Viewer");
		setSize(400, 300);
		setVisible(true);
	}

	
	
	public static void main(String[] args) {
		
		new Test5();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			String str;
			URL url = new URL(tf.getText());
			
			ta.setText("");
			
			//위의 url를 찾아가서 openStream연결
			
			//방법1
			//InputStream is = url.openStream(); -> 애는 필요한 곳에 빨대를 꼿는 느낌(꼿으면 물이 들어옴)
			
			//방법2
			//나 갈거야 말해주고 레드카펫 깔아줘 등 (정문으로 들어간다 혹은 고급지게 들어간다는 느낌)
			URLConnection conn = url.openConnection(); //Connection이라는 객체 생성
			InputStream is = conn.getInputStream();
					
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			while((str = br.readLine()) != null) {
				
				if(ta.getText().equals(""))
					ta.setText(str);
				
				else
					ta.setText(ta.getText() + "\n\r" + str);
			}
			is.close();
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		
		
	}

}
