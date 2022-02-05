package com.db;
//DB를 연결하기위한 클래스
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	//이렇게하면 Connection형 dbConn을 반환해준다.
	private static Connection dbConn; //dbConn에 파이프라인을 넣을건데 그 파이프라인이 Connection이다.
	
	//메서드
	public static Connection getConnection() { //static을 써서 이미 메모리상에 있어 받기만하면되니 get을 써줘야함
		
		if(dbConn == null) { //연결할때 try-catch는 반드시 써야함.
			
			try {	//type4를 thin으로 표시함 / @뒤에는 자신의ip주소 /오라클 기본포트:1521/내가쓰는오라클버전은 xe
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "suzi";
				String pwd = "a123"; // 여기까지가 접속 정보 
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 드라이버를 읽어옴
				
				dbConn = DriverManager.getConnection(url, user, pwd); //읽어와서 dbConn에 넣는다.
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		return dbConn; //처음부터 여기까지가 DB연결자
	}
	
	
	//DB를 사용하면 끝내는 애가 있어야한다.
	public static void close() {
		
		if(dbConn != null) {
			
			try {
				
				if(!dbConn.isClosed()) { //만약에 dbConn이 닫혀있지 않으면
					dbConn.close(); // 닫아줘라
				}
				
			} catch (Exception e) {

				System.out.println(e.toString());
			}
		} //닫으면 찌꺼기가 반드시 남기 때문에 dbConn=null;을 한다 안하면 아답터 오류가 뜬다.
		
		dbConn=null; //이걸 안하면 두번째 연결부터 오류가 뜬다.
	}

}
