package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;

//이 클래스는 Table에 대한 정보를 알고 있어야함 / DB의 위치 정보를 갖고 있어야함
//ScoreDAO가 객체생성을 할 때 DB의 위치 정보를 갖고있어야함.

public class ScoreDAO {
	
	//스프링에서는 의존성 주입 이라 함.
	//conn을 받을 변수 만들어주기 데이터타입은 Connection이다.
	private Connection conn;
	
	//매개변수가 있는 생성자
	public ScoreDAO(Connection conn) {
		this.conn = conn;
	}
	
	//입력 - JDBC
	public int inserData(ScoreDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into score(hak,name,kor,eng,mat) ";
			sql += "values (?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getHak());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result; // 0아니면 1 값을 호출해옴
	}
	

}
