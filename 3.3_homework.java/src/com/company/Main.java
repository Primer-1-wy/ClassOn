package com.company;

/*  如果运行不了请把第一行注释！    */
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        System.out.println("Please input the money($):");
        double input=sc.nextDouble();//input
        /*    caculate      */
        input=input*100;
        int temp=(int)(input/100);
        System.out.println("1$:"+temp);
        temp=(int)((input%100)/50);
        System.out.println("50cent:"+temp);
        temp=(int)((input%50)/20);
        System.out.println("20cent:"+ temp);
        temp=(int)((input%100%50%20)/5);
        System.out.println("5cent:"+ temp);
    }
}
