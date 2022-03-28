package com.exe.springmybatis;

import lombok.Getter;
import lombok.Setter;

//여기에 getter/setter를 추가하고싶으면 
public class CustomDTO {
	
	private @Getter @Setter String id;
	private @Getter @Setter String name;
	private @Getter @Setter int age;
	
	/*
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	*/

}
