package com.day17;

import java.awt.Color;
import java.awt.Frame;

//�̺�Ʈ ������ ���α׷� - ���� �� �̺�Ʈ ���� ���α׷��̱� ����
//AWT

public class Test1 extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	public Test1() {
		
		setTitle("�ڹ�������");
		setSize(200,300);
		setBackground(new Color(255,255,49));//RGB
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		
		//�����ڸ� ȣ��
		new Test1();
		
		

	}

}
