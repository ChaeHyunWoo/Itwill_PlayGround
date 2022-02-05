package com.conn;

import java.sql.Connection;

import com.db.DBConn;

public class Test1 {

	public static void main(String[] args) {
		
		//conn에는 DBConn.getConnection();의 해쉬코드가 들어가있음
		Connection conn = DBConn.getConnection();
		
		if(conn==null) {
			System.out.println("데이터베이스 연결 실패!!");
			System.exit(0);
		}
		
		System.out.println("데이터베이스 연결 성공!!");
		DBConn.close(); //DB연결 확인했으니 close로 닫는다. close는 메서드다.

	}

}
