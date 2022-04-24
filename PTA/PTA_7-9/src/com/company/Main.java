package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int flag=0;
        String input= sc.nextLine();
        String[] a=input.split(" ");
        for(int i=0;i<a.length;i++)
        {
            //System.out.println(a[i]);
            try
            {
                sum=sum+Integer.valueOf(a[i]);
            }
            catch(Exception b)
            {
                flag=1;
                continue;
            }
        }
        System.out.println(sum);
        if(flag==1)
        {
            System.out.println("attention");
        }
    }




    /*
    public static void main(String[] args) {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int flag=0;
        String input= sc.nextLine();
        String str=input.replaceAll(" ","");
    //    System.out.println(str);
        int temp =0;
        for(int i=0;i<str.length();i++)
        {
            temp=(int)str.charAt(i);
        //    System.out.println(temp);
            if(temp>=48&&temp<=57)
                sum=sum+Character.getNumericValue(str.charAt(i));
            else
                flag=1;
        }
        System.out.println(sum);
        if(flag==1)
        {
            System.out.println("attention");
        }
    }
    */
}
