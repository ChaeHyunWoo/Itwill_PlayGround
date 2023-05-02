package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //��ü�� IoT���� ���� = <aop:aspect ref="beforeAdvice"> </aop:aspect>
@Component // bean ��ü ���� = <bean id="beforeAdvice" class="com.exe.aop.MyBeforeAdvice"/>
public class MyBeforeAdvice {
	
	//������� �� ������ �޼��� ����
	@Before("execution(public void com..aop.*.*(..))")
	public void beforeMethodCall() {
		
		System.out.println("�޼��� ���� ��(BeforeAdvice)..");

	}

}