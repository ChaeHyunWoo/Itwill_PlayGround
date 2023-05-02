package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//이 클래스는 Table에 대한 정보를 알고 있어야함 / DB의 위치 정보를 갖고 있어야함
//ScoreDAO가 객체생성을 할 때 DB의 위치 정보를 갖고있어야함.

public class ScoreDAO {
	
	//스프링에서는 의존성 주입 이라 함.
	//conn을 받을 변수 만들어주기 데이터타입은 Connection이다.
	private Connection conn;
	
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
	
	
	//전체 데이터
	public List<ScoreDTO> getLists() {
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat,";
			sql+= "(kor+eng+mat) tot, (kor+eng+mat)/3 ave,";
			sql+= "rank() over (order by (kor+eng+mat) desc) rank ";
			sql+= "from score";
			
			pstmt = conn.prepareStatement(sql);
			
			//실행한 결과는 rs에 받는다
 			rs = pstmt.executeQuery();
 			
 			//데이터가 몇개인지 모르니 while문
 			while(rs.next()) {
 				
 				ScoreDTO dto = new ScoreDTO();
 				
 				dto.setHak(rs.getString("hak"));
 				dto.setName(rs.getString("name"));
 				dto.setKor(rs.getInt("kor"));
 				dto.setEng(rs.getInt("eng"));
 				dto.setMat(rs.getInt("mat"));
 				dto.setTot(rs.getInt("tot"));
 				dto.setAve(rs.getInt("ave"));
 				dto.setRank(rs.getInt("rank"));
 				
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
	public ScoreDTO getReadData(String hak) {
		
		ScoreDTO dto = null; //데이터가 없을수도있으니 객체생성 지금 안하고 null로
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat from score ";
			sql+= "where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hak);
			
			//실행하면 rs로 받는다
			rs = pstmt.executeQuery();
			
			//데이터가 1개나오거나 안나온다 그래서 if 문씀
			if(rs.next()) {
				
				dto = new ScoreDTO();
				
				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
			}
			
			rs.close();
			pstmt.close();
					
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto; 
	}
	
	//수정 - (수정은 입력과 거의 유사하다.)
		public int updateData(ScoreDTO dto) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "update score set kor=?, eng=?, mat=? where hak=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getKor());
				pstmt.setInt(2, dto.getEng());
				pstmt.setInt(3, dto.getMat());
				pstmt.setString(4, dto.getHak());
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result; // 0아니면 1 값을 호출해옴
		}
		
		
		//삭제
		public int deleteData(String hak) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql;
			
			try {
				
				sql = "delete score where hak=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, hak);
				
				result = pstmt.executeUpdate();
				
				pstmt.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return result;
		}
	
	

}
