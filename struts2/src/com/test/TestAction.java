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
	//Message�� set�� �ʿ����.
	
	
	//Struts2�� Struts1�� �ٸ��� �޼��忡 �Ű������� ����. 1�� �Ⱦ��� �Ű������� �־
	//���ſ��µ� 2�� �ʿ��Ҷ� Struts2���� �����ͼ� ����. ������������ �̷��µ� �淮 �����̳ʶ� �Ѵ�.
	//Struts2�� �⺻�� �Ű������� ����.
	public String execute() throws Exception {
		
		message = userName + "�� �氡�氡...";
		
		//SUCCESS�� struts2���� �����ϴ� �����ε� �ȿ� success�� ���ִ�.
		return SUCCESS;//success��� �ٸ� ���ڸ� �ᵵ �ȴ�.
	}
	
	

}
