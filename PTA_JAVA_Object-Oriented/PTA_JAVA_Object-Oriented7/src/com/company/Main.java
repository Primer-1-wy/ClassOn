package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            String str = input.next();
            if(str.equals("Circle")) {
                Circle c = new Circle(input.nextDouble());
                System.out.println("The area of " + c.toString() + " is " + String.format("%.2f",c.getArea()));
                System.out.println("The perimeterof " + c.toString() + " is "+ String.format("%.2f",c.getPerimeter()));
            } else if(str.equals("Cylinder")) {
                Cylinder r = new Cylinder(input.nextDouble(), new Circle(input.nextDouble()));
                System.out.println("The area of " + r.toString() + " is " + String.format("%.2f",r.getArea()));
                System.out.println("The volume of " + r.toString() + " is " + String.format("%.2f",r.getVolume()));
            }
        }
    }
}
class Circle
{
    private double radius;
    Circle(double radius) {this.radius=radius;}
    Circle(){radius=0;}
    public void setRadius(double r){radius=r;}
    public double getRadius(){return radius;}
    public double getArea(){return Math.PI*Math.pow(radius,2);}
    public double getPerimeter(){return 2*Math.PI*radius;}
    public String toString( ){return "Circle(r:"+radius+")";}
}

class Cylinder /*extends Circle*/

{
    private double height;
    private Circle circle;
    Cylinder(double height,Circle circle)
    {
        this.height=height;
        this.circle=circle;
    }
    public Cylinder(){this.height=0;}
    public void setHeight(double height){this.height=height;}
    public  double getHeight(){return height;}
    public void setCircle(Circle circle) {this.circle = circle;}
    public Circle getCircle(){return circle;}
    public double getArea() {return circle.getPerimeter()*height+circle.getArea()*2;}
    public double getVolume(){return circle.getArea()*height;}
    public String toString( ){return "Cylinder(h:"+height+",Circle(r:"+circle.getRadius()+"))";}
}
/*
class Cylinder extends Circle
{
    private double height;
    Cylinder(double height,double radix)
    {
        super(radix);
        this.height=height;
    }
    public Cylinder()
    {
        super(0);
        this.height=0;
    }
    public void setHeight(double height){this.height=height;}
    public  double getHeight(){return height;}
}
*/
