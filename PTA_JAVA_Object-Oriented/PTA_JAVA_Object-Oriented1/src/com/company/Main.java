package com.company;
import java.util.*;

//（1）成员变量：商品编号（String） 、商品名称(String)、商品单价(double)
//（2）成员变量封装，定义为私有属性，并为每个成员变量定义getXXXX，setXXXX方法
//（3）定义构造方法，要求带三个参数，参数值用于给成员变量赋值。
//（4）重写toString（）方法，将对象转换为字符串，格式：商品编号，商品名称，商品单价
//测试类要求：
import java.util.Scanner;
class GoodsInfo{
    private String no;//商品编号
    private String name;//商品名称
    private double price;//商品单价
    /*  一些对类对象操作的外部接口    */
    public String GetNo()
    {
        return no;
    }
    public void SetNo(String No)
    {
        this.no=No;
    }
    public String GetName()
    {
        return name;
    }
    public void SetName(String Name)
    {
        this.name=Name;
    }
    public double GetPrice()
    {
        return price;
    }
    public void SetPrice(double Price)
    {
        this.price=Price;
    }
    GoodsInfo(String No, String Name,double Price)//构造函数
    {
        no=No;
        name=Name;
        price=Price;
    }
    public String toString()
    {
        return GetNo()+","+GetName()+","+GetPrice();
    }

}



public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        String number = sc.next();//控制输入
        String name = sc.next();
        double price = sc.nextDouble();
        GoodsInfo a = new GoodsInfo(number, name, price);
        System.out.println(a.toString());
    }
}
