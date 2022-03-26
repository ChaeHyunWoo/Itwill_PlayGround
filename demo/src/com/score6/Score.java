package com.score6;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// ���⿡�� ��������� �����͸� �޴� ��
//�������� ����, ������ �����ϰ� �;�(����,���� ��)
public class Score {
	
	Scanner sc = new Scanner(System.in);
	
	ScoreDAO dao = new ScoreDAO(); //��ü ����
	
	
	//�Է�
	public void insert() {
		
		
		
		try {
			
			ScoreDTO dto = new ScoreDTO(); 
			
			//��������� �й� �޾Ƽ� DTO�� ������. DTO�� �����͸� �޾Ƽ� DAO���� ������.
			System.out.print("�й�?"); //111
			dto.setHak(sc.next());
			
			System.out.print("�̸�?");//suzi
			dto.setName(sc.next()); // dto�� setName
			
			System.out.print("����?");//50
			dto.setKor(sc.nextInt());
			
			System.out.print("����?");//70
			dto.setEng(sc.nextInt());
			
			System.out.print("����?");//60
			dto.setMat(sc.nextInt());
			
			
			int result = dao.insertData(dto);
			
			if(result !=0)
				System.out.println("�߰� ����!!");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	//����
	public void update() { //��ȯ���� ������ void
		
		ScoreDTO dto = new ScoreDTO(); //��ü ����
		
		try {
			
			System.out.print("������ �й�?");
			dto.setHak(sc.next());
			
			System.out.print("����?");
			dto.setKor(sc.nextInt());
			
			System.out.print("����?");
			dto.setEng(sc.nextInt());
			
			System.out.print("����?");
			dto.setMat(sc.nextInt());
			
			//�����ϸ� result ��ȯ
			int result = dao.updateDate(dto); //dto�� �Ѱ��ָ鼭 �� �����͸� �����ش޶� ��û
			
			//���������� �� ������ٸ�
			if(result != 0) {
				System.out.println("��������!!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString()); //���� ó��
		}
		
		//void�� ��ȯ���� ����!
	}
	
	//���� �޼���
	public void delete() {
		
		String hak; //�й��� ������ �Ǵ� hak ����
		
		try {
			
			System.out.print("������ �й�?");
			hak = sc.next();
			
			int result = dao.deleteData(hak);
			
			if(result != 0) {
				System.out.println("���� ����!!");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		//void�� �Ἥ ��ȯ�� �ʿ����
		
	}
	
	//��ü���
	public void selectAll() {
		
		List<ScoreDTO> lists = dao.getList();
		
		Iterator<ScoreDTO> it = lists.iterator();
		
		while(it.hasNext()) {
			ScoreDTO dto = it.next();
			System.out.println(dto.toString());
		}
	}
	
	//�̸��˻�
	public void searchName() {
		
		String name;
		
		try {
			
			System.out.println("�˻��� �̸�?");
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
	
	//�й��˻�
		public void searchHak() {
			
			String hak;
			
			try {
				
				System.out.print("�˻��� �й�?");
				hak = sc.next();
				//�������̵� �߾ �Ű����� Ÿ���� ���� ������ �̸��� �ٲ�����Ѵ�. getList -> getHakList
				//�й��� primarykey�� dto�� 1�� �������ų� �Ȱ����� �ͼ� lists,list ��� dto�� ����.
				//�̷��ԵǸ� iterator�� �ʿ��������.�׸��� while���� �ʿ��������.

				ScoreDTO dto = dao.getHakList(hak);
				
				if(dto != null) {  //�����۾� dto�� null�� �ƴϸ�
					
					//ScoreDTO�� toStringȣ��
					System.out.println(dto.toString());
				}
				
				
			} catch (Exception e) {
				System.out.println(e.toString()); 
			}
		}

}