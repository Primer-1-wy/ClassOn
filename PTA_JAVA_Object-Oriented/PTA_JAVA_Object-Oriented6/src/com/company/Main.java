package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Person[] test=new Person[n];
        String a;
        int b;
        boolean c;
        for(int i=0;i<n;i++)
        {
            a=sc.next();
            b=sc.nextInt();
            c=sc.nextBoolean();
            test[i]=new Person(a,b,c);
        }
        for(int i=n-1;i>=0;i--)
        {
            System.out.println(test[i].toString());
        }
        Person Null_test=new Person();
    }
}
class Person
{
    private String name;
    private int age;
    private boolean gender;
    private int id;

    Person()//无参构造
    {
        System.out.println("This is constructor");
        System.out.println(name+","+age+","+gender+","+id);
        System.out.println(toString());
    }
    Person(String Name,int Age,boolean Gender)//有参构造
    {
        name=Name;
        age=Age;
        gender=Gender;
    }
    public void SetName(String Name) {name=Name;}
    public String GetName() {return name;}
    public void SetAge(int Age) {age=Age;}
    public int GetAge() {return age;}
    public void SetGender(boolean Gender) {gender=Gender;}
    public boolean GetGender() {return gender;}
    public void SetId(int Id) {id=Id;}
    public int GetId() {return id;}
    public String toString()
    {
        return "Person [name="+name+", age="+age+", gender="+gender+", id="+id+"]";
    }
}


