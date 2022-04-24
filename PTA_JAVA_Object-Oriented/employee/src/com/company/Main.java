package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee test1=new Employee();
        Employee test2=new Employee("test2",2000,18);
        Scanner sc=new Scanner(System.in);
        test1.setName(sc.next());
        test1.setSalary(sc.nextDouble());
        test1.setAge(sc.nextInt());
        System.out.println("Before Modifying");
        System.out.println(test1);
        System.out.println(test2);
        test1.updateSalary(0.25);
        test2.updateSalary(0.35);
        System.out.println("After:");
        System.out.println(test1);
        System.out.println(test2);
    }
}

