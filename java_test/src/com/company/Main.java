package com.company;
/*
这篇test用来研究exception的用法
*/
public class Main {

    public static void main(String[] args) {
	// write your code here
        String []str={"123","255","456"};
        int sum=0;
        int flag=0;
        int temp=Integer.valueOf(str[1]);//Integer.valueof()无法对非数字字符串进行转化，对数字字符串转化也只能在-127-127之间
        for(int i=0;i<3;i++)
        {
            //System.out.println(a[i]);

           // System.out.println(Integer.valueOf(str[i]));
            /*
            try
            {
                sum=sum+Integer.valueOf(str[i]);
            }
            catch(Exception b)
            {
                flag=1;
                continue;
            }
            */
        }
        System.out.println(temp);
    }
}
