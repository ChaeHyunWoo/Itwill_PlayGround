package com.day17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test4 extends Frame implements ActionListener {
	
	private static final long serialVersionUId = 1L;
	
	private Button btn;
	private TextArea ta;
	private TextField tf;
	
	public Test4() {
		
		tf = new TextField();
		ta = new TextArea();
		btn = new Button("추가");
		
		add(tf, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
		
		
		setTitle("윈도우");
		setSize(300, 300);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Test4();
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		Object ob = evt.getSource();
		
		if(ob instanceof Button || ob instanceof TextField) {
			
			String str = tf.getText();
			
			if(!str.equals("")) { // 공백이면 추가하지마라
				
				ta.append(str + "\r\n");
				
				tf.setText("");
				tf.requestFocus(); // 커서 갖다놔라
				
			}
			
		}
		
		
	}

}
