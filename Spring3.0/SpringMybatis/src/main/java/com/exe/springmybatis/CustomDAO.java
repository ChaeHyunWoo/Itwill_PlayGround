package com.exe.springmybatis;


import java.sql.Connection;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class CustomDAO {
	
	private SqlSessionTemplate sessionTemplate;
	
	//의존성 주입 - 이 메서드가 app-context.xml로 가서 프로퍼티 네임에 set이 빼고 들어감
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) { //메소드로 의존성 주입
		this.sessionTemplate = sessionTemplate;
	}

	Connection conn = null;
	
	public void insertData(CustomDTO dto) {
		
		//commondao dao = commondaoimpl로객체생성했어야했는데 spring 3버전부턴 자체 내장해버림
		sessionTemplate.insert("com.exe.custom.insert", dto); 
		
	}
	
	public void updateData(CustomDTO dto) {
			
		sessionTemplate.update("com.exe.custom.update",dto);
	}
	
	public void deleteData(String id) {
		
		sessionTemplate.delete("com.exe.custom.delete",id);
	}
	
	public List<CustomDTO> getList(){
			
			List<CustomDTO> lists = 
					sessionTemplate.selectList("com.exe.custom.list"); //selectList로 읽어옴
			
			return lists;
	
	}
	
	public CustomDTO getReadData(int id){
			
			CustomDTO dto =
					sessionTemplate.selectOne("com.exe.custom.listOne",id);
			
			return dto;
	}

}
