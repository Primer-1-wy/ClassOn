package Homework2;

import java.util.LinkedList;

public class ClassList {
    private int semester;
    private int year;
    private subject sub;
    private Student s1;
    private Student s2;
    //private LinkedList<Student> test_stu=new LinkedList<>();

    public ClassList() {}

    public ClassList(int semester, int year, subject sub, Student s1, Student s2) {
        this.semester = semester;
        this.year = year;
        this.sub = sub;
        this.s1 = s1;
        this.s2 = s2;
    }

    public int getSemester() {return semester;}
    public void setSemester(int semester) {this.semester = semester;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public subject getSub() {return sub;}
    public void setSub(subject sub) {this.sub = sub;}
    public Student getS1() {return s1;}
    public void setS1(Student s1) {this.s1 = s1;}
    public Student getS2() {return s2;}
    public void setS2(Student s2) {this.s2 = s2;}

    @Override
    public String toString() {
        return
                "semester=" + semester +
                ", year=" + year;
    }
    public  void print()
    {

        System.out.println(this.toString());
        System.out.println(this.sub.toString());
        System.out.println("学生列表：");
        System.out.println("姓名 性别 年龄");
        System.out.println(this.s1.toString());
        System.out.println(this.s2.toString());

    }
}
