package week6;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    public static void main(String[] agrs)
    {
        Scanner sc =new Scanner(System.in);
        MainMenu();
        int choice= sc.nextInt();
        while(choice!=4)
        {
            switch(choice)
            {
                case 1:Check();break;
                case 2:Express();break;
                case 3:Student();break;
            }
            MainMenu();
            choice= sc.nextInt();
        }

    }
    public static void MainMenu()
    {
        System.out.println("1.密码有效性");
        System.out.println("2.运算表达式");
        System.out.println("3.学生");
        System.out.println("4.退出");
    }
    public static void Check()
    {
        int flag=0;
        CheckMenu();
        Scanner sc=new Scanner(System.in);
        Password password = new Password(sc.nextLine());
        while(flag==0)
        {
            if (password.Check())
            {
                System.out.println("登录成功");
                System.out.println("你的密码是:"+password.getStr());
                flag = 1;
            }
            else
            {
                System.out.println("登录失败");
                System.out.println(password.getStr());
                System.out.println("请重新输入");
                CheckMenu();
                password.setStr(sc.nextLine());
            }
        }
    }
    public static void CheckMenu()
    {
        System.out.println("*******************************");
        System.out.println("注意，您的密码应该符合以下要求：");
        System.out.println("1.长度8-15");
        System.out.println("2.不能有空格");
        System.out.println("3.至少一个大写字母和一个小写字母");
        System.out.println("4.至少有一个数字");
        System.out.println("请输入您的密码：");
        System.out.println("*******************************");
    }
    public static void Student()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入学生信息");
        String temp_name;//保存临时课程名字
        double sum_grade=0;//保存临时课程总成绩
        //Student stu=new Student();
        ArrayList<Student> students = new ArrayList<Student>();
        //  ArrayList<Subject> subjects= new ArrayList<Subject>();
        String str;//保存输入
        str= sc.nextLine();
        String[] temp=str.split(",",3);//根据逗号分成三个
        System.out.println(temp[0]+temp[1]+temp[2]);
        while(str!="end")
        {
            Student stu=new Student();
            stu.setId(temp[0]);
            stu.setName(temp[1]);
            stu.setGender(temp[2]);
            students.add(stu);
            str= sc.nextLine();
            if(str.equals("end"))  break;
            temp=str.split(",");
        }
        System.out.println("请输入学生成绩：");
        str= sc.nextLine();
        temp=str.split(",");
        while(str!="end")
        {
            // System.out.println(students.size());
            for(int i=0;i< students.size();i++)
            {
                if(students.get(i).getId().equals(temp[0]))
                {
                    Subject temp_subj=new Subject();
                    temp_subj.setCourse_name(temp[1]);
                    temp_subj.setGrade(Double.parseDouble(temp[2]));//把字符串转换成double
                    students.get(i).getSubj().add(temp_subj);//把课程放到该学生类下面

                }
            }
            //for(int i=0;i<)
            str= sc.nextLine();
            if(str.equals("end"))  break;
            temp=str.split(",");
        }
        System.out.println("按学生统计：");
        //System.out.println("学号 "+"姓名 "+"性别 "+"平均分");
        System.out.printf("%2s %3s %2s %3s","学号","姓名","性别","平均分");
        System.out.println("");
        for(int i=0;i< students.size();i++)
        {
            System.out.print(students.get(i).toString());
            System.out.println();
        }

        System.out.println("按课程统计");
        for(int j=0;j< students.get(0).getSubj().size();j++)
        {
            temp_name= students.get(0).getSubj().get(j).getCourse_name();
            sum_grade=0;
            for(int i=0;i<students.size();i++)
            {
                for(int h=0;h<students.get(i).getSubj().size();h++)
                {
                    if(temp_name.equals(students.get(i).getSubj().get(h).getCourse_name()))
                    {
                        sum_grade=sum_grade+students.get(i).getSubj().get(h).getGrade();
                    }
                }
            }
            System.out.println("课程名:"+temp_name+" 平均成绩:"+sum_grade/students.get(0).getSubj().size());
        }

    }

    public static void Express()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入运算表达式：");
        Express expr = new Express(sc.nextLine());
        System.out.println(expr.Function());
    }


}


