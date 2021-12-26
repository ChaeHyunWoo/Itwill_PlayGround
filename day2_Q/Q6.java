//6. 이름과 3과목의 점수를 입력 받아 다음조건에 따라 출력
//	-모든 과목의 점수가 40점 이상이고 평균이 60점 이상이면 합격
//	-한과목이라도 40점 미만이고 평균이 60점 이상이면 과락(불합격)
//	-평균이 60점 미만이면 불합격

//   이름 ? 홍길동
//   세과목 점수 ? 60 70 80
//   이름 : 홍길동
//   총점 : 210, 평균 : 70, 판정 :합격
package com.day2_Q;
import java.util.*;

public class Q6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1, num2, num3, total, ave;
		String name, pass = null;



		System.out.println("이름 : ");
		name = sc.next();//이름
		
		System.out.println("세과목 점수: ");
		num1 = sc.nextInt();//과목1
		num2 = sc.nextInt();//과목2
		num3 = sc.nextInt();//과목3
		
		total = num1 + num2 + num3;
		ave = (num1+num2+num3)/3;
		
		if(num1>40) {
			
			if(num2>40) {
				
				if(num3>40) {
					
					pass = "합격";
				}
				
			} else {
				pass = "과락";
			}
			
			if(ave<60) {
				pass = "불합격";
			}
			System.out.println("이름 : " + name);
			System.out.printf("총점 : %d점, 평균 : %d점, 판정 : %s", total, ave, pass);
		}
		
	}

}