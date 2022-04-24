package com.company;

public class Employee {
    private double salary;
    private String name;
    private int age;

    Employee(){};
    Employee(String Name,double Salary,int Age)
    {
        salary=Salary;
        name=Name;
        age=Age;
    }


    public void setName(String Name) {name=Name;}
    public String getName() {return name;}
    public void setSalary(double Salary) {salary=Salary;}
    public double getSalary() {return salary;}
    public void setAge(int Age) {age=Age;}
    public int getAge() {return age;}


    public void updateSalary(double rate)
    {
        salary=salary*(1+rate);
    }
    public String toString()
    {
        return ("Name:"+name+",Salary:"+salary+",Age:"+age+";");
    }


}

