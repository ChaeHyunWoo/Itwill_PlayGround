package com.day17;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test2 extends Frame implements WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	public Test2() {
		
		setTitle("자바윈도우");
		setSize(300, 300);
		
		//이게 감시카메라다.
		addWindowListener(this); // this 를 써서 나한테 달아라
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Test2();

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		//addWindowListener(this);위에 이걸 써줘야 종료가 된다. why? 사용자가 뭘할지 모르기때문에
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
