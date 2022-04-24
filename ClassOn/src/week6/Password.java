package week6;
//8-15 w W 1
public class Password {
    String str;

    public Password() {}
    public Password(String str) {this.str = str;}

    public String getStr() {return str;}
    public void setStr(String str) {this.str = str;}

    public boolean Check()
    {
        boolean UpperFlag=false;
        boolean LowerFlag=false;
        boolean DigitFlag=false;
        boolean NumFlag=false;
        boolean SpaceFlag=true;

        System.out.println("Checking....");
        int len=str.length();
        int i;
        if(len>=8&&len<=13)
        {
            NumFlag=true;
        }
        char temp=' ';
        for(i=0;i<len;i++)
        {
           // temp=str.charAt(i);
            if(str.charAt(i)>='0'&&str.charAt(i)<='9')
            {
                DigitFlag=true;
            }
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
            {
                UpperFlag=true;
            }
            if(str.charAt(i)>='a'&&str.charAt(i)<='z')
            {
                LowerFlag=true;
            }
            if(str.charAt(i)==' ')
            {
                SpaceFlag=false;
            }
        }
        System.out.println("**"+UpperFlag+"**"+LowerFlag+"**"+SpaceFlag+"**"+NumFlag+"**"+DigitFlag);
        return UpperFlag&&LowerFlag&&SpaceFlag&&NumFlag&&DigitFlag;
    }
}
