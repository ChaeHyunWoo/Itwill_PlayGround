package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

//콘솔이라 main클래스 만들어
public class CustomMain {

	public static void main(String[] args) {
		
		//콘솔에서는 이게 필요
		//app-context.xml에서 객체생성한 것을 여기에 의존성 주입
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");//app-context.xml객체생성
		
		
		//customDAO라는 이름으로 만들어진 Bean객체를 가져와서 dao에 넣음
		CustomDAO dao = (CustomDAO)context.getBean("customDAO"); 
		
		
		CustomDTO dto;
		
		//insert
		
		dto = new CustomDTO(); //객체 생성해서 데이터 넣음
		
		dto.setId("241");
		dto.setName("홍길동");
		dto.setAge(26);
		
		dao.insertData(dto);
		
		System.out.println("MyBatis-insert 완료");
		
		
		
		//select				
		/*
		List<CustomDTO> lists = dao.getList();
		
		for(CustomDTO dto1 : lists) { //dto가 위에 쓰여서 중복됨으로 1붙여준거임
			
			System.out.printf("%s %s %d\n",                     
					dto1.getId(),dto1.getName(),dto1.getAge()); //%d 인트값 %s 스트링값
			
		}
		
		System.out.println("select 완료.");
		*/
		
		
		  //OneSelect 
		  /*
		  dto = dao.getReadData(777);
		 
		  if(dto!=null) { System.out.printf("%s %s %d\n",
		  dto.getId(),dto.getName(),dto.getAge());
		  
		  }
		  
		  System.out.println("Oneselect 완료.");
		  */
		  
		//update
		/*
		  dto = new CustomDTO();
		  dto.setId(777);
		  dto.setName("윈터");
		  dto.setAge(24);
		  
		  dao.updateData(dto);
		  
		  System.out.println("update 완료.");
		  */
		
		//delete
		/*
		dao.deleteData(555);
		
		System.out.println("delete 완료");
		*/
	}

}