package com.day17;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test2 extends Frame implements WindowListener {
	
	private static final long serialVersionUID = 1L;
	
	public Test2() {
		
		setTitle("�ڹ�������");
		setSize(300, 300);
		
		//�̰� ����ī�޶��.
		addWindowListener(this); // this �� �Ἥ ������ �޾ƶ�
		
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
		//addWindowListener(this);���� �̰� ����� ���ᰡ �ȴ�. why? ����ڰ� ������ �𸣱⶧����
		
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
