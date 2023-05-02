package com.score5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Score {
	
	//list�� 1�����ߵȴ�.
	private List<ScoreVO> lists;
	
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\score.txt");//�� path�����ͼ� �ٿ��� ���� �߰� ��� ����
	
	
	//������ (��Ʈ�̴ּ���)
	public Score() {
		
		try {
			//��ο� ������ ������
			if(!f.getParentFile().exists()) {	
				f.getParentFile().mkdir(); //�� ��ο� ������
			}
			
			//��ο� ���� �� ������
			if(f.exists()) {
				
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				//����� �����͸� ���� lists�� �ִ´�
				lists = (ArrayList<ScoreVO>)ois.readObject();//��ü����
				fis.close();
				ois.close();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	//�Է��ϱ�
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		ScoreVO vo = new ScoreVO();
		
		System.out.print("�̸� :");
		vo.setName(sc.next());
		
		System.out.print("������� :");
		vo.setBirth(sc.next());
		
		System.out.print("���� :");
		vo.setScore(sc.nextInt());
		
		
		//���⼭ ������ �ѹ� ���ش�
		if(lists == null) { //���⼭ null�� �ѹ��� ���� ���ߴ�.
			lists = new ArrayList<>();
		}
		
		lists.add(vo);
	}
	
	
	//�����ϱ�
	public void writeFile() {
		
		try {
			
			if(lists != null) {
				
				//����
				FileOutputStream fos = new FileOutputStream(f); //f�� ���
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				fos.close();
				oos.close();
				System.out.println("���� ���� ����!!");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void write() {
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
	}
}