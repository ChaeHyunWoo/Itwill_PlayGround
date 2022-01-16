package com.navar;

public class NaverVO extends Exception {
	private String id; 
	private String pwd;
	private String pwd2;
	private String name;
	private String gender;
	private String birth;
	private String email;
	private String tel;
	
	public NaverVO() {
	}
	public NaverVO(String id, String pwd, String pwd2, String name, String gender, String birth, String email,
			String tel) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.tel = tel;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
	    this.id = id;
	
	}
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "아이디 : " + id + " 비밀번호 : " + pwd + " 이름 :" + name +" 성별 :" + gender 
				+" 생일 : "+birth + " 이메일 : " + email + " 전화번호 " + tel;
	}
}
