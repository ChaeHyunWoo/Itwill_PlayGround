package com.exe.springdi4;

import org.springframework.stereotype.Component;

//JobService �������̽��� ������ Ŭ����

@Component("jobService")
public class MyJobService implements JobService {

	public void getJob() {
		
		System.out.println("���� �鿣�� �������Դϴ�!");
	}

}
