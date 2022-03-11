package com.test1;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private UserDTO dto; // dto를 getter/setter로 만들어서 접근하는 방식을 Domain Object라 한다.
	
	private String message;

	public UserDTO getDto() {
		return dto;
	}

	public void setDto(UserDTO dto) {
		this.dto = dto;
	}

	public String getMessage() {
		return message;
	}
	
	
	public String execute() throws Exception {
		
		message = dto.getUserName() + "님 방가방가..";
		
		//SUCCESS를 써도되지만 사용자 정의라서 이번엔 ok를 쓴다.
		return "ok";
	}
	
}