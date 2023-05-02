package com.navar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NaverImpl implements Naver {
	Scanner sc = new Scanner(System.in);
	List<NaverVO> listvo = new ArrayList<NaverVO>();
	@Override
	public void join() throws Exception {
		NaverVO vo = new NaverVO();
		
	try {	
		do {
			System.out.print("아이디(8~15글자내로 영문자 숫자 혼용 입력) > ");
			String id = sc.next();
			if(id.length() < 8 || id.length() > 15) {
				throw new Exception("8~15글자내로 입력해주세요.");
			}
			boolean eng = false;
			boolean num = false;
			for(int i=0; i < id.length(); i++) {
				char ch = id.charAt(i);
				if((ch<'A' && ch>'Z') || (ch>'a' && ch<'z')) {
					eng = true;
				} else if(ch>='0' && ch<='9') {
					num = true;
				}
			}
			if(eng==false || num==false) {
				throw new Exception("영문자 숫자 혼용입니다.");
			} else {
				vo.setId(id);								
			}
			System.out.print("비밀번호 > ");
			vo.setPwd(sc.next());
			
			System.out.print("비밀번호 재확인 > ");
			String pwd = sc.next();
			
			if(vo.getPwd().equals(pwd)) {
				vo.setPwd2(pwd);									
			} else {
				throw new Exception("첫번째 비밀번호가 다릅니다.");
			} 
			System.out.print("이름 > ");
			vo.setName(sc.next());
			System.out.print("성별 (남/여) > ");
			String gender = sc.next(); 
	
			if(gender.equals("남") || gender.equals("여")) {
				vo.setGender(gender);				
			} else {
				throw new Exception("다른 값을 입력하셨습니다.");
			}
			System.out.print("생일 > ");
			vo.setBirth(sc.next());
			System.out.print("이메일 > ");
			vo.setEmail(sc.next());
			System.out.print("번호 > ");
			vo.setTel(sc.next());
			listvo.add(vo);
			break;
		} while(true);
		
	    } catch (NaverException e) {
			System.out.println("다시 입력해주세요.");
			join();
		} 
	}
	@Override
	public void print() {
		for(int i = 0; i < listvo.size(); i++) {	
			System.out.println("아이디 : "+listvo.get(i).getId() +
					" 패스워드 : "+ listvo.get(i).getPwd() +
					" 이름 : "+listvo.get(i).getName() +
					" 성별 : " +listvo.get(i).getGender() +
					" 생일 : " +listvo.get(i).getBirth() +
					" 이메일 : " +listvo.get(i).getEmail() +
					" 전화번호 : " +listvo.get(i).getTel());
		}
	}
	@Override
	public void idfind() {
		System.out.print("아이디 검색 > ");
		String id = sc.next();
		for(int i = 0; i < listvo.size(); i++) {
			if(id.equals(listvo.get(i).getId())) {
				System.out.println(listvo.get(i).toString());
			}
		}
	}
}
