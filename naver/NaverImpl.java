package com.naver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class NaverImpl implements Naver {
	
	private List<NaverVO> list = new ArrayList<NaverVO>();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public int input() throws Exception {
		
		int result = 0;
	
		NaverVO vo = new NaverVO();	
		
		System.out.print("ID : ");
		vo.setId(sc.next());
		
		if(vo.getId().length()<8 || vo.getId().length()>15) { 
			
			throw new Exception("Id는 8~15자 이내로 입력하세요!");		
		}
		
		boolean eng=false; 
		boolean num=false;
		
		for(int i=0; i<vo.getId().length(); i++){			
			char ch = vo.getId().charAt(i);	
			
			if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch < 'z')){
				eng=true;
			}else if(ch >='0' && ch <= '9'){
				num=true;
			}
		}
		
		if(eng == false || num == false) {
			throw new Exception("Id는 영문자,숫자를 혼용해야합니다.");
		}
		
		System.out.print("비밀번호?");
		vo.setPw(sc.next());
		System.out.print("이름 : ");
		vo.setName(sc.next());
		System.out.print("성별[남,여]: ");
		vo.setGender(sc.next());
		System.out.print("생년월일(1997-05-27) : ");
		vo.setBirth(sc.next());
		System.out.print("이메일 입력하세요. : ");
		vo.setEmail(sc.next());
		System.out.print("전화번호 입력하세요. : ");
		vo.setTel(sc.next());
		
		list.add(vo);
		return result;
			

	}

		
	
	
	@Override
	public void print() {
		
		Iterator<NaverVO> it = list.iterator(); //lists에는 NaverVO가 들어간다.
		
		while(it.hasNext()) {
			
			NaverVO vo = it.next();
			
			System.out.println(vo.toString());
		}
		
	}
		
	@Override
	public void searchId() {
		
		System.out.print("아이디 검색 : ");
		String id = sc.next();
		
		Iterator<NaverVO> it = list.iterator();
		
		while(it.hasNext()) {
			
			NaverVO vo = it.next();
			
			//비교 - String은 equals로 비교
			if(vo.getId().equals(id)) {
				
				System.out.println(vo.toString());
				break; // 비교하다가 같은걸 찾으면 뒤에껄 비교할 필요가 없기에 break를 써줌
			}
		}
	}
}