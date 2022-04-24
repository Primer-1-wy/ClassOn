package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
  //     System.out.println(pow(10,2));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int Start=pow(10,n-1);
        int end=10*Start;
        int sum,a;
        for(int i=Start;i<end;i++)
        {
            sum=0;
            a=i;
            for (int j=0;j<n;j++)
            {
                sum+=pow(a%10,n);
                a/=10;
            }
            if (sum==i)
            {
                System.out.println(i);
            }
        }
    }

    public static int pow(int num,int index){
        int i;
        int temp=1;
        for(i=0;i<index;i++)
        {
            temp=temp*num;
        }
        return temp;
    }

}
