package com.exe.springdi4;

import java.text.SimpleDateFormat;
import java.util.Date;

//TimeService 인터페이스를 구현한 클래스\

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
