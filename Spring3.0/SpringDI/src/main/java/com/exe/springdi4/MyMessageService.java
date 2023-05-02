package com.exe.springdi4;

//MessageService 인터페이스를 구현한 클래스
public class MyMessageService implements MessageService {

	public String getMessage() {
		
		return "안녕 방가방가!!";
	}//end getMessage()
}//end MyMessageService