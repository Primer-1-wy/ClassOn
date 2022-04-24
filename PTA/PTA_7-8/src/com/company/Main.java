package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=0;
        for(int j=n;j>0;j--)
        {
            for(i=0;i<j-1;i++)
            {
                System.out.print(" ");
            }
            for(i=0;i<2*(n-j)+1;i++)
            {
                System.out.print("*");
            }
            System.out.print("\n");

        }
    }
}
