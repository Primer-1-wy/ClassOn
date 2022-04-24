package week6;

import java.util.ArrayList;

public class Subject {
    private String Course_name;
    private double grade;
   // ArrayList<Student> studentArrayList = new ArrayList<Student>();

    //public ArrayList<Student> getStudentArrayList() {return studentArrayList;}
   // public void setStudentArrayList(ArrayList<Student> studentArrayList) {this.studentArrayList = studentArrayList;}
    public String getCourse_name() {return Course_name;}
    public void setCourse_name(String course_name) {Course_name = course_name;}
    public double getGrade() {return grade;}
    public void setGrade(double grade) {this.grade = grade;}

    public Subject(String course_name, double grade/*, ArrayList<Student> studentArrayList*/) {
        Course_name = course_name;
        this.grade = grade;
       // this.studentArrayList = studentArrayList;
    }
    public Subject() {}

}
