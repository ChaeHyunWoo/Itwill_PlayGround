package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

//TimeService 인터페이스를 구현한 클래스

@Component("timeService") //MyTimeService클래스는 timeService라는 이름으로 만들어 
						  //객체생성해서 consumer.java에 가서 넣어줌(자동으로 찾아감)
public class MyTimeService implements TimeService {
	
	public String getTimeString() {
		
		//SimpleDataFormat 날짜 뿌려주는 애
		SimpleDateFormat sdf =
				(SimpleDateFormat)SimpleDateFormat
				.getDateTimeInstance(SimpleDateFormat.LONG,
						SimpleDateFormat.LONG);
		
		String now = sdf.format(new Date());
		
		
		return now;
	}

}
