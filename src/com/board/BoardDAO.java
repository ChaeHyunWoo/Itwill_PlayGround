package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO는 테이블에 데이터를 넣는 클래스이기때문에 table을 만들었으면 dao도 만들 수 있다.
public class BoardDAO {
	
	//의존성 주입(객체를 생성함에 동시에 초기화)
	private Connection conn;
	
	public BoardDAO(Connection conn) {
		this.conn = conn;
	}
	
	//num의 최대값
	public int getMaxNum() {
		
		int maxNum = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			//nvl를 써서 null인 값을 0으로 바꿔준다. 0으로 바꿔줘야 연산이 가능(++)
			sql = "select nvl(max(num),0) from board";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxNum = rs.getInt(1); //여긴 컬럼명or숫자를 쓴다.
				//하지만nvl(max(num)) 는 파생 컬럼이라서 이름을 못쓰기 때문에 1을 써준다.
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return maxNum;
		
	}
	
	
	
	//입력(insert) - 넘어오는 데이터는 BoardDTO의 dto
	public int insertData(BoardDTO dto) { 
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into board (num,name,pwd,email,subject,";
			sql+= "content,ipAddr,hitCount,created) ";
			sql+= "values (?,?,?,?,?,?,?,0,sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			
			//values 9개중에 ?는 7개라서 7개만 작성
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getSubject());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getIpAddr());
			
			result = pstmt.executeUpdate(); //실행해준다
			
			pstmt.close();//닫아준다.
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result; //result로 반환
		// --여기까지가 입력(insert)
			
	}
	
	
	//전체 데이터
			public List<BoardDTO> getLists() {
				
				List<BoardDTO> lists = new ArrayList<BoardDTO>();
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String sql;
				
				try {
					
				/*	select * from (
					select rownum rnum, data.* from (
					select num,name,subject from board order by num desc) data)
					where rnum>=1 and rnum<=2;*/
					
					
					
					sql = "select num,name,subject,hitCount,";
					sql+= "to_char(created,'YYYY-MM-DD') created ";
					sql+= "from board order by num desc";
					
					pstmt = conn.prepareStatement(sql);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						
						BoardDTO dto = new BoardDTO();
						
						dto.setNum(rs.getInt("num"));
						dto.setName(rs.getString("name"));
						dto.setSubject(rs.getString("subject"));
						dto.setHitCount(rs.getInt("hitCount"));
						dto.setCreated(rs.getString("created"));
						
						lists.add(dto);
					}
					
					rs.close();
					pstmt.close();
					
					
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				
				return lists;
				
			}

}
