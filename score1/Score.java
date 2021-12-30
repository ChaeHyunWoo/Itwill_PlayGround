package com.score1;

import java.util.Scanner;

public class Score {
	
	int inwon;	//int형태의 자료형이라 생각하면 쉽다
	Record [] rec;	// Record 형태의 자료형이라 생각하면 쉽다.
	//클래스의 기본 값은 null이다.
	Scanner sc = new Scanner(System.in);
	
	
	public void set() {
		
		//Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("인원 수 : "); // 3
			inwon = sc.nextInt();
		} while(inwon<1 || inwon>10);
		
		rec = new Record[inwon];// 인원수 만큼 배열이 생성됨.
	}
	
	
	public void input() {
		
		String [] title = {"국어 : ", "영어 : ", "수학 : "};
		
		
		for(int i=0; i<inwon; i++) {
			
			rec [i] = new Record(); // 객체 생성
			
			System.out.print("이름 : "); //suzi
			rec[i].name = sc.next();
			
			
			for(int j=0; j<3; j++) {
				
				 System.out.print(title[j]);
				 rec[i].score[j] = sc.nextInt();
				 
				/* 아래코딩을 간단하게하면 위의 코딩
				System.out.print("국어 : ");
				rec[i].score[j] = sc.nextInt();
				
				System.out.print("영어 : ");
				rec[i].score[j] = sc.nextInt();
				
				System.out.print("수학 : ");
				rec[i].score[j] = sc.nextInt();
				*/
				 
				 //총점
				 rec[i].tot += rec[i].score[j];
				
				}
				//평균
				rec[i].ave = rec[i].tot / 3; //평균은 총점이 다 계산되어야 나와서 for문 밖에 선언한다.	
			
		}
	}
	
	
	//순위 구하기
	private void ranking() {
		
		int i,j; // 지역변수(로컬변수) 이 지역 내에서만 사용가능
		
		for(i=0; i<inwon; i++) {	//석차 1로 초기화
			rec[i].rank = 1;
		}
		
		//순위 selection sort
		for(i=0; i<inwon-1; i++) {
			for(j=i+1; j<inwon; j++) {
				
				if(rec[i].tot>rec[j].tot) {
					rec[j].rank++;
				} else if(rec[i].tot<rec[j].tot) {
					rec[i].rank++;
				}
			}
		}
	}
	
	
	
	//출력
	public void print() {
		
		ranking(); // 메소드 안에서 다른 메소드 호출가능 ( print메소드안에서 ranking메소드 호출)
		
		for(int i=0; i<inwon; i++) {
			
			System.out.printf("%6s", rec[i].name);
			
			for(int j=0; j<3; j++) {
				
				System.out.printf("%4d", rec[i].score[j]);
			}
			
			System.out.printf("%5d", rec[i].tot);//총점
			System.out.printf("%4d", rec[i].ave);//평균
			System.out.printf("%4d\n", rec[i].rank);//순위
		}
	}
	
	
}
