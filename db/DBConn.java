package com.db;
//DB�� �����ϱ����� Ŭ����
import java.sql.Connection;
import java.sql.DriverManager;
//DB�� ���� �� ���� ������.

public class DBConn {
	//�̷����ϸ� Connection�� dbConn�� ��ȯ���ش�.
	//dbConn�� ������������ �����ǵ� �� ������������ Connection�̴�.
	private static Connection dbConn; // DB�����ڸ� ���� �� �ִ� ����
	
	//�޼���
	public static Connection getConnection() { //static�� �Ἥ �̹� �޸𸮻� �־� �ޱ⸸�ϸ�Ǵ� get�� �������
		
		if(dbConn == null) { //�����Ҷ� try-catch�� �ݵ�� �����. / NULL�� ��� ����������� ����
			
			try {	//type4�� thin���� ǥ���� / @�ڿ��� �ڽ���ip�ּ� /����Ŭ �⺻��Ʈ:1521/�������¿���Ŭ������ xe
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				//JDBC������� TYPE4����, �ش� �ּҸ� ���� 1521��Ʈ�� TestDB�� �����ϰڴ�./ ����ŬPORT:1521
				//��Ʈ������ ������ ���� ������ �ƴϹǷ� IP�ּҰ� �ƴ� LOCALHOST�� ����.
				//�������� Ŭ������ �ε��Ѵ�. �� �� ���� ���� ����
				String user = "suzi";
				String pwd = "a123"; // ��������� ���� ���� 
				
				//�ٸ� Ŭ������ ������ �о�� �� ���
				Class.forName("oracle.jdbc.driver.OracleDriver"); // oracle.jdbc.driver��ġ�� OracleDriverŬ������ �о��
				
				//DriverManager�� ���� ���� ������ url,user,password�� ��Ʈ���� �����ؼ� dbConn�� ��� ��
				dbConn = DriverManager.getConnection(url, user, pwd); //�о�ͼ� dbConn�� �ִ´�.
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		return dbConn; //ó������ ��������� DB������
	}
	
	
	//DB�� ����ϸ� ������ �ְ� �־���Ѵ�.
	public static void close() {
		
		if(dbConn != null) { // null�� �ƴϸ� ����Ǿ� �ִ� ����
			
			try {
				
				if(!dbConn.isClosed()) { //���࿡ dbConn�� �������� ������
					dbConn.close(); // �ݾ����
				}
				
			} catch (Exception e) {

				System.out.println(e.toString());
			}
		} //������ ��Ⱑ �ݵ�� ���� ������ dbConn=null;�� �Ѵ� ���ϸ� �ƴ��� ������ ���.
		
		dbConn=null; //�̰� ���ϸ� �ι�° ������� ������ ���.
		
		//������������ ����Ǿ� �ִ� ���¿��� ������ ���� �Ǹ� ��Ʈ�� �ȿ� �����Ⱚ�� ���Եȴ�.
		//�ι� ° ���� �� �����Ⱚ���� ���� adapter ���� �߻�
		//�׷��� ���� ���� �� �׻� �ʱ�ȭ�� �����ؾ� �Ѵ�.
	}

}