package com.test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	
	private String userId;
	private String userName;
	private String message;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	//Message는 set이 필요없다.
	
	
	//Struts2는 Struts1과 다르게 메서드에 매개변수가 없다. 1은 안쓰는 매개변수도 있어서
	//무거웠는데 2는 필요할때 Struts2에서 가져와서 쓴다. 스프링에서도 이러는데 경량 컨테이너라 한다.
	//Struts2는 기본이 매개변수가 없다.
	public String execute() throws Exception {
		
		message = userName + "님 방가방가...";
		
		//SUCCESS는 struts2에서 제공하는 변수인데 안에 success가 들어가있다.
		return SUCCESS;//success대신 다른 문자를 써도 된다.
	}
	
	

}
