package com.day3_Q;

import java.util.Scanner;

public class Q3_2 { //왕혜민씨 풀이

    public static void main(String[] args) {
         // 3. 두수를 입력받아 적은 수에서 큰수까지의 합 1~100 까지의 합 : 5050

        Scanner sc = new Scanner(System.in);

        int a, b, c, sum;

        sum = 0;

        System.out.println("두 개의 숫자를 입력하세요.");
        a = sc.nextInt();
        b = sc.nextInt();

        if (a > b) { //a가 큰수 b가 작은 수 일때
            c = a;   // a가 작은 수로 b를 큰 수가 되도록 위치를 바꿔서 계산
            a = b;
            b = c;
        }

        for (int i = a; i <= b; i++) {  // a가 작은수 b가 큰 수일 때
            sum += i;                   // if문을 패스하고 for문 진행
        }
        System.out.printf("%d와 %d사이 값들의 합: %d",a,b, sum);
    }

}