package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
    Scanner sc=new Scanner(System.in);
    char[]a=new char[32];
    String str= sc.next();
    for(int n=0;n<str.length();n++)
    {
        a[n]=str.charAt(n);
    }
    int[] sum = new int[4];
    for(int i=0;i<4;i++)
    {
        for(int j=7;j>=0;j--)
        {
            if(a[8*i+j]=='1')
                sum[i]=sum[i]+(int)Math.pow(2,7-j);
        }
    }
        System.out.print(sum[0]+"."+sum[1]+"."+sum[2]+"."+sum[3]);
    }
}
