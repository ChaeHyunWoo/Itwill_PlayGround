package com.test;

import org.apache.struts.action.ActionForm;

//ActionForm이라는 애가 DTO를 관리한다.
public class TestForm extends ActionForm { //DTO

	private static final long serialVersionUID = 1L; 
	
	private String userId;
	private String userPwd;
	private String userName;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
	
	

}
