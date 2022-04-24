package com.company;
import java.util.Scanner;
public class Refactoring {
    public static void main(String[] args){
        int choice = 0;
       // int count1=0;
       // int count2=1;
        Scanner input = new Scanner(System.in);

        int type= input.nextInt();
        if(type!=1&&type!=2)
        {System.out.println("Wrong Format");
            System.exit(0);
        }
        //int dia_n=0;
       // int lev_n=0;
        Lever lever = new Lever(1);
        Dial dial = new Dial(1);
        Brush brush = new Brush(0);
        Agent agent = new Agent(lever,dial,brush);
        if(type==1)
        {
          //  dia_n=3;
           // lev_n=4;
            dial.setN(3);//刻度1-3
            lever.setN(4);//停止，间歇，低速，高速四种
        }
        else
        {
            //dia_n=5;
           // lev_n=5;
            dial.setN(5);//刻度1-5
            lever.setN( 5);//停止，间歇，低速，高速，超高五种
        }
        choice = input.nextInt();
        while(choice != 0){
            switch(choice){
                case 1://Lever up
                    //if(count1<lev_n-1) count1++;
                    System.out.print("Lever up/");
                    agent.getLever().leverUp();
                    break;
                case 2://Lever down
                   // if(count1>0) count1--;
                    System.out.print("Lever down/");
                    agent.getLever().leverDown();
                    break;
                case 3://Dial up
                   // if(count2<dia_n)count2++;
                    System.out.print("Dial up/");
                    agent.getDial().dialUp();
                    break;
                case 4://Dial down
                   // if(count2>0) count2--;
                    System.out.print("Dial down/");
                    agent.getDial().dialDown();
                    break;
                case 0://Terminate
                    System.exit(0);
            }
            agent.dealSpeed();//Get brush’s speed
            switch(lever.getPos()-1)
            {
                case 0: System.out.print("停止/");break;
                case 1: System.out.print("间歇/");break;
                case 2: System.out.print("低速/");break;
                case 3: System.out.print("高速/");break;
                case 4:System.out.print("超高速/");break;
                default:break;
            }
            switch(dial.getPos())
            {
               // case 0: System.out.print("0/");break;
                case 1: System.out.print("1/");break;
                case 2: System.out.print("2/");break;
                case 3: System.out.print("3/");break;
                case 4: System.out.print("4/");break;
                case 5: System.out.print("5/");break;

                default:break;
            }
            System.out.println(agent.getBrush().getSpeed());
            choice = input.nextInt();
        }
    }
}


class Lever {
    private int pos;//档位
    int n;//档位个数
    public Lever() {
    }
    public void setN(int N){n=N;}
    public Lever(int pos) {this.pos = pos;}

    public int getPos() {
        return pos;
    }

    //升档
    public void leverUp() {
        if (this.pos < n) {
            this.pos++;
        }
    }

    //降档
    public void leverDown() {
        if (this.pos > 1)
            this.pos--;
    }
}


class Dial {
    private int pos;//刻度
    int n;//档位个数
    public Dial() {}
    public void setN(int N){n=N;}
    public Dial(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    //升刻度
    public void dialUp() {
        if (this.pos < n)
            this.pos++;
    }

    //降刻度
    public void dialDown() {
        if (this.pos > 1)
            this.pos--;
    }
}


class Brush {
    private int speed;
    public Brush(){}
    public Brush(int speed){this.speed = speed;}
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}
}

//为了减小实体类耦合性，采用中介模式，设计Agent代理类
class Agent {
    //聚合型类设计
    private Lever lever;
    private Dial dial;
    private Brush brush;
    public Agent(){}
    public Agent(Lever lever,Dial dial,Brush brush){
        this.lever = lever;
        this.dial = dial;
        this.brush = brush;
    }
    public Lever getLever() {return lever;}
    public void setLever(Lever lever) {this.lever = lever;}
    public Dial getDial() {return dial;}
    public void setDial(Dial dial) {this.dial = dial;}
    public Brush getBrush() {return brush;}
    public void setBrush(Brush brush) {this.brush = brush;}
    //主要业务逻辑：根据控制杆档位、刻度盘刻度计算雨刷摆动速度
    public void dealSpeed(){
        int speed = 0;
        switch(this.lever.getPos()){
            case 1://停止
                speed = 0;break;
            case 2://间歇
                switch(this.dial.getPos()){
                    case 1://刻度1
                        speed = 4;break;
                    case 2://刻度2
                        speed = 6;break;
                    case 3://刻度3
                        speed = 12;break;
                    case 4://刻度4
                        speed = 15;break;
                    case 5://刻度5
                        speed = 20;break;
                }
                break;
            case 3://低速
                speed = 30;break;
            case 4://高速
                speed = 60;break;
            case 5://超高速
                speed=90;break;
        }
        this.brush.setSpeed(speed);
    }
}