package com.exe.springdi3;

public class MessageMain {

	public static void main(String[] args) {
		
		// app-context class에 따라 다르게 출력
		MessageService ms = new MessageService();
		ms.messageService();// 콘솔에서 읽은 XML를 통해 ms.sayHello("배수지"); 출력
		
	}

}
