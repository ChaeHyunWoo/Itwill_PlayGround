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
			
			throw new Exception("Id�� 8~15�� �̳��� �Է��ϼ���!");		
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
			throw new Exception("Id�� ������,���ڸ� ȥ���ؾ��մϴ�.");
		}
		
		System.out.print("��й�ȣ?");
		vo.setPw(sc.next());
		System.out.print("�̸� : ");
		vo.setName(sc.next());
		System.out.print("����[��,��]: ");
		vo.setGender(sc.next());
		System.out.print("�������(1997-05-27) : ");
		vo.setBirth(sc.next());
		System.out.print("�̸��� �Է��ϼ���. : ");
		vo.setEmail(sc.next());
		System.out.print("��ȭ��ȣ �Է��ϼ���. : ");
		vo.setTel(sc.next());
		
		list.add(vo);
		return result;
			

	}

		
	
	
	@Override
	public void print() {
		
		Iterator<NaverVO> it = list.iterator(); //lists���� NaverVO�� ����.
		
		while(it.hasNext()) {
			
			NaverVO vo = it.next();
			
			System.out.println(vo.toString());
		}
		
	}
		
	@Override
	public void searchId() {
		
		System.out.print("���̵� �˻� : ");
		String id = sc.next();
		
		Iterator<NaverVO> it = list.iterator();
		
		while(it.hasNext()) {
			
			NaverVO vo = it.next();
			
			//�� - String�� equals�� ��
			if(vo.getId().equals(id)) {
				
				System.out.println(vo.toString());
				break; // ���ϴٰ� ������ ã���� �ڿ��� ���� �ʿ䰡 ���⿡ break�� ����
			}
		}
	}
}