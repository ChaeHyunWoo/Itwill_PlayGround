package com.day3;
//3. �μ��� �Է¹޾� ���� ������ ū�������� ��
//		1~100 ������ �� : 5050
import java.util.Scanner;

public class Q3_1 {
    public static void main(String[] args) {
        //if�� if-else�� ���
        Scanner sc = new Scanner(System.in);

        int num1, num2;
        int sum = 0;

        System.out.print("ù��° �� �Է�  : ");
        num1 = sc.nextInt();
        System.out.print("�ι�° �� �Է� : ");
        num2 = sc.nextInt();

        if(num1>num2) {         // ù��° �Է��� ���� Ŭ ��
            for(int i=num2; i<=num1; i++) {
                sum += i;
            }
            System.out.printf("%d���� %d������ �� : %d ", num2, num1, sum);
        } else if(num1<num2) {      //ù��° �Է��� ���� ���� ��
            for(int i=num1; i<=num2; i++) {
                sum += i;
            }
            System.out.printf("%d���� %d������ �� : %d", num1, num2, sum);
        }
    }
}