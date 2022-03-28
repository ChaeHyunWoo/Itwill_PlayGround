package com.exe.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterReturnAdvice {
	
	@AfterReturning("execution(public void com..aop.*.*(..))")
	public void afterReturnMethodCall() {
		
		System.out.println("메서드 실행 후(After return)...");
		
	}

}
