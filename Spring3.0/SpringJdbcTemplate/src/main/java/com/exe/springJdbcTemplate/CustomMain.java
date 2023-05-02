package com.exe.springJdbcTemplate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

//콘솔이라 main클래스 만들어
public class CustomMain {

	public static void main(String[] args) {
		
		//콘솔에서는 이 소스가 필요하다.
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");//app-context.xml객체생성
		
		
		//DB연동할려면 DAO가 필요하다.
		// context에 만들어진 객체가 들어가있음
		
		//customDAO라는 이름으로 만들어진 Bean객체를 가져와서 dao에 넣음
		//이건 Java의 JDBC  
		//CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		//스프링의 JDBC
		CustomDAO2 dao = (CustomDAO2)context.getBean("customDAO2");
		
		CustomDTO dto;
		
		//insert
		
		dto = new CustomDTO();
		
		dto.setId("555"); 
		dto.setName("한효주"); 
		dto.setAge(27);
		 
		dao.insertData(dto);
		System.out.println("insert 완료");
		 
		
		//select(모든 데이터 검색)
		/* List<CustomDTO> lists = dao.getList();
		
		for(CustomDTO dto1 : lists) {
			
			System.out.printf("%s %s %d\n",
					dto1.getId(),dto1.getName(),dto1.getAge());
		}
		
		System.out.println("select 완료.."); */
		
		
		//OneSelect(하나의 데이터 검색)
		/* dto = dao.getReadData("111");
		
		if(dto!=null) {
			System.out.printf("%s %s %d\n", 
					dto.getId(),dto.getName(),dto.getAge());
		}
		
		System.out.println("OneSelect 완료..."); */
		
		
		//update(데이터 수정)
		/*dto = new CustomDTO();
		dto.setId("222");
		dto.setName("정인성");
		dto.setAge(28);
		
		dao.updateData(dto);
		
		System.out.println("update 완료..."); */
		
		
		//delete(데이터 삭제)
		/*dao.deleteData("222");
		
		System.out.println("delete 완료.."); */
		
		

	}

}
