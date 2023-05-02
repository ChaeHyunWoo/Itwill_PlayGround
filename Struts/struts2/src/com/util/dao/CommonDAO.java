package com.util.dao;

import java.util.List;
import java.util.Map;

//ibatis


public interface CommonDAO {
	
	//������ �߰� - id�� value �̸��� ���������� String, Object�� �ʼ��� �����
	public void insertData(String id, Object value);
	
	//������ ���� -2���� ���
	public int updateData(String id, Object value);
	public int updateData(String id, Map<String, Object> map);
	
	//������ ����
	// - �����͸� �����ϴ� ����� �� 3 ����
	public int deleteData(String id, Object value);
	public int deleteData(String id, Map<String, Object> map);
	public int deleteAllData(String id); //���� 2������ ���ǾȾ��� ���⸸ ��
	
	//���ڵ� �������� - �����͸� �ְ�������� Object
	public Object getReadData(String id); //- 1���� �����͸� �����´�.(ex�ִ밪,���� ��)
	public Object getReadData(String id, Object value);
	public Object getReadData(String id, Map<String, Object> map);
	
	//�ϳ��� ������ ��������
	public int getIntValue(String id);
	public int getIntValue(String id, Object value);
	public int getIntValue(String id, Map<String, Object> map);
	
	//���� ���� ������ ��������
	public List<Object> getListData(String id);
	public List<Object> getListData(String id, Object value);
	public List<Object> getListData(String id, Map<String, Object> map);
	
}
