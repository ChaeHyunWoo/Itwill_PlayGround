package com.conn;

import java.sql.Connection;

import com.db.DBConn;

public class Test1 {

	public static void main(String[] args) {
		
		//conn���� DBConn.getConnection();�� �ؽ��ڵ尡 ������
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("�����ͺ��̽� ���� ����!!");
			System.exit(0);
		}
		
		System.out.println("�����ͺ��̽� ���� ����!!");
		DBConn.close(); //DB���� Ȯ�������� close�� �ݴ´�. close�� �޼����.

	}

}
