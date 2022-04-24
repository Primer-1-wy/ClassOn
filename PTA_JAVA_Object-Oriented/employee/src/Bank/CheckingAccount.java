package Bank;

public class CheckingAccount extends BankAccount{
    private double serviceCharge;
    //constructor
    public CheckingAccount(String accountNum, double balance, double serviceCharge) {
        super(accountNum, balance);
        this.serviceCharge = serviceCharge;
    }
    public CheckingAccount() {}

    //getter and setter
    public double getServiceCharge() {return serviceCharge;}
    public void setServiceCharge(double serviceCharge) {this.serviceCharge = serviceCharge;}
    //function
    public void assessServiceCharge() {setBalance(getBalance()-serviceCharge);}
    //toString

    @Override
    public String toString() {
        return
                " serviceCharge=" + serviceCharge +
                ",accountNum="+ this.getAccountNum() +
                ",balance=" + this.getBalance()
                ;

    }
}
