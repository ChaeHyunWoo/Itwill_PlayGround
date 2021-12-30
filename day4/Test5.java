package com.day4;

import java.util.Random;

public class Test5 {

	public static void main(String[] args) {
		
		//1~45까지의 수 중에서 6개의 난수를 발생시켜 크기순으로 정렬 (로또)
		
		Random rd = new Random();
		int [] num = new int[6];
		int i, j, n, temp;
		
		n = 0;
		//Math.random();
		//몇번 실행해야할지 모르니 while문 사용'
	
		while(n<6) {	// 6개의 랜덤숫자 생성
			num[n] = rd.nextInt(45)+1;	//(45)만쓰면 0부터 44이다. (45)+1을 하면 1~45 범위가 나온다
										//@@ 매우 중요 @@//
			for(i=0; i<n; i++) {		//이 while문 방법으로하면 중복값이 절대 안나온다.
				if(num[i] == num[n]) {	// 중복값이 나오면 n-- 감소시켜 배열 전 칸으로 가서 다시 랜덤숫자를 뽑는다.
					n--;				// 쉽게 말하자면 중복숫자가 안나오면 랜덤으로 6개를 쭉 뽑아주고, 만약에
					break;				// 중복값이 나오면 다시 이전칸으로 돌아가는데 break를 만나서 둘의 수를  
				}						// 비교하지 않고 다시 랜덤숫자를 채운다.
			}
			n++;
		}
		
		// 정렬	랜덤뽑기해서 정렬안하려면 이 부분을 주석처리
		for(i=0; i<num.length-1; i++) {
			for(j=i+1; j<num.length; j++) {
				
				if(num[i]>num[j]) {
					
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}		//여기까지
		
		//for(int i=0; i<num.length; i++) 아래의 for문과 여기 for문과 같다.
		for(int su : num) {	//확장 for문 -> 배열에서만 사용 가능하다.
			System.out.printf("%4d", su);
		}
	}
}
