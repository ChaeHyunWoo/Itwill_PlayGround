package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {
	
	//��ȯ���� �������� �ְ� � ������ �𸣱� ������ ������ Object
	// ProceedingJoinPoint : �޼��带 ��������ִ� ��
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint jointPoint) {
		
		Object result = null;
		
		try {
			
			System.out.println("�޼��� ���� ��(AroundAdvice)...");
			
			//�޼���� ��ȯ���� ���� �� �ֱ⿡
			result = jointPoint.proceed();
			
			System.out.println("�޼��� ���� ��(AroundAdvice)...");
			
		} catch (Throwable e) { //�ִ� Throwable�� ������� / ȸ�峪��!
			
		}
		
		return result;
	}

}
