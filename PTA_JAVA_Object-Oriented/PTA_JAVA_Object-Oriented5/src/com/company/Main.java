package com.company;
import java.util.Map.Entry;
import java.util.*;


/*距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000，格里高利历*/
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Time t1= new Time();
        Time t2= new Time(n);
        System.out.println("Hour: "+t2.GetHour()+" Minute: "+ t2.GetMinute()+" Second: "+t2.GetSecond());
        //System.out.println("Hour: "+t1.GetHour()+" Minute: "+ t1.GetMinute()+" Second: "+t1.GetSecond());
    }
}
class Time
{
    private int second;
    private int minute;
    private int hour;
    Time()//无参构造        对象是当前时间
    {
        Calendar  cal= Calendar.getInstance();//定义一个calendar对象
        hour= cal.get(Calendar.HOUR_OF_DAY);//获取现在的时间（hour）
        minute=cal.get(Calendar.MINUTE);//获取现在的时间（mintue）
        second=cal.get(Calendar.SECOND);//获取现在的时间（second）
    }

    Time(int n){//ms
        setTime(n);
    }
    Time(int Hour,int Minute,int Second)//有参构造
    {
        hour=Hour;
        minute=Minute;
        second=Second;
    }
    public void SetSecond(int Second)
    {
        second=Second;
    }
    public int GetSecond()
    {
        return second;
    }
    public void SetMinute(int Minute)
    {
        minute=Minute;
    }
    public int GetMinute()
    {
        return minute;
    }
    public void SetHour(int Hour)
    {
        hour=Hour;
    }
    public int GetHour()
    {
        return hour;
    }
    public void setTime(int elapseTime)//ms
    {
        elapseTime=elapseTime/1000;//化为s
        hour=elapseTime/3600%24;
        minute=elapseTime%3600/60;
        second=elapseTime%60;
    }


}
