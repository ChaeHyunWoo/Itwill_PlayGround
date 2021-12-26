package com.day2_Q;

import java.util.Scanner;
public class Q2_1 { //선생님 정답
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a,b;

        System.out.print("첫번째 정수입력 ?");
        a = sc.nextInt();

        System.out.print("두번째 정수입력 ?");
        b = sc.nextInt();

        if (a>b)
            System.out.println("큰 숫자 : " + a + " 작은 숫자 : " + b);
        else
            System.out.println("큰 숫자 : " + b + " 작은 숫자 : " + a);
    }
}
