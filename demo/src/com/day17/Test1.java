package com.day17;

import java.awt.Color;
import java.awt.Frame;

//이벤트 단위의 프로그램 - 웹은 다 이벤트 단위 프로그램이기 때문
//AWT

public class Test1 extends Frame {
	
	private static final long serialVersionUID = 1L;
	
	public Test1() {
		
		setTitle("자바윈도우");
		setSize(200,300);
		setBackground(new Color(255,255,49));//RGB
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		
		//생성자만 호출
		new Test1();
		
		

	}

}
