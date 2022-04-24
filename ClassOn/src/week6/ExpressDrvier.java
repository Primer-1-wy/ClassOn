package week6;
import java.util.Scanner;
public class ExpressDrvier {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入运算表达式：");
        Express expr = new Express(sc.nextLine());
        System.out.println(expr.Function());
    }

}
