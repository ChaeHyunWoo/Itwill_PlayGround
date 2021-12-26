package com.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제2 : 밑변(width)와 높이(height)를 입력받아 삼각형 넓이(a) 구하기 double로 결과값 나오게 ㄱ ㄱ
//밑변 :
//높이 :
//넓이 : 밑변 * 높이 / 2
public class Test7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double width, height, a;

        System.out.println("(double)밑변의 길이는?");
        width = Double.parseDouble(br.readLine());

        System.out.println("(double)높이는?");
        height = Double.parseDouble(br.readLine());

        a = width * height / 2;

        System.out.println("(double)밑변 : " + width);
        System.out.println("(double)높이 : " + height);
        System.out.println("(double)넓이는 : " + a);
    }
}
