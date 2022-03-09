package com.util.sqlMap;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapConfig {
	
	//XML는 텍스트이기때문에 객체로 바꿔야만 사용할 수 있다.
	//여기서 xml을 객체화 하는 작업을 한다.
	
	//final 변수는 초기화가 없으면 오류
	private static final SqlMapClient sqlMap; //sqlMap에 xml에서 읽어온 객체를 담을 것이다.
	
	
	//static이므로 이미 메모리상에 올라가 있다.
	static {
		
		try {
			
			//파일을 넣는게 아니고 문자를 넣는 것이다.
			//해당 위치에 있는 xml을 읽어서 sqlMap에 할당
			String resource = "com/util/sqlMap/sqlMapConfig.xml";
			
			//위의 String값을 찾아가서 읽어내서 reader에 넣고
			//경로로 들어가서 xml를 읽어오게 한다.
			//아직 객체화x
			Reader reader = Resources.getResourceAsReader(resource);
			
			//여기서 객체 생성해서 sqlMap에 넣는다.(객체화해서 sqlMap에 넣음)
			// - SqlMapClientBuilder가 객체를 만들어서 sqlMap에 넣는다.
			// - 여기 sqlMap이 위의 final sqlMap으로 들어간다.
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (Exception e) {
			e.printStackTrace();//몇번째줄 오류인지 출력
			throw new RuntimeException("sqlMap Error : " + e);
		}
	}
	
	public static SqlMapClient getSqlMapInstance() {
		
		//이 메서드를 호출하면 메모리상에 올라가 있는 sqlMap이 반환된다.
		return sqlMap;
	}
	

}