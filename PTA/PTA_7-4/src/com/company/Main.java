package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    int month=sc.nextInt();
    int year=sc.nextInt();
    int day[][]={{0,31,29,31,30,31,30,31,31,30,31,30},{0,31,28,31,30,31,30,31,31,30,31,30}};//闰年每个月的天数，由于数组0开始计数所以前面得存一个0让一月份份天数存在run[1]里；
        if((year%4==0&&year%100!=0)||year%400==0)
            System.out.println(day[0][month]);
        else
            System.out.println(day[1][month]);

    }
}
