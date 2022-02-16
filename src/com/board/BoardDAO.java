package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO는 테이블에 데이터를 넣는 클래스이기때문에 table을 만들었으면 dao도 만들 수 있다.
public class BoardDAO {

	// 의존성 주입(객체를 생성함에 동시에 초기화)
	private Connection conn;

	public BoardDAO(Connection conn) {
		this.conn = conn;
	}

	// num의 최대값
	public int getMaxNum() {

		int maxNum = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			// nvl를 써서 null인 값을 0으로 바꿔준다. 0으로 바꿔줘야 연산이 가능(++)
			sql = "select nvl(max(num),0) from board";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				maxNum = rs.getInt(1); // 여긴 컬럼명or숫자를 쓴다.
				// 하지만nvl(max(num)) 는 파생 컬럼이라서 이름을 못쓰기 때문에 1을 써준다.
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return maxNum;

	}

	// 입력(insert) - 넘어오는 데이터는 BoardDTO의 dto
	public int insertData(BoardDTO dto) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into board (num,name,pwd,email,subject,";
			sql += "content,ipAddr,hitCount,created) ";
			sql += "values (?,?,?,?,?,?,?,0,sysdate)";

			pstmt = conn.prepareStatement(sql);

			// values 9개중에 ?는 7개라서 7개만 작성
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getSubject());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getIpAddr());

			result = pstmt.executeUpdate(); // 실행해준다

			pstmt.close();// 닫아준다.

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result; // result로 반환
		// --여기까지가 입력(insert)

	}

	// 전체 데이터 갯수 구하기
	public int getDataCount() {

		int totalCount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select nvl(count(*),0) from board";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				totalCount = rs.getInt(1); // 파생컬럼이니 1을 써서 첫번째 데이터 나와라
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return totalCount;

	}

	// 전체 데이터
	public List<BoardDTO> getLists(int start, int end) {

		List<BoardDTO> lists = new ArrayList<BoardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select * from (";
			sql += "select rownum rnum, data.* from (";
			sql += "select num,name,subject,hitCount,";
			sql += "to_char(created,'YYYY-MM-DD') created ";
			sql += "from board order by num desc) data) ";
			sql += "where rnum>=? and rnum<=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {

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

	// num으로 조회한 한개의 데이터
	public BoardDTO getReadData(int num) {

		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select num,name,pwd,email,subject,content,";
			sql += "ipAddr,hitCount,created ";
			sql += "from board where num=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 데이터가 1개니까 while문 x if문사용

				dto = new BoardDTO();// 위에서 객체생성했으니 이렇게

				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setIpAddr(rs.getString("ipAddr"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setCreated(rs.getString("created"));

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dto;
	}

	// 조회수 증가
	public int updateHitCount(int num) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update board set hitCount=hitCount+1 where num=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	
	
	//수정
	public int updateData(BoardDTO dto) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update board set name=?,pwd=?,email=?,subject=?,";
			sql+= "content=? where num=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getSubject());
			pstmt.setString(5, dto.getContent());
			pstmt.setInt(6, dto.getNum());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	//삭제
	public int deleteData(int num) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "delete board where num=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}

}
