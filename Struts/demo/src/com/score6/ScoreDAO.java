package com.score6;
import java.sql.CallableStatement;
//앤 프로시저 -프로시저는 회사에서 프로시저로 하면 하고 우리는 statement로 할거다
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

import oracle.jdbc.OracleTypes; //오라클 타입 import

//여기는 DB에 연동해서 query(쿼리)를 실행하는 곳

public class ScoreDAO { // Data Access Object
	
	//입력 - DTO의 데이터를 받을 매개변수 준비
	public int insertData(ScoreDTO dto) {
		
		int result = 0; //result는 DB가 잘 실행되면 1값 안되면 0값을 반환한다.
		
		//DB연결
		Connection conn = DBConn.getConnection();
		
		//프로시저를 호출해서 실행시키는 statement
		CallableStatement cstmt = null;
		String sql;
		
		try {
			
			
			//프로시저 호출 방법 : 중괄호 { }
			sql = "{call insertScore(?,?,?,?,?)}"; 
			
			
			cstmt = conn.prepareCall(sql);
			
			//데이터 넣어주기
			cstmt.setString(1, dto.getHak());//이름이니String / 이름은 첫번째 ? 라서 1 / 어디에있나? getHak에 있다.
			cstmt.setString(2, dto.getName());
			cstmt.setInt(3, dto.getKor());
			cstmt.setInt(4, dto.getEng());
			cstmt.setInt(5, dto.getMat());
			
			//완벽한 sql 실행
			result = cstmt.executeUpdate(); //잘 실행되면 1, 아니면 0을 반환
			
			cstmt.close(); //다썻으면 DB닫아주기
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return result; //result 반환
	}
	
	
	//데이터 수정(update)
	public int updateDate(ScoreDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;//인터페이스도 클래스다. 클래스의 초기값은 null이다.
		
		String sql;
		
		try {
			
			sql = "{call updateScore(?,?,?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, dto.getHak());
			cstmt.setInt(2, dto.getKor());
			cstmt.setInt(3, dto.getEng());
			cstmt.setInt(4, dto.getMat());
			
			
			//실행
			result = cstmt.executeUpdate(); // 0아니면 1 값이 나옴
			
			cstmt.close(); // 닫아주고
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
		
	}
	
	//삭제(delete)
	public int deleteData(String hak) { //삭제할땐 학번만 받으면되니 ScoreDTO대신 String hak
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		
		String sql;
		
		try {
			
			sql = "{call deleteScore(?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, hak); // hak으로 받으니 hak써줌
			
			result = cstmt.executeUpdate();
			
			cstmt.close(); //닫기
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//전체 출력
	//--전체출력은 바꿀것이 많다
	public List<ScoreDTO> getList() {
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			//select한 데이터가 (?) 안으로 들어간다.
			sql = "{call selectAllScore(?)}";
			
			cstmt = conn.prepareCall(sql);
			
			//out 파라미터의 자료형을 설정 (?)는 오라클에서 처리해줘야한다. ?는 데이터타입이 커서 타입
			cstmt.registerOutParameter(1, OracleTypes.CURSOR); //오라클 타입이 안나옴.why? 라이센스 문제때문에
			//그래서 외부라이브러리 등록을 해줘야 한다.
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터의 값을 돌려 받기 - 오라클에서 받으니까 object로받기
			rs = (ResultSet)cstmt.getObject(1); //object로 받았으니 down-casting
			
			while(rs.next()) {
				
				ScoreDTO dto = new ScoreDTO(); //데이터의 갯수만큼 만들어줘야하기때문에 while문 안에 생성
				
				dto.setHak(rs.getString("hak")); //rs에 있는 String형태의 hak을 가져온다.
				dto.setName(rs.getString(2)); // 2 는 name이다. 번호를 써줬음 여기서는 하지만 회사에는 번호는 거의 안쓴다.
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				dto.setRank(rs.getInt("rank"));
				
				lists.add(dto); //위의 데이터들을 lists에 넣어준다.
				
			}
			
			rs.close(); //반복이 끝나면 닫아주고
			cstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //반환값은 DTO가 들어있는 lists를 반환
		
	}
	
	//이름 검색 - 여기 프로시저 수정하기 이름@@@@@@@@@@@@@@@@@@2
	public List<ScoreDTO> getList(String name) { //오버로딩
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			
			sql = "{call selectNameScore(?,?)}"; //여긴 값이 2개 받는값, 집어넣는 값
			
			cstmt = conn.prepareCall(sql);
			
			
			
			//out 파라미터 자료형 설정
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//in 파라미터
			cstmt.setString(2, name);
			
			//프로시저 실행
			cstmt.executeUpdate();
			
			//out 파라미터 값 받기
			rs = (ResultSet)cstmt.getObject(1);
			
			while(rs.next()) {
				
				ScoreDTO dto = new ScoreDTO(); //데이터의 갯수만큼 만들어줘야하기때문에 while문 안에 생성
				
				dto.setHak(rs.getString("hak")); //rs에 있는 String형태의 hak을 가져온다.
				dto.setName(rs.getString(2)); // 2 는 name이다. 번호를 써줬음 여기서는 하지만 회사에는 번호는 거의 안쓴다.
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAve(rs.getInt("ave"));
				
				lists.add(dto); //위의 데이터들을 lists에 넣어준다.
				
			}
			
			rs.close(); //반복이 끝나면 닫아주고
			cstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //반환값은 DTO가 들어있는 lists를 반환

	}
	
	//학번 검색
	//--학번 검색은 있으면 나오고 없으면 안나온다.
		public ScoreDTO getHakList(String hak) {
			
			//여기서도 list가 필요없어서 ScoreDTO한다. 그리고 ScoreDTO는 객체생성할 필요가 없어서 null로
			ScoreDTO dto = null;
			Connection conn = DBConn.getConnection();
			CallableStatement cstmt = null;
			ResultSet rs = null;
			
			String sql;
			
			try {
				
				sql = "{call selectHakScore(?,?)}";
				
				cstmt = conn.prepareCall(sql);
				
				//out 파라미터 자료형 설정
				cstmt.registerOutParameter(1, OracleTypes.CURSOR);
				
				//in 파라미터
				cstmt.setString(2, hak);
				
				//프로시저 실행
				cstmt.executeUpdate();
				
				//out 파라미터 값 받기
				rs = (ResultSet)cstmt.getObject(1);
				
				if(rs.next()) { //rs에 데이터가 있으면 출력해라
					
					dto = new ScoreDTO(); //데이터의 갯수만큼 만들어줘야하기때문에 while문 안에 생성
					
					dto.setHak(rs.getString("hak")); //rs에 있는 String형태의 hak을 가져온다.
					dto.setName(rs.getString(2)); // 2 는 name이다. 번호를 써줬음 여기서는 하지만 회사에는 번호는 거의 안쓴다.
					dto.setKor(rs.getInt("kor"));
					dto.setEng(rs.getInt("eng"));
					dto.setMat(rs.getInt("mat"));
					dto.setTot(rs.getInt("tot"));
					dto.setAve(rs.getInt("ave"));
					
				}
				
				rs.close(); //반복이 끝나면 닫아주고
				cstmt.close();
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return dto; //반환값은 dto

		}
}