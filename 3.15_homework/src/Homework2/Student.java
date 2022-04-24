package Homework2;

import javax.xml.namespace.QName;

public class Student {
    public String name;
    public String gender;
    public int age;

    public Student() {}
    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public String getName() {return name;}
    public String getGender() {return gender;}
    public int getAge() {return age;}

    public void setName(String name) {this.name = name;}
    public void setGender(String gender) {this.gender = gender;}
    public void setAge(int age) {this.age = age;}

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age ;
    }
}
