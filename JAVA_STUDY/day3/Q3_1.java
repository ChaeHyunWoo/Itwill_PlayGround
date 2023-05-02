package com.day3;
//3. 두수를 입력받아 적은 수에서 큰수까지의 합
//		1~100 까지의 합 : 5050
import java.util.Scanner;

public class Q3_1 {
    public static void main(String[] args) {
        //if와 if-else문 사용
        Scanner sc = new Scanner(System.in);

        int num1, num2;
        int sum = 0;

        System.out.print("첫번째 수 입력  : ");
        num1 = sc.nextInt();
        System.out.print("두번째 수 입력 : ");
        num2 = sc.nextInt();

        if(num1>num2) {         // 첫번째 입력한 수가 클 때
            for(int i=num2; i<=num1; i++) {
                sum += i;
            }
            System.out.printf("%d에서 %d까지의 합 : %d ", num2, num1, sum);
        } else if(num1<num2) {      //첫번째 입력한 수가 작을 때
            for(int i=num1; i<=num2; i++) {
                sum += i;
            }
            System.out.printf("%d에서 %d까지의 합 : %d", num1, num2, sum);
        }
    }
}