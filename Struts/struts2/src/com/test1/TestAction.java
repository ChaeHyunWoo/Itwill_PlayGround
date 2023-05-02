package com.test1;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private UserDTO dto; // dto�� getter/setter�� ���� �����ϴ� ����� Domain Object�� �Ѵ�.
	
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
		
		message = dto.getUserName() + "�� �氡�氡..";
		
		//SUCCESS�� �ᵵ������ ����� ���Ƕ� �̹��� ok�� ����.
		return "ok";
	}
	
}