package com.day2_Q;

import java.util.Scanner;

public class Q5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt, qty=15800;
        double sum=0;

        System.out.print("구입 수량을 입력하세요 : ");

        cnt = sc.nextInt();

        if(cnt >=30)
            sum=cnt*qty*0.8;
        else if(cnt >=20)
            sum=cnt*qty*0.85;
        else if(cnt >=10)
            sum=cnt*qty*0.9;
        else
            sum=cnt*qty;

        System.out.println("구입수량 : " + cnt + "개, 판매총금액 : " + sum +"원");

    }
}