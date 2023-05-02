package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {
	
	//반환값이 있을수도 있고 어떤 형인지 모르기 때문에 무조건 Object
	// ProceedingJoinPoint : 메서드를 실행시켜주는 놈
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint jointPoint) {
		
		Object result = null;
		
		try {
			
			System.out.println("메서드 실행 전(AroundAdvice)...");
			
			//메서드는 반환값이 있을 수 있기에
			result = jointPoint.proceed();
			
			System.out.println("메서드 실행 후(AroundAdvice)...");
			
		} catch (Throwable e) { //애는 Throwable만 써줘야함 / 회장나와!
			
		}
		
		return result;
	}

}
