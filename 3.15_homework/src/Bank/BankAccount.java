package Bank;

public class BankAccount {
    private String accountNum;//账户号
    private double balance;//余额
    //getter and setter
    public String getAccountNum() {return accountNum;}
    public void setAccountNum(String accountNum) {this.accountNum = accountNum;}
    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}

    public BankAccount(String accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }
    public BankAccount() {}
/*
    @Override
    public String toString() {
        return  "accountNum='" + accountNum + '\'' + ", balance=" + balance ;
    }
*/
}
