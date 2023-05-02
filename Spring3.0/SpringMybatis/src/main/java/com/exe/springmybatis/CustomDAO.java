package com.exe.springmybatis;


import java.sql.Connection;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class CustomDAO {
	
	private SqlSessionTemplate sessionTemplate;
	
	//������ ���� - �� �޼��尡 app-context.xml�� ���� ������Ƽ ���ӿ� set�� ���� ��
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) { //�޼ҵ�� ������ ����
		this.sessionTemplate = sessionTemplate;
	}

	Connection conn = null;
	
	public void insertData(CustomDTO dto) {
		
		//commondao dao = commondaoimpl�ΰ�ü�����߾���ߴµ� spring 3�������� ��ü �����ع���
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
					sessionTemplate.selectList("com.exe.custom.list"); //selectList�� �о��
			
			return lists;
	
	}
	
	public CustomDTO getReadData(int id){
			
			CustomDTO dto =
					sessionTemplate.selectOne("com.exe.custom.listOne",id);
			
			return dto;
	}

}
