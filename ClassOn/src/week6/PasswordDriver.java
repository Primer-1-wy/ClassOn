package week6;
import java.util.Scanner;
public class PasswordDriver {
    public static void main(String []args)
    {
        int flag=0;
        MainMenu();
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
                MainMenu();
                password.setStr(sc.nextLine());
            }
        }
    }
    public static void MainMenu()
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
}
