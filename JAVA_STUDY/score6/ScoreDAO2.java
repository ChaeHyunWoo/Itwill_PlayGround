package com.score6;
//preparedStatement
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

//여기는 DB에 연동해서 query(쿼리)를 실행하는 곳

public class ScoreDAO2 { // Data Access Object
	
	//입력 - DTO의 데이터를 받을 매개변수 준비
	public int insertData(ScoreDTO dto) {
		
		int result = 0; //result는 DB가 잘 실행되면 1값 안되면 0값을 반환한다.
		
		//DB연결
		Connection conn = DBConn.getConnection();
		
		//DB한테 가서 쿼리를 실행해주는애가 statement인데 우린 prepared를 씀
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			/*
			//이게 Statement 방식이다.복잡하다. 그래서 우린 PreparedStatement방식을 씀 -눈도장만 찍기
			//값은 사용자한테 받아야하니 여기서 잠깐 멈추고Score에가서 만들어준다.
			sql = "insert into score (hak,name,kor,eng,mat) ";
			sql+= "values ('" + dto.getHak() + "','"; // 학번은 DTO에 들어가있다.
			sql+= dto.getName() + ",'";
			sql+= dto.getKor() + ",";
			sql+= dto.getMat() + ",";
			sql+= dto.getEng() + ")";
			*/
			
			//PreparedStatement방식
			sql = "insert into score (hak,name,kor,eng,mat) ";
			sql+= "values (?,?,?,?,?)"; //입력할 데이터가 5개면 ?를 5개 찍어주면 된다.
			
			//statement connection이 만듬
			//pre는 미리 준비해서 미리 sql를 가져가서 검사를 받는다. 그냥 statement는 중간에서 가져가서 검사함
			pstmt = conn.prepareStatement(sql);//데이터가 이상이 없으면 pstmt에 넣는다.
			
			//데이터 넣어주기
			pstmt.setString(1, dto.getHak());//이름이니String / 이름은 첫번째 ? 라서 1 / 어디에있나? getHak에 있다.
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			//완벽한 sql 실행
			result = pstmt.executeUpdate(); //잘 실행되면 1, 아니면 0을 반환
			
			pstmt.close(); //다썻으면 DB닫아주기
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return result; //result 반환
	}
	
	
	//데이터 수정(update)
	public int updateDate(ScoreDTO dto) {
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;//인터페이스도 클래스다. 클래스의 초기값은 null이다.
		
		String sql;
		
		try {
			
			sql = "update score set kor=?,eng=?,mat=? where hak=?"; //데이터를 ?로 표시하는게 preparedstatement이다.
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setString(4, dto.getHak());
			
			//실행
			result = pstmt.executeUpdate(); // 0아니면 1 값이 나옴
			
			pstmt.close(); // 닫아주고
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
		
	}
	
	//삭제(delete)
	public int deleteData(String hak) { //삭제할땐 학번만 받으면되니 ScoreDTO대신 String hak
		
		int result = 0;
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		
		String sql;
		
		try {
			
			sql = "delete score where hak=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hak); // hak으로 받으니 hak써줌
			
			result = pstmt.executeUpdate();
			
			pstmt.close(); //닫기
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//전체 출력
	// - DB에서 select해서 DAO에 넣고 score에 넘겨주고 score에서 데이터를 출력한다.
	public List<ScoreDTO> getList() {
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat, ";
			sql+= "(kor+eng+mat) tot,(kor+eng+mat)/3 ave, ";
			sql+= "rank() over (order by (kor+eng+mat) desc) rank ";
			sql+= "from score";
			
			pstmt = conn.prepareStatement(sql);
			
			// 여긴 ?가 없어서 실행만 하면 된당
			
			//실행된 결과를 rs가 받는다
			rs = pstmt.executeQuery();
			
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
			pstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //반환값은 DTO가 들어있는 lists를 반환
		
	}
	
	//이름 검색
	public List<ScoreDTO> getList(String name) { //오버로딩
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			
			sql = "select hak,name,kor,eng,mat,";
			sql+= "(kor+eng+mat) tot,(kor+eng+mat)/3 ave ";
			sql+= "from score where name like ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name + "%");
			
			// 여긴 ?가 없어서 실행만 하면 된당
			
			//실행된 결과를 rs가 받는다
			rs = pstmt.executeQuery();
			
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
			pstmt.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists; //반환값은 DTO가 들어있는 lists를 반환

	}
	
	//학번 검색
	//--학번 검색은 있으면 나오고 없으면 안나온다.
		public ScoreDTO getHakList(String hak) {
			
			//학번이 기본키라서 데이터(레코드)가 1개라서 list를 쓸 필요가 없다.
			// 여기서는 객체 생성이 필요없는게 데이터가 있으면 객체를 생성해서 담으면 되고,
			//없으면 객체를 생성할 필요가 없어서 null로 선언만 해놓은다.
			ScoreDTO dto = null;
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql;
			
			try {
				
				sql = "select hak,name,kor,eng,mat,";
				sql+= "(kor+eng+mat) tot,(kor+eng+mat)/3 ave ";
				sql+= "from score where hak=?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, hak);
				
				// 여긴 ?가 없어서 실행만 하면 된당
				
				//실행된 결과를 rs가 받는다
				rs = pstmt.executeQuery();
				
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
				pstmt.close();
				
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return dto; //반환값은 dto

		}
}