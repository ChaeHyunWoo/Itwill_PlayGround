package com.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.db.DBConn;
//Statement 종류
//Statement, PreparedStatement, CallableStatement (Prepared를 자주씀)

public class Test2 {

	public static void main(String[] args) {
		
		Connection conn = DBConn.getConnection();
		
		//DB연결방법
		//1. DriverManager가 Connection을 생성
		//2. Connection이 Statement를 생성 (sql구문을 실행하는 인터페이스) - statement는 종류가 3가지
		//3. Statement가 쿼리(query)를 실행해준다.
		
		if(conn==null) { //만약에 연결이 안된 경우
			System.out.println("데이터베이스 연결 실패!!");
			System.exit(0);
		}
		
		try {
			//java.sql
			Statement stmt = conn.createStatement(); //Connection이 Statement를 생성한다.
			String sql;
			
			/*
			//insert
			sql = "insert into score (hak,name,kor,eng,mat) "; //줄바꿈할땐 한칸 띄어야함
			//sql+= "values ('111','배수지',50,70,40)";
			sql+= "values ('222','유인나',40,80,70)";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) { //1이면 잘 실행된 것 0이오면 실행이 안된것
				System.out.println("추가 성공!!");
			}
			*/
			
			/*
			//update
			sql = "update score set name='한지민', kor=100, eng=100, mat=100 ";
			sql+= "where hak='111'";
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) { //1이면 잘 실행된 것 0이오면 실행이 안된것
				System.out.println("수정 성공!!");
			}
			*/
			
			/*
			//delete
			sql = "delete score where hak=222"; //학번이 222인 데이터를 지운다
			
			int result = stmt.executeUpdate(sql);
			
			if(result==1) { //1이면 잘 실행된 것 0이오면 실행이 안된것
				System.out.println("삭제 성공!!");
			}
			*/
			
			//select
			ResultSet rs = null;
			
			sql = "select hak,name,kor,eng,mat from score";
			
			rs = stmt.executeQuery(sql); // rs를 보고 쿼리를 인식해줌
			
			String hak,name; // 담을 그릇
			int kor,eng,mat; // 담을 그릇
			
			//데이터는 3개지만 실제로는 데이터의 개수를 모르기때문에 while문을 써야한다.
			
			while(rs.next()) { // 데이터가 있을 때까지 반복해라
				
				hak = rs.getString("hak"); //rs에 있는 데이터 / 괄호 안에는 컬럼명/hak은 string이니 getString
				name = rs.getString(2); //컬럼명 대신 숫자를 씀/ 컬럼명:name
				kor = rs.getInt("kor");
				eng = rs.getInt(4); // 컬럼명 : eng
				mat = rs.getInt("mat");
				
				//가지고 왔으면 출력해
				System.out.printf("%5s %6s %4d %4d %4d\n", hak,name,kor,eng,mat);
				
				
			}
			
			rs.close();   //다 사용한 리소스는 꼭 닫아줘야함
			stmt.close(); //다 사용한 리소스는 꼭 닫아줘야함 / 닫는 순서는 상관 x
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		DBConn.close(); //db는 사용다하면 항상 닫아줘야한다.

	}

}