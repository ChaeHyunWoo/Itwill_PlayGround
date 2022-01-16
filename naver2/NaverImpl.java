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
			System.out.print("���̵�(8~15���ڳ��� ������ ���� ȥ�� �Է�) > ");
			String id = sc.next();
			if(id.length() < 8 || id.length() > 15) {
				throw new Exception("8~15���ڳ��� �Է����ּ���.");
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
				throw new Exception("������ ���� ȥ���Դϴ�.");
			} else {
				vo.setId(id);								
			}
			System.out.print("��й�ȣ > ");
			vo.setPwd(sc.next());
			
			System.out.print("��й�ȣ ��Ȯ�� > ");
			String pwd = sc.next();
			
			if(vo.getPwd().equals(pwd)) {
				vo.setPwd2(pwd);									
			} else {
				throw new Exception("ù��° ��й�ȣ�� �ٸ��ϴ�.");
			} 
			System.out.print("�̸� > ");
			vo.setName(sc.next());
			System.out.print("���� (��/��) > ");
			String gender = sc.next(); 
	
			if(gender.equals("��") || gender.equals("��")) {
				vo.setGender(gender);				
			} else {
				throw new Exception("�ٸ� ���� �Է��ϼ̽��ϴ�.");
			}
			System.out.print("���� > ");
			vo.setBirth(sc.next());
			System.out.print("�̸��� > ");
			vo.setEmail(sc.next());
			System.out.print("��ȣ > ");
			vo.setTel(sc.next());
			listvo.add(vo);
			break;
		} while(true);
		
	    } catch (NaverException e) {
			System.out.println("�ٽ� �Է����ּ���.");
			join();
		} 
	}
	@Override
	public void print() {
		for(int i = 0; i < listvo.size(); i++) {	
			System.out.println("���̵� : "+listvo.get(i).getId() +
					" �н����� : "+ listvo.get(i).getPwd() +
					" �̸� : "+listvo.get(i).getName() +
					" ���� : " +listvo.get(i).getGender() +
					" ���� : " +listvo.get(i).getBirth() +
					" �̸��� : " +listvo.get(i).getEmail() +
					" ��ȭ��ȣ : " +listvo.get(i).getTel());
		}
	}
	@Override
	public void idfind() {
		System.out.print("���̵� �˻� > ");
		String id = sc.next();
		for(int i = 0; i < listvo.size(); i++) {
			if(id.equals(listvo.get(i).getId())) {
				System.out.println(listvo.get(i).toString());
			}
		}
	}
}
