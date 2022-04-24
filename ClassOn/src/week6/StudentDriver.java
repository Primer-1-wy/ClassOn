package week6;
import java.util.*;
public class StudentDriver {
    public static void main(String [] args)
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
}
