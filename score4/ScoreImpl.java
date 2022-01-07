package com.score4;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score {
	
	//key�� �й� / value �� ScoreVO
	private Map<String, ScoreVO> hMap = new TreeMap<>();
	
	Scanner sc = new Scanner(System.in);
	
	String hak;
	
	@Override
	public void input() {
		
		System.out.print("�й� : ");
		hak = sc.next();
		
		if(searchHak(hak)) {
			System.out.println("�й��� �����մϴ� �߰� ����!!");
			return; //�������������� Ż��
		}
		
		ScoreVO vo = new ScoreVO();
		
		System.out.print("�̸� : ");
		vo.setName(sc.next());
		
		System.out.print("���� : ");
		vo.setKor(sc.nextInt());
		
		System.out.print("���� : ");
		vo.setEng(sc.nextInt());
		
		System.out.print("���� : ");
		vo.setEng(sc.nextInt());
		
		//List�� add Map�� put
		hMap.put(hak, vo);
		
		System.out.println("�߰� ����!");
	}

	@Override
	public boolean searchHak(String hak) {
		
		//���� �����ϴ��� �˻�
		if(hMap.containsKey(hak)) {
			return true;
		}
		
		return false;
	}

	@Override
	public void print() {
							//Map���� Iterator������ �ϴ� �ڵ�ۿ����� �ܿ�����.(��ȸ����)
		Iterator<String> it = hMap.keySet().iterator();//map�� ���ͷ����Ͱ� ���⿡ keyset���� �����ͼ� ����.
		
	while(it.hasNext()) {
			
			String hak = it.next();
			ScoreVO vo = hMap.get(hak);
			
			System.out.println(hak + " " + vo.toString());
		}
	}

	@Override
	public void delete() {
		String del;
		System.out.print("������ �й�?");
		del = sc.next();

		if (hMap.containsKey(del)) {
			hMap.remove(del);
			System.out.println("�����Ϸ�");
		} else {
			System.out.println("�ش� �й� ����");
		}
	}

	@Override
	public void update() {
		System.out.print("�̸�, ������ ������ �й�?");
		hak = sc.next();

		if (!searchHak(hak)) {
			
			System.out.println("�Էµ��� ���� �й��Դϴ�.");
			return;
		}
		
			String key = hak;
			
			ScoreVO vo1 = hMap.get(key); 
			String preName = vo1.getName();
			
			vo1.setName(preName); //�̸��� ��������� �־����� ������ NULL���� �����ǰ� ��	
			
			System.out.print("����");
			vo1.setKor(sc.nextInt());
			System.out.print("����");
			vo1.setEng(sc.nextInt());
			System.out.print("����");
			vo1.setMat(sc.nextInt());

			hMap.put(key, vo1);
			System.out.println("���� ����!");
	}
	

	@Override
	public void findHak() {
		System.out.print("�˻��ϰ� ���� �й�?");
		hak = sc.next();
		
		if (hMap.containsKey(hak)) {
		
			ScoreVO value = hMap.get(hak);
			System.out.println(hak + ":" + value);
			return;
		
		} else {
		
			System.out.println(hak + ": �ش� �й� ���� ����");
		}
	}

	@Override
	public void findName() {
		System.out.print("�˻��ϰ� ���� �̸� : ");
		String fName = sc.next();

		Iterator<String> it2 = hMap.keySet().iterator();
		boolean flag = false; //ã�� �̸��� �ִ��� flag ���

		while (it2.hasNext()) { //���� �̸��� �������� �� ����. break ���� �ȵ�. ������ �ִ� ������ �� �������� ��.
		
			String key = it2.next();
			ScoreVO vo = hMap.get(key);
			
			if (vo.getName().equals(fName)) { 
			
				System.out.println("�й�:" + key + "���� :" + vo);
				flag = true; //�ѹ��̶� ������ �̸��� ������ flag�� true�� ����
			
			}
		
		}
		
		if (!flag) {
			System.out.println("�ش��ϴ� �̸��� �����");
		}
	}

}