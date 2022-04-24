package Bank;
import java.util.Scanner;
public class DriverBank {
    static double  ServiceFee = 50;
    static double interestRate = 0.08;
    public static void main(String[] args) {
        Customer test=new Customer();
        Scanner sc = new Scanner(System.in);
        int create_flag = 0;//开户标记
        MainMenu();
        int choice = sc.nextInt();
        while (choice != 8) {
            if (choice != 1 && create_flag == 0) {
                System.out.println("Please create your account firstly~");
                MainMenu();
                choice = sc.nextInt();
                continue;
            }
            switch (choice) {
                case 1:
                    create_flag = 1;
                    Create(test);
                    break;
                case 2:
                    Save(test);
                    break;
                case 3:
                    Withdraw(test);
                    break;
                case 4:
                    Consume(test);
                    break;
                case 5:
                    Repay(test);
                    break;
                case 6:
                    Settle(test);
                    delay(3000);
                    break;
                case 7:
                    Balance(test);
                    delay(3000);
                    break;
            }
            MainMenu();
            choice = sc.nextInt();
        }

    }
        public static void MainMenu ()
        {
            delay(2000);
            System.out.println("****************************************");
            System.out.printf("1.Create  ");
            System.out.printf("2.Save    ");
            System.out.printf("3.Withdraw");
            System.out.printf("4.Consume ");
            System.out.println("");
            System.out.printf("5.Repay   ");
            System.out.printf("6.Settle  ");
            System.out.printf("7.Balance ");
            System.out.printf("8.Exit    ");
            System.out.println("");
            System.out.println("****************************************");
            System.out.println("Please enter your choice:");
        }

        public static void SonMenu()
        {
            delay(2000);
            System.out.println("************************************************************");
            System.out.printf("1.Checking_Account  ");
            System.out.printf("2.Saving_Account    ");
            System.out.printf("3.Return to MainMenu");
            System.out.println("");
            System.out.println("************************************************************");
            System.out.println("Please enter your choice:");
        }
        public static void Create (Customer test)
        {
            SonMenu();
            Scanner sc = new Scanner(System.in);
            int flag_Customer=0;//防止重复输入身份信息
            int flag_Saving=0;//只有一张存储卡
            int flag_Checking=0;//只有一张信用卡
            int choice1= sc.nextInt();
            while(choice1!=3) {
                if (flag_Customer == 0) {
                    System.out.println("Please enter your ssn:");
                    test.setSsn(sc.next());
                    System.out.println("Please enter your name:");
                    test.setName(sc.next());
                }
                flag_Customer=1;
                if (choice1 == 1) {
                    if(flag_Checking==1)
                    {
                        System.out.println("You have already had a Checking card!");
                        SonMenu();
                        choice1= sc.nextInt();
                        continue;
                    }
                    flag_Checking=1;
                    System.out.println("Please enter your Check_account number:");
                    test.getCheck_acconut().setAccountNum(sc.next());
                    System.out.println("Please enter your service fee:");
                    test.getCheck_acconut().setServiceCharge(sc.nextDouble());
                    test.getCheck_acconut().setBalance(0);
                    // test.setCheck_acconut(test.getCheck_acconut());
                    System.out.println("Successfully create a Checking card!");
                } else if (choice1 == 2) {
                    if(flag_Saving==1)
                    {
                        System.out.println("You have already had a Saving card!");
                        SonMenu();
                        choice1= sc.nextInt();
                        continue;
                    }
                    flag_Saving=1;
                    System.out.println("Please enter your Saving_acconut number:");
                    test.getSave_acconut().setAccountNum(sc.next());
                    System.out.println("Please entet your interestRate:");
                    test.getSave_acconut().setInterestRate(sc.nextDouble());
                    test.getSave_acconut().setBalance(0);
                    //    test.setSave_acconut(test.getSave_acconut());
                    System.out.println("Successfully create a Saving card!");

                }
                SonMenu();
                choice1= sc.nextInt();
            }

        }

    public static void Save(Customer test)
    {
        System.out.println("Please input the how much money you save:");
        Scanner sc =new Scanner(System.in);
        test.getSave_acconut().setBalance(test.getSave_acconut().getBalance()+ sc.nextDouble());
        System.out.println("Save successfully!");

    }
    public static void Withdraw(Customer test)
    {
        System.out.println("Please input the how much money you withdraw:");
        Scanner sc =new Scanner(System.in);
        test.getSave_acconut().setBalance(test.getSave_acconut().getBalance()- sc.nextDouble());
        System.out.println("Withdraw successfully!");

    }
    public static void Consume(Customer test)
    {
        System.out.println("Please input the how much money you consume:");
        Scanner sc =new Scanner(System.in);
        test.getCheck_acconut().setBalance(test.getCheck_acconut().getBalance()- sc.nextDouble());
        System.out.println("Consume successfully!");
    }
    public static void Repay(Customer test)
    {
        System.out.println("Please input the how much money you repay:");
        Scanner sc =new Scanner(System.in);
        test.getCheck_acconut().setBalance(test.getCheck_acconut().getBalance()+ sc.nextDouble());
        System.out.println("Repay successfully!");

    }
    public static void Settle(Customer test)
    {
        System.out.println("Start to settle:");
        test.getSave_acconut().payInterest();
        System.out.println(test.getSave_acconut().toString());
        test.getCheck_acconut().assessServiceCharge();
        System.out.println(test.getCheck_acconut().toString());
        System.out.println("Settle successfully!");

    }
    public static void Balance(Customer test)
    {
        System.out.println(test.toString());
        System.out.println("Balance successfully!");

    }

    public static void delay(int ms)//自己写的延时函数
    {
        System.out.println("Please wait "+ms+" ms~");
        try
        {
            Thread.sleep(ms);//单位：毫秒
        } catch (Exception e) {
        }
    }


}


