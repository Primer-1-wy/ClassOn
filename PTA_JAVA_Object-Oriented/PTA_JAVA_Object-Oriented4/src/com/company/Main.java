package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int flag=0;
        Person[] test=new Person[n];
        for(int i=0;i<n;i++)
        {
            test[i]=new Person(sc.next(), sc.nextInt());
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(test[i].toString());
        }
        String QueryName= sc.next();
        for(int i=0;i<n;i++)
           if(QueryName.equals(test[i].getName())) {
               System.out.println("查询结果：");
               System.out.println(test[i].toString());
               flag = 1;
           }
        if(flag==0)
            System.out.println("not found");

    }
}


class Person
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
        age=Age;
    }
    public int getAge()
    {
        return age;
    }
    Person()
    {
        age=1;
        name="none";
    }
    Person(String Name,int Age)
    {
        age=Age;
        name=Name;
    }
    public String toString()
    {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}

