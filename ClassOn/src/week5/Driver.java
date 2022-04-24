package week5;
import java.util.Scanner;
public class Driver {
    public static void main(String []args) {
        StudentList list = new StudentList(20);
        Subject sub=new Subject();
        int flag=0;//防止崩溃
        Scanner sc=new Scanner(System.in);
        MainMenu();
        int choice= sc.nextInt();

        while(choice!=5)
        {

            if(choice!=1&&flag==0)
            {
                System.out.println("请先创建课程");
                MainMenu();
                choice= sc.nextInt();
                continue;
            }

            switch(choice)
            {
                case 1 :flag=1;
                        sub=Create(sub);
                        break;
                case 2 :if(Add(list)) System.out.println("Successfully");
                        else System.out.println("Failed");
                        break;
                case 3 :if(Delete(list)) System.out.println("Successfully");
                        else System.out.println("Failed");
                        break;
                case 4 :
                    System.out.println(sub.toString());
                    System.out.println(list.toString());
                    break;
            }
            MainMenu();
            choice= sc.nextInt();
        }

    }



    public static void MainMenu()
    {
        delay(2000);
        System.out.println("学生选课系统");
        System.out.println("**************************");
        System.out.println("1.创建课程");
        System.out.println("2.选课");
        System.out.println("3.退选");
        System.out.println("4.输出");
        System.out.println("5.退出");
        System.out.println("请选择（1---5）");
        System.out.println("**************************");
    }
    public static void delay(int ms)//自己写的延时函数
    {
        try
        {
            Thread.sleep(ms);//单位：毫秒
        } catch (Exception e) {
        }
    }
    public static boolean Add(StudentList test)
    {
        Scanner sc=new Scanner(System.in);
        Student temp = new Student();
        System.out.println("请输入学号");
        temp.setID(sc.next());
        System.out.println("请输入年龄");
        temp.setAge(sc.nextInt());
        System.out.println("请输入性别");
        temp.setGender(sc.next());
        return test.add(temp);

    }
    public static boolean Delete(StudentList test) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入退选学生ID：");
        return test.remove(test.indexOf(sc.nextLine()));

    }
    public static Subject Create(Subject sub)
    {
        sub=new Subject();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        sub.setYear(sc.next());
        System.out.println("请输入学年");
        sub.setStuYear(sc.next());
        System.out.println("请输入课程号");
        sub.setSubjectID(sc.next());
        System.out.println("请输入课程名");
        sub.setSubjectName(sc.next());

        return sub;
    }
}
