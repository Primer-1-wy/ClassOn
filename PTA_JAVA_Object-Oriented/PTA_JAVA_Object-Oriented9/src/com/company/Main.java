package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();

    String input;
    for(int i=0;i<n;i++)
    {
        input= sc.next();
        if(input.equals("1"))//Circle
        {
            Circle circle=new Circle(sc.nextFloat());
            circle.print();
        }
        else if(input.equals("2"))
        {
            Rectangle rec=new Rectangle(sc.nextFloat(), sc.nextFloat());
            rec.print();
            // System.out.println(rec);
        }
    }
    sc.close();





    }
}

interface Shape{
    //public static float PI=
    float getArea();//求面积
    float getPerimeter();//求周长
}

class Circle implements Shape
{
    private float radius;//半径
    Circle(){radius=0;}
    Circle(float r){radius=r;}
    public float getArea(){return (float)(Math.PI*Math.pow(radius,2));}
    public float getPerimeter(){return (float)(2*Math.PI*radius);}
    public String toString(){return getArea()+" "+getPerimeter();}
    public void print(){System.out.printf("%.2f %.2f\n",getArea(),getPerimeter());}
}

class Rectangle implements Shape
{
    private float width;//宽
    private float length;//长
    Rectangle(){width=0;length=0;}
    Rectangle(float w,float l){width=w;length=l;}
    public float getArea(){return (width*length);}
    public float getPerimeter(){return 2*(width+length);}
    public String toString(){return getArea()+" "+getPerimeter();}
    public void print(){System.out.printf("%.2f %.2f\n",getArea(),getPerimeter());}

}
