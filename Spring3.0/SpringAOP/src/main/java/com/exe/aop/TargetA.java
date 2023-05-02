package com.exe.aop;

import org.springframework.stereotype.Component;

@Component("targetA") //targetA라는 이름으로 클래스 객체생성
public class TargetA {
	
	public void doSomething1() {
		System.out.println("TargetA.doSomething1");
	}
	
	public void doSomething2() {
		System.out.println("TargetA.doSomething2");
	}
	
	public void doAnother1() {
		System.out.println("TargetA.doAnother1");
	}
	
	public void doAnother2() {
		System.out.println("TargetA.doAnother2");
	}

}
