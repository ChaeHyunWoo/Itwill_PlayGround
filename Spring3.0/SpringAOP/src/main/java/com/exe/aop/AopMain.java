package com.exe.aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		
		
		TargetA ta = (TargetA)context.getBean("targetA");
		//TargetB tb = (TargetB)context.getBean("targetB");
		
		ta.doSomething1();
		ta.doSomething2();
		ta.doAnother1();
		ta.doAnother2();
		/*
		tb.doSomething1("Å×½ºÆ®");
		tb.doSomething2();
		tb.doAnother1();
		tb.doAnother2();
		*/

	}

}
