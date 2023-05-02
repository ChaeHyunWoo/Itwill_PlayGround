package com.util.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.util.sqlMap.SqlMapConfig;

//�������̽��� ������ Ŭ����
public class CommonDAOImpl implements CommonDAO {
	
	private SqlMapClient sqlMap;
	
	public CommonDAOImpl() {
		
		//Ŭ���� �޼���� Ŭ����.�޼��� �� ȣ��
		this.sqlMap = SqlMapConfig.getSqlMapInstance();
	}
	
	//CommonDAOImpl�� ����ҷ��� ��ü������ �ؾ� ��
	public static CommonDAO getInstance() {
		//�ڱ��ڽ��� ��ü�� ��ȯ���ش�.
		//��ü�� �������ָ� sqlMap�� ����Ҽ� ����
		return new CommonDAOImpl();
	}

	@Override
	public void insertData(String id, Object value) {
		
		try {
			//insert,update,delete�� �����Ҷ� �ڵ������� Ʈ������� ���۵ȴ�.
			//���⼭�� �������� ��������
			sqlMap.startTransaction();
			
			sqlMap.insert(id, value);
			
			sqlMap.commitTransaction(); //Ŀ���� ����
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally { //finally�� ������ ����ȴ�.
			//try-catch���� ���������. transaction�� ���� ����
			try {	
				sqlMap.endTransaction();//�������� Ʈ������� ��������Ѵ�.���ϸ� rock�� �ɸ�
			} catch (Exception e2) {
				
			}
		}
		
	}

	@Override
	public int updateData(String id, Object value) {
		
		int result = 0;
		
		try {
			
			sqlMap.startTransaction();
			
			result = sqlMap.update(id, value);
			
			sqlMap.commitTransaction();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			//try-catch���� ���������. transaction�� ���� ����
			try {	
				sqlMap.endTransaction();
			} catch (Exception e2) {
				
			}
		}
		
	
		return result;
	}

	@Override
	public int updateData(String id, Map<String, Object> map) {
		
		int result = 0;
		
		try {
			
			sqlMap.startTransaction();
			
			result = sqlMap.update(id, map);
			
			sqlMap.commitTransaction();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			//try-catch���� ���������. transaction�� ���� ����
			try {	
				sqlMap.endTransaction();
			} catch (Exception e2) {
				
			}
		}
		
	
		return result;
	}

	@Override
	public int deleteData(String id, Object value) {
		
		int result = 0;
		
		try {
			
			sqlMap.startTransaction();
			
			result = sqlMap.delete(id, value);
			
			sqlMap.commitTransaction();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			//try-catch���� ���������. transaction�� ���� ����
			try {	
				sqlMap.endTransaction();
			} catch (Exception e2) {
				
			}
		}
		
	
		return result;
	}

	@Override
	public int deleteData(String id, Map<String, Object> map) {
		
		int result = 0;
		
		try {
			
			sqlMap.startTransaction();
			
			result = sqlMap.delete(id, map);
			
			sqlMap.commitTransaction();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			//try-catch���� ���������. transaction�� ���� ����
			try {	
				sqlMap.endTransaction();
			} catch (Exception e2) {
				
			}
		}
		
	
		return result;
	}

	@Override
	public int deleteAllData(String id) {
		
		int result = 0;
		
		try {
			
			sqlMap.startTransaction();
			
			result = sqlMap.delete(id); //�̰� ���� �����ϴ� ���ɾ�
			
			sqlMap.commitTransaction();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			//try-catch���� ���������. transaction�� ���� ����
			try {	
				sqlMap.endTransaction();
			} catch (Exception e2) {
				
			}
		}
		
	
		return result;
	}

	@Override
	public Object getReadData(String id) {
		//�ִ� Ʈ����� ������ �ȵȴ�
		try {
			
			return sqlMap.queryForObject(id);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@Override
	public Object getReadData(String id, Object value) {
		
		try {
			
			return sqlMap.queryForObject(id, value);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@Override
	public Object getReadData(String id, Map<String, Object> map) {
		
		try {
			
			return sqlMap.queryForObject(id, map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}

	@Override
	public int getIntValue(String id) {
		
		try {
			//int������ ����ȯ�ؼ� ��ȯ
			return ((Integer)sqlMap.queryForObject(id)).intValue();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}

	@Override
	public int getIntValue(String id, Object value) {
		
		try {
			//int������ ����ȯ�ؼ� ��ȯ
			return ((Integer)sqlMap.queryForObject(id, value)).intValue();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}

	@Override
	public int getIntValue(String id, Map<String, Object> map) {
		
		try {
			//int������ ����ȯ�ؼ� ��ȯ
			return ((Integer)sqlMap.queryForObject(id, map)).intValue();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id) {
		
		try {
			
			return (List<Object>)sqlMap.queryForList(id);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id, Object value) {

		try {
			
			return (List<Object>)sqlMap.queryForList(id, value);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getListData(String id, Map<String, Object> map) {
		
		try {
			
			return (List<Object>)sqlMap.queryForList(id, map);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
		
	}
	
	

}