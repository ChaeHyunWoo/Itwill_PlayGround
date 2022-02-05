package com.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.db.DBConn;
//Statement ����
//Statement, PreparedStatement, CallableStatement (Prepared�� ���־�)

public class Test2 {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		
		//DB������
		//1. DriverManager�� Connection�� ����
		//2. Connection�� Statement�� ���� (sql������ �����ϴ� �������̽�) - statement�� ������ 3����
		//3. Statement�� ����(query)�� �������ش�.
		
		if(conn==null) { //���࿡ ������ �ȵ� ���
			System.out.println("�����ͺ��̽� ���� ����!!");
			System.exit(0);
		}
		
		try {
			//java.sql
			Statement stmt = conn.createStatement(); //Connection�� Statement�� �����Ѵ�.
			String sql;
			
			/*
			//insert
			sql = "insert into score (hak,name,kor,eng,mat) "; //�ٹٲ��Ҷ� ��ĭ ������
			//sql+= "values ('111','�����',50,70,40)";
			sql+= "values ('222','���γ�',40,80,70)";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) { //1�̸� �� ����� �� 0�̿��� ������ �ȵȰ�
				System.out.println("�߰� ����!!");
			}
			*/
			
			/*
			//update
			sql = "update score set name='������', kor=100, eng=100, mat=100 ";
			sql+= "where hak='111'";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) { //1�̸� �� ����� �� 0�̿��� ������ �ȵȰ�
				System.out.println("���� ����!!");
			}
			*/
			
			/*
			//delete
			sql = "delete score where hak=222"; //�й��� 222�� �����͸� �����
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) { //1�̸� �� ����� �� 0�̿��� ������ �ȵȰ�
				System.out.println("���� ����!!");
			}
			*/
			
			//select
			ResultSet rs = null;
			
			sql = "select hak,name,kor,eng,mat from score";
			
			rs = stmt.executeQuery(sql); // rs�� ���� ������ �ν�����
			
			String hak,name; // ���� �׸�
			int kor,eng,mat; // ���� �׸�
			
			//�����ʹ� 3������ �����δ� �������� ������ �𸣱⶧���� while���� ����Ѵ�.
			
			while(rs.next()) { // �����Ͱ� ���� ������ �ݺ��ض�
				
				hak = rs.getString("hak"); //rs�� �ִ� ������ / ��ȣ �ȿ��� �÷���/hak�� string�̴� getString
				name = rs.getString(2); //�÷��� ��� ���ڸ� ��/ �÷���:name
				kor = rs.getInt("kor");
				eng = rs.getInt(4); // �÷��� : eng
				mat = rs.getInt("mat");
				
				//������ ������ �����
				System.out.printf("%5s %6s %4d %4d %4d\n", hak,name,kor,eng,mat);
				
				
			}
			
			rs.close();   //�� ����� ���ҽ��� �� �ݾ������
			stmt.close(); //�� ����� ���ҽ��� �� �ݾ������ / �ݴ� ������ ��� x
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		DBConn.close(); //db�� �����ϸ� �׻� �ݾ�����Ѵ�.

	}

}