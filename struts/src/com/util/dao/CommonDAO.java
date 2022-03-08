package com.util.dao;

import java.util.List;
import java.util.Map;

//ibatis


public interface CommonDAO {
	
	//데이터 추가 - id랑 value 이름은 자율이지만 String, Object는 필수로 써야함
	public void insertData(String id, Object value);
	
	//데이터 수정 -2가지 방법
	public int updateData(String id, Object value);
	public int updateData(String id, Map<String, Object> map);
	
	//데이터 삭제
	// - 데이터를 삭제하는 경우의 수 3 가지
	public int deleteData(String id, Object value);
	public int deleteData(String id, Map<String, Object> map);
	public int deleteAllData(String id); //위의 2가지는 거의안쓰고 여기만 씀
	
	//레코드 가져오기 - 데이터를 주고받을때는 Object
	public Object getReadData(String id); //- 1개의 데이터를 가져온다.(ex최대값,나이 등)
	public Object getReadData(String id, Object value);
	public Object getReadData(String id, Map<String, Object> map);
	
	//하나의 데이터 가져오기
	public int getIntValue(String id);
	public int getIntValue(String id, Object value);
	public int getIntValue(String id, Map<String, Object> map);
	
	//여러 개의 데이터 가져오기
	public List<Object> getListData(String id);
	public List<Object> getListData(String id, Object value);
	public List<Object> getListData(String id, Map<String, Object> map);
	
}
