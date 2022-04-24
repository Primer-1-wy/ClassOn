package week5;

import javax.xml.namespace.QName;

public class Student {
    public String id;
    public String gender;
    public int age;

    public Student() {}
    public Student(String name, String gender, int age) {
        this.id = name;
        this.gender = gender;
        this.age = age;
    }
    public String getID() {return id;}
    public String getGender() {return gender;}
    public int getAge() {return age;}

    public void setID(String ID) {this.id = ID;}
    public void setGender(String gender) {this.gender = gender;}
    public void setAge(int age) {this.age = age;}

    @Override
    public String toString() {
        return
                "name='" + id + '\'' +
                        ", gender='" + gender + '\'' +
                        ", age=" + age ;
    }
}
