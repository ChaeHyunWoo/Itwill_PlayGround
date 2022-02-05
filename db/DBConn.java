package com.db;
//DB�� �����ϱ����� Ŭ����
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	//�̷����ϸ� Connection�� dbConn�� ��ȯ���ش�.
	private static Connection dbConn; //dbConn�� ������������ �����ǵ� �� ������������ Connection�̴�.
	
	//�޼���
	public static Connection getConnection() { //static�� �Ἥ �̹� �޸𸮻� �־� �ޱ⸸�ϸ�Ǵ� get�� �������
		
		if(dbConn == null) { //�����Ҷ� try-catch�� �ݵ�� �����.
			
			try {	//type4�� thin���� ǥ���� / @�ڿ��� �ڽ���ip�ּ� /����Ŭ �⺻��Ʈ:1521/�������¿���Ŭ������ xe
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "suzi";
				String pwd = "a123"; // ��������� ���� ���� 
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); // ����Ŭ ����̹��� �о��
				
				dbConn = DriverManager.getConnection(url, user, pwd); //�о�ͼ� dbConn�� �ִ´�.
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		return dbConn; //ó������ ��������� DB������
	}
	
	
	//DB�� ����ϸ� ������ �ְ� �־���Ѵ�.
	public static void close() {
		
		if(dbConn != null) {
			
			try {
				
				if(!dbConn.isClosed()) { //���࿡ dbConn�� �������� ������
					dbConn.close(); // �ݾ����
				}
				
			} catch (Exception e) {

				System.out.println(e.toString());
			}
		} //������ ��Ⱑ �ݵ�� ���� ������ dbConn=null;�� �Ѵ� ���ϸ� �ƴ��� ������ ���.
		
		dbConn=null; //�̰� ���ϸ� �ι�° ������� ������ ���.
	}

}
