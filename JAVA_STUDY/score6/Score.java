package com.score6;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// 여기에는 사용자한테 데이터를 받는 곳
//영어점수 내놔, 데이터 수정하고 싶어(삭제,변경 등)
public class Score {
	
	Scanner sc = new Scanner(System.in);
	
	ScoreDAO dao = new ScoreDAO(); //객체 생성
	
	
	//입력
	public void insert() {
		
		
		
		try {
			
			ScoreDTO dto = new ScoreDTO(); 
			
			//사용자한테 학번 받아서 DTO에 보낸다. DTO가 데이터를 받아서 DAO한테 보낸다.
			System.out.print("학번?"); //111
			dto.setHak(sc.next());
			
			System.out.print("이름?");//suzi
			dto.setName(sc.next()); // dto의 setName
			
			System.out.print("국어?");//50
			dto.setKor(sc.nextInt());
			
			System.out.print("영어?");//70
			dto.setEng(sc.nextInt());
			
			System.out.print("수학?");//60
			dto.setMat(sc.nextInt());
			
			
			int result = dao.insertData(dto);
			
			if(result !=0)
				System.out.println("추가 성공!!");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	//수정
	public void update() { //반환값이 없으니 void
		
		ScoreDTO dto = new ScoreDTO(); //객체 생성
		
		try {
			
			System.out.print("수정할 학번?");
			dto.setHak(sc.next());
			
			System.out.print("국어?");
			dto.setKor(sc.nextInt());
			
			System.out.print("영어?");
			dto.setEng(sc.nextInt());
			
			System.out.print("수학?");
			dto.setMat(sc.nextInt());
			
			//실행하면 result 반환
			int result = dao.updateDate(dto); //dto를 넘겨주면서 이 데이터를 수정해달라 요청
			
			//정상적으로 잘 실행됬다면
			if(result != 0) {
				System.out.println("수정성공!!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString()); //에러 처리
		}
		
		//void라서 반환값이 없다!
	}
	
	//삭제 메서드
	public void delete() {
		
		String hak; //학번만 받으면 되니 hak 선언
		
		try {
			
			System.out.print("삭제할 학번?");
			hak = sc.next();
			
			int result = dao.deleteData(hak);
			
			if(result != 0) {
				System.out.println("삭제 성공!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//void를 써서 반환값 필요없움
		
	}
	
	//전체출력
	public void selectAll() {
		
		List<ScoreDTO> lists = dao.getList();
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		while(it.hasNext()) {
			ScoreDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
	
	//이름검색
	public void searchName() {
		
		String name;
		
		try {
			
			System.out.println("검색할 이름?");
			name = sc.next();
			
			List<ScoreDTO> lists = dao.getList(name);
			
			Iterator<ScoreDTO> it = lists.iterator();
			
			while(it.hasNext()) {
				ScoreDTO dto = it.next();
				System.out.println(dto.toString());
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	//학번검색
		public void searchHak() {
			
			String hak;
			
			try {
				
				System.out.print("검색할 학번?");
				hak = sc.next();
				//오버라이딩 했어도 매개변수 타입이 같기 때문에 이름을 바꿔줘야한다. getList -> getHakList
				//학번은 primarykey라서 dto를 1개 가져오거나 안가지고 와서 lists,list 대신 dto를 쓴다.
				//이렇게되면 iterator도 필요없어진다.그리고 while문도 필요없어진다.

				ScoreDTO dto = dao.getHakList(hak);
				
				if(dto != null) {  //검증작업 dto가 null이 아니면
					
					//ScoreDTO의 toString호출
					System.out.println(dto.toString());
				}
				
				
			} catch (Exception e) {
				System.out.println(e.toString()); 
			}
		}

}