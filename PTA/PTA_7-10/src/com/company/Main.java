package com.company;
import java.util.Scanner;


public class Main{
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
       // int IfAngel=0;
        int IfData=0;
        int i,j;//循环变量
        int radix=0;
        int d[][]=new int[20][20];
        if(sc.hasNextInt())//输入行
            m=sc.nextInt();
        else
            IfData=1;
        if(sc.hasNextInt())//输入列
            n=sc.nextInt();
        else
            IfData=1;


        if(sc.hasNextInt())//输入转角
        {
            radix=sc.nextInt();
            if(radix!=90&&radix!=180&&radix!=-90)//只要有角度错误就直接输出然后结束
                System.out.println("angle data error");
            else//继续输入每个像素点
            {
                for(i=0;i<m;i++)
                    for(j=0;j<n;j++)
                    {
                        if(sc.hasNextInt())
                            d[i][j]=sc.nextInt();
                        else
                            IfData=1;
                        if(!(d[i][j]>=0&&d[i][j]<=255))
                            System.out.println("matrix data error");
                    }
                if(IfData==1)
                    System.out.println("data type error");
                else
                /*  按不同方法打印就行 不用搞新数组   */
                    Print(d,radix);
            }
        }
        else
        {
            System.out.println("angle data error");
        }
    }
    public static void Print(int [][]image,int radix)
    {
        switch(radix) {
            case 90:
                Print90(image);
                break;
            case -90:
                Print_90(image);
                break;
            case 180:
                Print180(image);
                break;
        }
    }
    public static void Print90(int [][]image)//90
/*向左转就是 ：第一行打印原来的第三列
第二行打印原来的第二列
0 2、 1 2、 2 2 ||| 0 0、 0 1、 0 2
0 1 、1 1、 2 1 ||| 1 0、 1 1、 1 2
0 0、 1 0、 2 0 ||| 2 0、 2 1、 2 2
*/
    {
        int i,j;
       // System.out.println("m:"+m+";"+"n:"+n);
        for(i=n-1;i>=0;i--)
        {
            for(j=0;j<m;j++)
            {
                if(j==0)
                    System.out.print(image[j][i]);
                else
                    System.out.print(" "+image[j][i]);
            }
            System.out.print("\n");
        }
    }
    public static void Print_90(int [][]image)//-90
/*向右旋转：左改变后，右原矩阵 发现坐标一个规律：
第一行是原第一列 第二行是原第二列.. 然后就这样打印出来就行了
第一行打印原来第一列（倒着打印列从最后一个打印到第一个）
tips：千万不要被i和j所拘泥住 i和j只是循环变量 帮助你来打印的！i，j都可以任意作为横纵坐标！
2 0、 1 0、 0 0 ||| 0 0、 0 1、 0 2
2 1 、1 1、 0 1 ||| 1 0、 1 1、 1 2
2 2、 1 2、 0 2 ||| 2 0、 2 1、 2 2
 */
    {
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=m-1;j>=0;j--)
            {
                if(j==m-1)
                    System.out.print(image[j][i]);
                else
                    System.out.print(" "+image[j][i]);
            }
            System.out.print("\n");
        }
    }
    public static void Print180(int [][]image)
/*
转180：第一行打印原来的第三列（倒着打印）。。。。
2 2、 2 1、 2 0 ||| 0 0、 0 1、 0 2
1 2 、1 1、 1 0 ||| 1 0、 1 1、 1 2
0 2、 0 1、 0 0 ||| 2 0、 2 1、 2 2

* */
    {
        int i,j;
        for(i=m-1;i>=0;i--)
        {
            for(j=n-1;j>=0;j--)
            {
                if(j==n-1)
                    System.out.print(image[i][j]);
                else
                    System.out.print(" "+image[i][j]);
            }
            System.out.print("\n");
        }
    }

}

/*


        输入：
        3 4
        1 2 3 4
        5 6 7 8
        9 10 11 12

        输出：
        9 5 1
        10 6 2
        11 7 3
        12 8 4

        旋转后原坐标： 旋转前坐标：
2 0、 1 0、 0 0 ||| 0 0、 0 1、 0 2
2 1 、1 1、 0 1 ||| 1 0、 1 1、 1 2
2 2、 1 2、 0 2 ||| 2 0、 2 1、 2 2


*/