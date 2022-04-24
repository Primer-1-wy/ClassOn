package com.company;

/*  如果运行不了请把第一行注释！    */
import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to my store!");
        System.out.println("Please input your size(width&height):");
        int []flag= new int[6];
        System.out.print("Width:");
        int width=sc.nextInt();
        System.out.print("Height:");
        int height=sc.nextInt();
        double SumPrice=0;
        menu();
        int choice = sc.nextInt();;


        while(choice!=0) {
           if(judge(flag,choice))
           {
               menu();
               choice= sc.nextInt();
               continue;
           }
           switch (choice) {
                case 1:
                    SumPrice += 0.1 * width * height;
                    flag[1]=1;
                    break;
                case 2:
                    delay(1000);
                    System.out.println("Type 1 for Regular frame/Type 2 for Fancy frame");
                    int ChoiceFrame= sc.nextInt();
                    if (ChoiceFrame == 1)
                        SumPrice += 0.15 * width * height;
                    else
                        SumPrice+=0.25*width*height;
                    flag[2]=1;
                    break;
                case 3:
                    SumPrice += 0.02 * width * height;
                    flag[3]=1;
                    break;
                case 4:
                    SumPrice += 0.07 * width * height;
                    flag[4]=1;
                    break;
                case 5:
                    SumPrice += 0.35 * width * height;
                    flag[5]=1;
                    break;
                //case 0:
            }
            delay(1000);
            menu();
            delay(1000);
            System.out.println("You need to pay "+SumPrice+"$ now");
            choice = sc.nextInt();
        }
        System.out.println("The final SumPrice is :"+ SumPrice);
    }
        public static void menu()
        {
            System.out.println("This is the price menu:");
            System.out.println("1.Coloring:0.10$");
            System.out.println("2.Regular frame/Fancy frame:0.15/0.25$");
            System.out.println("3.Putting a cardboard paper behind the picture:0.02$");
            System.out.println("4.Putting a cardboard paper behind the picture:0.07$");
            System.out.println("5.Putting crowns on the corners:0.35");
            System.out.println("0.Finish and Paying");
            System.out.println("The price is calculated by charging per inch ");
            delay(2000);
            System.out.println("Please input your choice:");
            delay(1000);
        }
        public static boolean judge(int []flag,int index)//自己写的判断是否重复的函数
        {
            if(flag[index]==1)
            {
                System.out.println("Repeat Typing");
                return true;
            }
            else
                return false;
        }
        public static void delay(int ms)//自己写的延时函数
        {
            try
            {
                Thread.sleep(ms);//单位：毫秒
            } catch (Exception e) {
            }
        }

}