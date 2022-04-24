package com.company;
import javax.security.auth.Subject;
import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int flag=0;//防止崩溃
        ClassList test=new ClassList() ;
        MainMenu();
        int choice = sc.nextInt();
        while(choice!=3)
        {
            delay(2000);
            if(choice!=1&&flag==0)
            {
                MainMenu();
                choice= sc.nextInt();
                continue;
            }
            switch(choice)
            {
                case 1 :flag=1;test=Create();break;
                case 2 :print(test); break;

            }
            MainMenu();
            choice= sc.nextInt();
        }
    }

    public static void MainMenu()
    {
        System.out.println("学生选课系统");
        System.out.println("**************************");
        System.out.println("1.Create");
        System.out.println("2.Print");
        System.out.println("3.Exit");
        System.out.println("请选择（1---3）");
    }

    public static ClassList Create()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入学年");
        int semester=sc.nextInt();
        System.out.println("输入年份");
        int year =sc.nextInt();
        System.out.println("依次输入课程号和课程名");
        subject sub= new subject(sc.next(), sc.next());
        System.out.println("依次输入姓名、性别、年龄");
        Student s1= new Student(sc.next(), sc.next(), sc.nextInt());
        Student s2= new Student(sc.next(), sc.next(), sc.nextInt());
        ClassList test = new ClassList(semester, year,sub,s1,s2 );
        return test;
    }
    public static void print(ClassList test)
    {
        System.out.println(test.toString());
        System.out.println(test.getSub().toString());
        System.out.println(test.getS1().toString());
        System.out.println(test.getS2().toString());

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
