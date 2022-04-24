package com.company;

 import java.util.*;



/*
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int a ;
        while(num!=0) {
            a=num%10 ;
            num/=10;
            System.out.print(a);
        }
    }
}
*/
import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String input =sc.next();
       for(int n=input.length()-1;n>=0;n--)
       {
           System.out.print(input.charAt(n));
       }
    }
}