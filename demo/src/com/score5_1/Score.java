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
	
	//list는 1개여야된다.
	private List<ScoreVO> lists;
	
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\score.txt");//위 path가져와서 붙여서 뒤의 추가 경로 붙임
	
	
	//생성자 (힌트주셨던거)
	public Score() {
		
		try {
			//경로에 파일이 없으면
			if(!f.getParentFile().exists()) {	
				f.getParentFile().mkdir(); //그 경로에 만들어라
			}
			
			//경로에 파일 이 있으면
			if(f.exists()) {
				
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				//저장된 데이터를 위의 lists에 넣는다
				lists = (ArrayList<ScoreVO>)ois.readObject();//객체생성
				fis.close();
				ois.close();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	//입력하기
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		ScoreVO vo = new ScoreVO();
		
		System.out.print("이름 :");
		vo.setName(sc.next());
		
		System.out.print("생년월일 :");
		vo.setBirth(sc.next());
		
		System.out.print("점수 :");
		vo.setScore(sc.nextInt());
		
		
		//여기서 검증을 한번 해준다
		if(lists == null) { //여기서 null은 한번도 실행 안했다.
			lists = new ArrayList<>();
		}
		
		lists.add(vo);
	}
	
	
	//저장하기
	public void writeFile() {
		
		try {
			
			if(lists != null) {
				
				//저장
				FileOutputStream fos = new FileOutputStream(f); //f는 경로
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(lists);
				fos.close();
				oos.close();
				System.out.println("파일 저장 성공!!");
				
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