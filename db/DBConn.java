package com.db;
//DB를 연결하기위한 클래스
import java.sql.Connection;
import java.sql.DriverManager;
//DB는 여러 개 연결 가능함.

public class DBConn {
	//이렇게하면 Connection형 dbConn을 반환해준다.
	//dbConn에 파이프라인을 넣을건데 그 파이프라인이 Connection이다.
	private static Connection dbConn; // DB연결자를 담을 수 있는 변수
	
	//메서드
	public static Connection getConnection() { //static을 써서 이미 메모리상에 있어 받기만하면되니 get을 써줘야함
		
		if(dbConn == null) { //연결할때 try-catch는 반드시 써야함. / NULL일 경우 연결되지않은 상태
			
			try {	//type4를 thin으로 표시함 / @뒤에는 자신의ip주소 /오라클 기본포트:1521/내가쓰는오라클버전은 xe
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				//JDBC방식으로 TYPE4형식, 해당 주소를 가진 1521포트의 TestDB로 연결하겠다./ 오라클PORT:1521
				//노트북으로 진행할 때는 서버가 아니므로 IP주소가 아닌 LOCALHOST를 쓴다.
				//동적으로 클래스를 로딩한다. 좀 더 빠른 접근 가능
				String user = "suzi";
				String pwd = "a123"; // 여기까지가 접속 정보 
				
				//다른 클래스의 정보를 읽어올 때 사용
				Class.forName("oracle.jdbc.driver.OracleDriver"); // oracle.jdbc.driver위치의 OracleDriver클래스를 읽어옴
				
				//DriverManager를 통해 내가 지정한 url,user,password로 스트림을 생성해서 dbConn에 담는 것
				dbConn = DriverManager.getConnection(url, user, pwd); //읽어와서 dbConn에 넣는다.
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		return dbConn; //처음부터 여기까지가 DB연결자
	}
	
	
	//DB를 사용하면 끝내는 애가 있어야한다.
	public static void close() {
		
		if(dbConn != null) { // null이 아니면 연결되어 있는 상태
			
			try {
				
				if(!dbConn.isClosed()) { //만약에 dbConn이 닫혀있지 않으면
					dbConn.close(); // 닫아줘라
				}
				
			} catch (Exception e) {

				System.out.println(e.toString());
			}
		} //닫으면 찌꺼기가 반드시 남기 때문에 dbConn=null;을 한다 안하면 아답터 오류가 뜬다.
		
		dbConn=null; //이걸 안하면 두번째 연결부터 오류가 뜬다.
		
		//파이프라인이 연결되어 있는 상태에서 연결을 끊게 되면 스트림 안에 쓰레기값이 남게된다.
		//두번 째 연결 시 쓰레기값으로 인해 adapter 오류 발생
		//그래서 연결 종료 시 항상 초기화를 진행해야 한다.
	}

}