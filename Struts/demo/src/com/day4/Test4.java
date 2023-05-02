package com.day4;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		// 10명 이내의 이름과 점수를 입력받아
		// 점수가 높은사람에서 낮은사람 순으로 출력(점수 내림차순)
		
		Scanner sc = new Scanner(System.in);
		
		String [] name; //배열을 몇개만들지 정확히 모를 때 이렇게 한다.
		int [] score;  //여기서 배열선언안하고 아래에서 해도되지만 변수는 위에서 선언해주는 것이 좋음 
		
		int i, j, people, temp1;// temp1은 점수를 받는다.(int)
		String temp2;	//temp2는 이름을 받는다.(String)
		
		do {
			System.out.print("인원 수[1~10] : "); // 3
			people = sc.nextInt();
		} while(people<1 || people>10);	//1보다 작거나 10보다 크면 안되게끔
		
		
	
		//위의 배열을 갖고와서 쓴다.
		//배열 메모리 할당(객체 생성)
		name = new String[people];	//여기서  String [] name = new String[people];
		score = new int[people];	// 		  int [] score = new int[people]; 이렇게 선언가능 위에서 선언안하고.
		
		
		for(i=0; i<people; i++) {
			System.out.print("이름 : "); //suzi
			name[i] = sc.next();
			System.out.print("점수 : "); //50
			score[i] = sc.nextInt();
		}
		
		// 총점 정렬
		for(i=0; i<score.length-1; i++) {
			for(j=i+1; j<score.length; j++) {
				
				if(score[i]<score[j]) {
					
					temp1 = score[i];		//score자리바꿈
					score[i] = score[j];
					score[j] = temp1;
					
					temp2 = name[i];		//name 자리바꿈
					name[i] = name[j];
					name[j] = temp2;
				}
			}
		}
		//2개이상의 배열을 가져올때는 확장for문을 못씀 / 배열 1개일때만 가능
		for(i=0; i<people; i++) {
			System.out.printf("%6s %4d \n", name[i], score[i]);
		}
	}
}