package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.naver.NaverDTO;

public class NaverDAO {
	
private Connection conn;
	
	public NaverDAO(Connection conn) {
		this.conn = conn;
	}
	
	//입력 - JDBC
	public int inserData(NaverDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into naver(id,pwd,name,birth1,birth2,birth3,gender,email,choice,tel,phone) ";
			sql += "values (?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth1());
			pstmt.setString(5, dto.getBirth2());
			pstmt.setString(6, dto.getBirth3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setString(9, dto.getChoice());
			pstmt.setString(10, dto.getTel());
			pstmt.setString(11, dto.getPhone());
			
			
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result; // 0아니면 1 값을 호출해옴
	}
	
	
	//전체 데이터
	public List<NaverDTO> getLists() {
		
		List<NaverDTO> lists = new ArrayList<NaverDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select id,pwd,name,birth1,birth2,birth3,gender,email,choice,tel,phone ";
			sql+= "from naver";
			
			pstmt = conn.prepareStatement(sql);
			
			//실행한 결과는 rs에 받는다
 			rs = pstmt.executeQuery();
 			
 			//데이터가 몇개인지 모르니 while문
 			while(rs.next()) {
 				
 				NaverDTO dto = new NaverDTO();
 				
 				dto.setId(rs.getString("id"));
 				dto.setPwd(rs.getString("pwd"));
 				dto.setName(rs.getString("name"));
 				dto.setBirth1(rs.getString("birth1"));
 				dto.setBirth2(rs.getString("birth2"));
 				dto.setBirth3(rs.getString("birth3"));
 				dto.setGender(rs.getString("gender"));
 				dto.setEmail(rs.getString("email"));
 				dto.setChoice(rs.getString("choice"));
 				dto.setTel(rs.getString("tel"));
 				dto.setPhone(rs.getString("phone"));
 				
 				lists.add(dto);
 			}
 			
 			pstmt.close();
 			rs.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
		
	}
	
	
	//수정할 데이터 가져오기(학번으로 검색)
	public NaverDTO getReadData(String id) {
		
		NaverDTO dto = null; //데이터가 없을수도있으니 객체생성 지금 안하고 null로
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select id,pwd,name,birth1,birth2,birth3,gender,email,choice,tel,phone from naver ";
			sql+= "where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			//실행하면 rs로 받는다
			rs = pstmt.executeQuery();
			
			//데이터가 1개나오거나 안나온다 그래서 if 문씀
			if(rs.next()) {
				
				dto = new NaverDTO();
				
				dto.setId(rs.getString("id"));
 				dto.setPwd(rs.getString("pwd"));
 				dto.setName(rs.getString("name"));
 				dto.setBirth1(rs.getString("birth1"));
 				dto.setBirth2(rs.getString("birth2"));
 				dto.setBirth3(rs.getString("birth3"));
 				dto.setGender(rs.getString("gender"));
 				dto.setEmail(rs.getString("email"));
 				dto.setChoice(rs.getString("choice"));
 				dto.setTel(rs.getString("tel"));
 				dto.setPhone(rs.getString("phone"));
			}
			
			rs.close();
			pstmt.close();
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto; 
	}
	
	//수정 - (수정은 입력과 거의 유사하다.)
		public int updateData(NaverDTO dto) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "update naver set pwd=?,name=?,birth1=?,birth2=?,birth3=?,gender=?, ";
				sql+= "email=?,choice=?,tel=?,phone=? where id=?";
				
				pstmt = conn.prepareStatement(sql);
				
				
				pstmt.setString(1, dto.getPwd());
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getBirth1());
				pstmt.setString(4, dto.getBirth2());
				pstmt.setString(5, dto.getBirth3());
				pstmt.setString(6, dto.getGender());
				pstmt.setString(7, dto.getEmail());
				pstmt.setString(8, dto.getChoice());
				pstmt.setString(9, dto.getTel());
				pstmt.setString(10, dto.getPhone());
				pstmt.setString(11, dto.getId());
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result; // 0아니면 1 값을 호출해옴
		}
		
		
		//삭제
		public int deleteData(String id) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "delete naver where id=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, id);
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result;
		}
}
