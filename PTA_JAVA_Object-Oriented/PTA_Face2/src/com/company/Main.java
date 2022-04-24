package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a,b,c;
        a=in.nextInt();
        b=in.nextInt();
        c=in.nextInt();

        Bank_Account test=new Bank_Account(a);
        System.out.println(test.getBalance());
        test.withdraw(b);
        System.out.println(test.getBalance());
        test.deposit(c);
        System.out.println(test.getBalance());
    }

}

class Bank_Account{
    int balance;
    public int getBalance()
    {
        return balance;
    }
    public void setBalance(int input)
    {
        balance=input;
    }
    Bank_Account()
    {
        balance=0;
    }
    Bank_Account(int input)
    {
        balance=input;
    }
    public void withdraw(int input)
    {
        balance=balance-input;
    }
    public void deposit(int input)
    {
        balance=balance+input;
    }

}
