package com.score5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl {
	
	private List<ScoreVO> lists = new ArrayList<ScoreVO>();
	Scanner sc = new Scanner(System.in);
	
	
	public int input() {
		
		int result = 0;
		
		ScoreVO vo = new ScoreVO(null, result, result);
		
		System.out.print("이름 : ");
		vo.setName(sc.next());
		
		System.out.print("생일 : ");
		vo.setBirth(sc.nextInt());
		
		System.out.print("점수 : ");
		vo.setScore(sc.nextInt());
		
		lists.add(vo);
		
		return result;
		
	}


	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator(); //lists에는 ScoreVO가 들어간다.
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			
			System.out.println(vo.toString());
			
		}
	}


	public void save() throws Exception {
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\data2.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		
		
		Iterator<ScoreVO> it = lists.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			
			String a = vo.getName();
			int b = vo.getBirth();
			int c = vo.getScore();
			
		
		oos.writeObject(new ScoreVO(a,b,c));
		
		}
		
		oos.close();
		fos.close();
		
		System.out.println("저장성공");
		
		
		FileInputStream fis = new FileInputStream("c:\\doc\\data2.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		

	}
}