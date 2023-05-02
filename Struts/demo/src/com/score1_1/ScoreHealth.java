package com.score1_1;

import java.util.Scanner;

import com.score1.Record;

public class ScoreHealth {
	
	int inwon;
	RecordHealth [] rec;
	Scanner sc = new Scanner(System.in);
	
	
	//(1)
	public void check() {	//인원수 제한
		
		do {
			System.out.print("회원 수 : ");
			inwon = sc.nextInt();
		} while(inwon<1 || inwon>20);	//인원수 1~20명으로 제한
		
		  rec = new RecordHealth[inwon];
	}
	
	
	//(2) 회원 신체정보 
	public void body() {
		
		String [] list = {"키 : ", "몸무게 : "};
		
		for(int i=0; i<inwon; i++) {
			
			rec [i] = new RecordHealth(); // 객체 생성
			
			System.out.print("이름 : "); //hyuenwoo
			rec[i].name = sc.next();
			
			for(int j=0; j<2; j++) {
				
				 System.out.print(list[j]);
				 rec[i].num[j] = sc.nextInt();
				 
				
			}
			
		}
	}
	
	private void bmi() {
		
		int i;
		
		for(i=0; i<inwon; i++) {
			rec[i].bmi = 1;
			rec[i].bmi = rec[i].num[1] / (rec[i].num[0] * rec[i].num[0]/10000);
		}
	}
	
	//bmi기준으로 뚱뚱이 랭킹
	public void ranking() {
		bmi();
		
		int i, j;
		
		for(i=0; i<inwon; i++) {	//석차 1로 초기화
			rec[i].rank = 1;
		}
		
		//순위 selection sort
		for(i=0; i<inwon-1; i++) {
			for(j=i+1; j<inwon; j++) {
				
				if(rec[i].bmi>rec[j].bmi) {
					rec[j].rank++;
				} else if(rec[i].bmi<rec[j].bmi) {
					rec[i].rank--;
				}
			}
		}
	}
	
	
	//출력
		public void print() {
			
			bmi();// 메소드 안에서 다른 메소드 호출가능 ( print메소드안에서 ranking메소드 호출)
			
			
			for(int i=0; i<inwon; i++) {
				
				System.out.printf("%6s", rec[i].name);
				
				for(int j=0; j<2; j++) {
					
					System.out.printf("%4d", rec[i].num[j]);
				}
				
				System.out.printf("%4d", rec[i].bmi);//bmi
				System.out.printf("%4d\n", rec[i].rank);//순위
			}
		}
}

