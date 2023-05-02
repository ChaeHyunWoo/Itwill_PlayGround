package com.exe.springdi4;

import org.springframework.stereotype.Component;

//JobService 인터페이스를 구현한 클래스

@Component("jobService")
public class MyJobService implements JobService {

	public void getJob() {
		
		System.out.println("나는 백엔드 개발자입니다!");
	}

}
