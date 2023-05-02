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
		
		System.out.print("학번?");
		vo.setHak(sc.next());
		
		System.out.print("이름?");
		vo.setName(sc.next());
		
		System.out.print("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.print("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.print("수학?");
		vo.setMat(sc.nextInt());
		
		lists.add(vo);
		
		
		return result; //result 는 DB할때 필요함.
	}

	@Override
	public void print() {
		
		Iterator<ScoreVO> it = lists.iterator(); //lists에는 ScoreVO가 들어간다.
		
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
		
		System.out.print("검색할 학번 : ");
		String hak = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			
			//비교 - String은 equals로 비교
			if(vo.getHak().equals(hak)) {
				
				System.out.println(vo.toString());
				//break; // 비교하다가 같은걸 찾으면 뒤에껄 비교할 필요가 없기에 break를 써줌
			}
		}
	}

	@Override
	public void searchName() {
		
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		
		Iterator<ScoreVO> it = lists.iterator();
		
		while(it.hasNext()) {
			
			ScoreVO vo = it.next();
			
			//비교 - String은 equals로 비교
			if(vo.getName().equals(name)) {
				
				System.out.println(vo.toString());
				//break; // 비교하다가 같은걸 찾으면 뒤에껄 비교할 필요가 없기에 break를 써줌
			}
		}
	}
}