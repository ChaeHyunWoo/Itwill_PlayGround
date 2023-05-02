package com.day5;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		// 10명 이내의 이름과 점수를 입력받아 석차 구하기
		
		Scanner sc = new Scanner(System.in);
		
		String [] name;	//인원이 정확하지 않으니 이렇게만 선언 
		int [] score;
		int [] rank;
		
		int i, j, inwon;
		int temp1;
		do {
			System.out.print("인원[1~10] : ");	//먼저 인원수를 받고
			inwon = sc.nextInt();
		} while(inwon<1 || inwon>10);			// 
		
		//배열의 메모리 할당
		name = new String[inwon];  	// 인원수에 맞게 길이 설정
		score = new int[inwon];
		rank = new int[inwon];
		
		for(i=0; i<inwon; i++) {
			
			System.out.print((i+1) + "번째 이름 : ");
			name[i] = sc.next();	//배열 name의 i번째를 읽어낸다.
			
			System.out.print("점수 : ");
			score[i] = sc.nextInt();
			
		}
		
		//석차 초기화
		for(i=0; i<inwon; i++) {
			rank[i] = 1;	// rank[i]를 1로 초기화
		}
		
		//석차 계산
		for(i=0; i<inwon-1; i++) {	//선택 정렬
			for(j=i; j<inwon; j++) {
				
				if(score[i] > score[j]) {	//석차는 점수로 계산해서 배열 score
					rank[j]++; // score[i]가 더 크면 작은쪽 rank[j]를 1증가시킨다.
				} else if(score[i] < score[j]) {
					rank[i]++;
				}
				
				if(rank[i]>rank[j]) {
					
					temp1 = rank[i];		//랭킹정렬
					rank[i] = rank[j];
					rank[j] = temp1;
					
					
				}
			}
		}
		
		
		
		for(i=0; i<inwon; i++) {
			System.out.printf("%6s %4d %4d %n", name[i], score[i], rank[i]);
		}
	}

}