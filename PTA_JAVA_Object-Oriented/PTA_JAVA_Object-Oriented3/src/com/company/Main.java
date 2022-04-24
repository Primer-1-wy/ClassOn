package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        int age= sc.nextInt();
        student test=new student();
        test.display();
        test.setName(name);
        test.setAge(age);
        test.display();
    }
}

class student
{
    private String name;
    private int age;
    public void setName(String Name)
    {
        name=Name;
    }
    public String getName()
    {
        return name;
    }
    public void setAge(int Age)
    {
        if(Age<=6)
            age=7;
        else
            age=Age;
    }
    public int getAge()
    {
        return age;
    }
    student()
    {
        age=7;
        name="无名";
        System.out.println("无参构造方法");
    }
    public void display()
    {
        System.out.println("name:"+name+",age:"+age);
    }
}



