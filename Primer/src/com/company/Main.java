package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();

        System.out.println(input/100+input%100/10+input%10);
    }
}
