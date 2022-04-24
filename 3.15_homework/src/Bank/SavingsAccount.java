package Bank;

public class SavingsAccount extends BankAccount{
    private double interestRate;
    //setter and getter
    public double getInterestRate() {return interestRate;}
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}
    //Constructor
    public SavingsAccount(double interestRate) {this.interestRate = interestRate;}
    public SavingsAccount() {}
    //function
    public void payInterest() {setBalance(getBalance()*(interestRate+1));}
    //toString

    @Override
    public String toString() {
        return
                " interestRate=" + interestRate +
                ",accountNum="+ this.getAccountNum() +
                ",balance=" + this.getBalance()
                ;

    }
}
