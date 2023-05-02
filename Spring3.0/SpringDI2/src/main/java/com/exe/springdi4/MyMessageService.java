package com.exe.springdi4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageService")
@Scope(value = "prototype")  //요구시마다 하나의 새로운 빈을 리턴
public class MyMessageService implements MessageService {

	public String getMessage() {
		
		return "안녕 방가방가!!";
	}

}
