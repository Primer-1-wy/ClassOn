package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    int x=sc.nextInt();
    int y= sc.nextInt();
    if(x*x+y*y<100)
        System.out.print(1);
    else
        System.out.print(0);
    }
}
