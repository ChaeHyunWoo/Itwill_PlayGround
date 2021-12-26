//  5.단가 15,800원짜리 상품을 일정 수량 이상 구입시 할인을 해줍니다.
//    할인율은 다음과 같습니다.
//    10개 이상 -> 10%
//    20개 이상 -> 15%
//    30개 이상 -> 20%
//    판매금액을 계산해봅니다.
//    예) 구입수량 15개인 경우 -> 구입수량: 15개, 판매총금액: 213300원
package com.day2_Q;
import java.util.*;
public class Q5 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		
		float won = 15800;
		int num;
		
		System.out.println("몇개 구입했나요 고객님?");
		num = result.nextInt();
		
		if(num>=10) {
			won = won * 0.9f;
		}
		if(num>=20) {
			won = won * 0.85f;
		}
		if(num>=30) {
			won = won * 0.8f;
		}
		System.out.println("구입 수량 : " + num + "개" + ", 판매 총 금액 : " + ((int)won*num)+"원");
	}
}