package week6;
import java.util.Scanner;

public class Express {
    String str;

    public Express(String str) {this.str = str;}
    public Express() {}

    public String getStr() {return str;}
    public void setStr(String str) {this.str = str;}
    public double Function()
    {
        int pos1,pos2;//max(2,1) 存放 前括号和后括号的位置
        int pos3;//存放逗号位置
        double result=0;
        pos1=str.indexOf("(");
        pos2=str.indexOf(")");
        pos3=str.indexOf(",");
        String str1 = str.substring(0,pos1);//function
        String operator1= str.substring(pos1+1,pos3);
        String operator2= str.substring(pos3+1,pos2);
        switch(str1)
        {
            case "max": result=Math.max(Double.parseDouble(operator1),Double.parseDouble(operator2));break;
            case "min": result=Math.min(Double.parseDouble(operator1),Double.parseDouble(operator2));break;
            case "add": return Double.parseDouble(operator1)+Double.parseDouble(operator2);
            case "sub": return Double.parseDouble(operator1)-Double.parseDouble(operator2);
            default:result=0;
        }
        return result;
    }

}
