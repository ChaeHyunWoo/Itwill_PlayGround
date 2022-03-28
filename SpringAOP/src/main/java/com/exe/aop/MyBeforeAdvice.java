package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyBeforeAdvice {
	
	@Before("execution(public void com..aop.*.*(..))")
	public void beforeMethodCall() {
		
		//System.out.println("메서드 실행 전(BeforeAdvice)..");
		System.out.println("내가 하고싶은 작업");
	}

}
