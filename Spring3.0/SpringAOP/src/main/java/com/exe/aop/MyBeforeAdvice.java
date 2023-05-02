package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //객체를 IoT까지 실행 = <aop:aspect ref="beforeAdvice"> </aop:aspect>
@Component // bean 객체 생성 = <bean id="beforeAdvice" class="com.exe.aop.MyBeforeAdvice"/>
public class MyBeforeAdvice {
	
	//실행시점 및 적용할 메서드 지정
	@Before("execution(public void com..aop.*.*(..))")
	public void beforeMethodCall() {
		
		System.out.println("메서드 실행 전(BeforeAdvice)..");

	}

}