/*          7-8 jmu-Java-03面向对象基础-04-形状-继承 (15 分)                        */
package com.company;
import java.util.Scanner;
import java.util.Arrays;
/*
4
rect
3 1
rect
1 5
cir
1
cir
2
* */
public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        Shape[] test=new Shape[n];
        int input1,input2;
        String str;
        for(int i=0;i<n;i++)
        {
            str= sc.next();
            if(str.equals("rect"))
            {
                test[i]=new Rectangle(sc.nextInt(), sc.nextInt());
            }
            else
            {
                test[i]=new Circle(sc.nextInt());
            }
        }
        System.out.println(sumAllPerimeter(test,n));
        System.out.println(sumAllArea(test,n));

        /*
                String temp = "[";
        for (int i = 0; i < n; i++) {
            temp += test[i];
            temp += (i < n-1) ? ", " : "]";
        }
        System.out.println(temp);
        */
/*
        System.out.print("[");
        for(int i=0;i<n;i++)
        {
            System.out.print(test[i]);
            if(i!=3)
                System.out.print(", ");
            else
                System.out.print("]");
        }
      */
        System.out.println(Arrays.toString(test));

        System.out.println("");


        for (Shape s: test) {
            System.out.println(s.getClass()+","+s.getClass().getSuperclass());
        }
    }

    public static double sumAllArea(Shape[] ss,int n){
        double sum=0;
        for (int i=0;i<n;i++) {
            sum += ss[i].getArea();
        }
        return sum;
    }

    public static double sumAllPerimeter(Shape[] ss,int n){
        double sum=0;
        for (int i=0;i<n;i++) {
            sum += ss[i].getPerimeter();
        }
        return sum;
    }
}


    abstract class Shape//抽象类
    {
        double PI=3.14;
        public abstract double getPerimeter();//俩个抽象函数
        public abstract double getArea();
    }

    class Rectangle extends Shape
    {
        private int width;
        private int length;
        Rectangle(int width,int length){this.width=width;this.length=length;}
        public int getWidth() {return width;}
        public void setWidth(int width) {this.width = width;}
        public int getLength() {return length;}
        public void setLength(int length) {this.length = length;}
        public double getPerimeter(){return 2*(width+length);}
        public double getArea(){return width*length;}
        public String toString() {return "Rectangle [" + "width=" + width + ", length=" + length + "]";}
    }

    class Circle extends Shape
    {
        private int radius;
        Circle(int radius){this.radius=radius;}
        public int getRadius() {return radius;}
        public void setRadius(int radius) {this.radius = radius;}
        public double getPerimeter(){return 2*PI*radius;}
        public double getArea(){return PI*Math.pow(radius,2);}
        public String toString() {return "Circle [" + "radius=" + radius + "]";}
    }

