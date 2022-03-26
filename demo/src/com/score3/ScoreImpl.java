package com.score3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	
	private List<ScoreVO> lists = new ArrayList<ScoreVO>();
	Scanner sc = new Scanner(System.in);

	@Override
	public int input() {
		
		int result = 0;
		
		ScoreVO  vo = new ScoreVO();
		
		System.out.print("�й�?");
		vo.setHak(sc.next());
		
		System.out.print("�̸�?");
		vo.setName(sc.next());
		
		System.out.print("����?");
		vo.setKor(sc.nextInt());
		
		System.out.print("����?");
		vo.setEng(sc.nextInt());
		
		System.out.print("����?");
		vo.setMat(sc.nextInt());
		
		//���⼱ ���� �����͸� lists�� �־��µ� jdbc������ db�� �ִ´�.
		//���������� �����ϰ� �Ʒ��� sql�� �ٲ��.(jdbc)�� �Ҷ�
		//db�� �����͸� �ִ� Ŭ������ �������� (jdbc)�� �Ҷ�
		//����ڰ� �����͸� ������ VO�� �־��ְ� SQL�� ���� DB�� �־��ش�.
		lists.add(vo);
		
		
		return result; //result �� DB�Ҷ� �ʿ���.
	}

	@Override
	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator(); //lists���� ScoreVO�� ����.
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			
			System.out.println(vo.toString());
			
			/*System.out.printf("%6s %6s %4d %4d %4d %4d %4d\n", vo.getHak(), vo.getName(), vo.getKor(), vo.getEng(),
					vo.getMat(), (vo.getKor() + vo.getEng() + vo.getMat()), 
					(vo.getKor() + vo.getEng() + vo.getMat()) / 3); */
			
		}
		
	}

	@Override
	public void searchHak() {
		
		System.out.print("�˻��� �й� : ");
		String hak = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			
			//�� - String�� equals�� ��
			if(vo.getHak().equals(hak)) {
				
				System.out.println(vo.toString());
				//break; // ���ϴٰ� ������ ã���� �ڿ��� ���� �ʿ䰡 ���⿡ break�� ����
			}
		}
	}

	@Override
	public void searchName() {
		
		System.out.print("�˻��� �̸� : ");
		String name = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			
			//�� - String�� equals�� ��
			if(vo.getName().equals(name)) {
				
				System.out.println(vo.toString());
				//break; // ���ϴٰ� ������ ã���� �ڿ��� ���� �ʿ䰡 ���⿡ break�� ����
			}
		}
	}
}