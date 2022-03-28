package com.exe.aop;

import org.springframework.stereotype.Component;

@Component("targetB")
public class TargetB {
	
	public void doSomething1(String str) {
		System.out.println("TargetB.doSomething1:" + str);
	}
	
	public void doSomething2() {
		System.out.println("TargetB.doSomething2");
	}
	
	public void doAnother1() {
		System.out.println("TargetB.doAnother1");
	}
	
	public void doAnother2() {
		System.out.println("TargetB.doAnother2");
	}

}
