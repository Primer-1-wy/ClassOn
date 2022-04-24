package com.company;
/*
3.创建一个 Java 程序，以输入 5 个学生成绩作为数字等级 （0-100）。如果输入的年级小于0或大于100，则要求重新进入该特定等级。您的程序是计算和显示班级平均成绩，
并在选择适当的菜单选项时显示最高和最低成绩
输入分数
班级平均
最高等级
最低等级
排序
退出
完成后增加校验功能。当用户不输入分数时，如果选择了其他函数，则会给出"请先输入分数再执行该函数"的提示，并返回主菜单
* */
import java.util.*;
public class Third {
    public static void main(String[] args) {
        LinkedList<Student> list = new LinkedList<Student>();
        Scanner sc = new Scanner(System.in);
        int flag = 0;//判断有无输入
        MainMenu();
        System.out.println("请输入你的选择");
        int choice = 0;
        choice = sc.nextInt();
        while (choice != 0) {
            if (choice != 1 && flag == 0) System.out.println("请先输入，在进行别的操作");
            else if (choice == 1) flag ++;
            else if(flag>1) System.out.println("你已经输入过了.(没写添加功能)");
            if (flag == 1) {
                switch (choice) {
                    case 1:
                        flag = 1;
                        Input(list);
                        break;
                    case 2:
                        System.out.println("average:" + Average(list));
                        break;
                    case 3:
                        System.out.println("Max:" + Max(list));
                        break;
                    case 4:
                        System.out.println("Min:" + Min(list));
                        break;
                    case 5:
                        Sort(list);
                        break;
                    case 6:
                        Print(list);
                        break;
                    default:
                        break;
                }
            }
            MainMenu();
            choice = sc.nextInt();
        }


    }

    public static void MainMenu() {
        System.out.println("1.Input");
        System.out.println("2.Average");
        System.out.println("3.Max");
        System.out.println("4.Min");
        System.out.println("5.Sort");
        System.out.println("6.Print");
        System.out.println("0.Exit");
    }

    static LinkedList Input(LinkedList<Student> list) {
        //addFirst()表头添加 addLast()表尾添加
        // 使用 removeFirst() 移除头部元素       // 使用 removeLast() 移除尾部元素
        // 使用 getFirst() 获取头部元素             // 使用 getLast() 获取尾部元素
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("请输入班级学生人数:");
        n = sc.nextInt();
       // Student stu = new Student();
        for (int i = 0; i < n; i++) {
            Student stu = new Student();
            System.out.println("请输入学生姓名");
            stu.setName(sc.next());
            System.out.println("请输入学生分数");
            stu.setScore(sc.nextDouble());
            list.add(stu);
        }
        return list;
    }

    static double Average(LinkedList<Student> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getScore();
        }
        return ((float) sum / list.size());
    }

    static double Max(LinkedList<Student> list) {
        double max = list.get(0).getScore();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getScore() > max) {
                max = list.get(i).getScore();
            }
        }
        return max;
    }

    static double Min(LinkedList<Student> list) {
        double min = list.get(0).getScore();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getScore() < min) {
                min = list.get(i).getScore();
            }
        }
        return min;
    }

    static void Sort(LinkedList<Student> list) {
        Collections.sort(list,new Comparator<Student>()
                {
                    public int compare(Student stu1, Student stu2)
                    {
                        return (int) (stu2.getScore()-stu1.getScore());
                    }
                }
        );
               // Collections.sort(li);
    Print(list);
    }

    static void Print(LinkedList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("学生姓名:"+list.get(i).getName()+" 学生成绩:"+list.get(i).getScore());
        }
    }
}



/*
public class StudentComparator implements Comparator<Student> {



    @Override

    public double compare(Student o1, Student o2 ) {

        return (o2 . getScore() -o1. getScore() ); ///?????
    }

}
*/