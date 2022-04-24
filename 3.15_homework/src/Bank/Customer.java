package Bank;

public class Customer {
    private String ssn;
    private String name;
    private CheckingAccount check_acconut=new CheckingAccount();
    private SavingsAccount save_acconut=new SavingsAccount();
    //Constructor
    public Customer(String ssn, String name, CheckingAccount check_acconut, SavingsAccount save_acconut) {
        this.ssn = ssn;
        this.name = name;
        this.check_acconut = check_acconut;
        this.save_acconut = save_acconut;
    }
    public Customer() {}
    //getter and setter
    public String getSsn() {return ssn;}
    public void setSsn(String ssn) {this.ssn = ssn;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public CheckingAccount getCheck_acconut() {return check_acconut;}
    public void setCheck_acconut(CheckingAccount check_acconut) {this.check_acconut = check_acconut;}
    public SavingsAccount getSave_acconut() {return save_acconut;}
    public void setSave_acconut(SavingsAccount save_acconut) {this.save_acconut = save_acconut;}
    //toString

    @Override
    public String toString() {
        return
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +" \n"+
                "check_acconut:" + check_acconut +" \n"+
                "save_acconut:" + save_acconut ;
    }
}
