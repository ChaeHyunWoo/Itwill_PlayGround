package com.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	private Connection conn;
	
	public MemberDAO(Connection conn) {
		
		this.conn = conn;
	}
	
	
	//회원가입
	public int insertData(MemberDTO dto) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			//이 sql문을 가지고
			sql = "insert into member (userId,userPwd,userName,";
			sql +="userBirth,userTel) values (?,?,?,?,?)";
			
			//여기서 컬럼명이 맞는 검증
			pstmt = conn.prepareStatement(sql);
			
			//완벽한 insert 문
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getUserBirth());
			pstmt.setString(5, dto.getUserTel());
			
			//DB에 가서 실행해라
			result = pstmt.executeUpdate();
			
			//DB사용했으면 닫아준다.
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	
	//데이터 읽어오기(읽기) - 하나의 데이터만 읽으면 된다(로그인할 때)
	public MemberDTO getReadData(String userId) {
		
		MemberDTO dto = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			//userId로 select 해온다.
			sql = "select userId,userPwd,userName,to_char(userBirth,'yyyy-mm-dd') userBirth,";
			sql+= "userTel from member where userId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			//if문 안에들어왔다는 것은 데이터가 있다는 뜻
			if(rs.next()) {
				
				dto = new MemberDTO();
				
				dto.setUserId(rs.getString("userId"));
				dto.setUserPwd(rs.getString("userPwd"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserBirth(rs.getString("userBirth"));
				dto.setUserTel(rs.getString("userTel"));
				
			}
			
			//dto에 데이터를 넣었으니 닫아준다
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}
			
	public int updateData(MemberDTO dto){
			
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
			
		try {
			sql = "update member set userPwd=?,userBirth=?,userTel=? ";
			sql += "where userId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserPwd());
			pstmt.setString(2, dto.getUserBirth());
			pstmt.setString(3, dto.getUserTel());
			pstmt.setString(4, dto.getUserId());
			result = pstmt.executeUpdate();
			pstmt.close();
				
		} catch (Exception e) {
			System.out.println(e.toString());
		}
			
		return result;
}
	

}