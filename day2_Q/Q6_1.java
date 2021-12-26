package com.day2_Q;

import java.util.Scanner;

public class Q6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int kor,eng,mat,tot,avg;
        String pan;

        System.out.print("이름 ? ");
        name=sc.next();
        System.out.print("세과목 점수 ?");
        kor=sc.nextInt();
        eng=sc.nextInt();
        mat=sc.nextInt();

        tot=kor+eng+mat;
        avg=tot/3;

        if(kor>=40&&eng>=40&&mat>=40&&avg>=60)
            pan="합격";
        else if(avg>=60)
            pan="과락";
        else
            pan="불합격";

        System.out.println("이름 : " + name);
        System.out.println("총점 : " + tot + " 평균 : " + avg + " 판정 : " + pan);

    }
}