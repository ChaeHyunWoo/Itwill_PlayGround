package com.util.sqlMap;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapConfig {
	
	//XML�� �ؽ�Ʈ�̱⶧���� ��ü�� �ٲ�߸� ����� �� �ִ�.
	//���⼭ xml�� ��üȭ �ϴ� �۾��� �Ѵ�.
	
	//final ������ �ʱ�ȭ�� ������ ����
	private static final SqlMapClient sqlMap; //sqlMap�� xml���� �о�� ��ü�� ���� ���̴�.
	
	
	//static�̹Ƿ� �̹� �޸𸮻� �ö� �ִ�.
	static {
		
		try {
			
			//������ �ִ°� �ƴϰ� ���ڸ� �ִ� ���̴�.
			//�ش� ��ġ�� �ִ� xml�� �о sqlMap�� �Ҵ�
			String resource = "com/util/sqlMap/sqlMapConfig.xml";
			
			//���� String���� ã�ư��� �о�� reader�� �ְ�
			//��η� ���� xml�� �о���� �Ѵ�.
			//���� ��üȭx
			Reader reader = Resources.getResourceAsReader(resource);
			
			//���⼭ ��ü �����ؼ� sqlMap�� �ִ´�.(��üȭ�ؼ� sqlMap�� ����)
			// - SqlMapClientBuilder�� ��ü�� ���� sqlMap�� �ִ´�.
			// - ���� sqlMap�� ���� final sqlMap���� ����.
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (Exception e) {
			e.printStackTrace();//���°�� �������� ���
			throw new RuntimeException("sqlMap Error : " + e);
		}
	}
	
	public static SqlMapClient getSqlMapInstance() {
		
		//�� �޼��带 ȣ���ϸ� �޸𸮻� �ö� �ִ� sqlMap�� ��ȯ�ȴ�.
		return sqlMap;
	}
	

}