//in this program we are  going to implement ATM interface for simple banking system

import java.util.Scanner;

interface ATM{
    void checkBalance(double amount);//to check account balance
    double makeDeposit(double amount, double initialBalance);//to make deposit to the account
    double makeWithdraw(double amountToWithdraw, double initialBalance);// to make withdraw from account balance
}


class ATM1 implements ATM{
    @Override
    public void checkBalance(double initialBalance) {
        System.out.println("Your current balance is: $"+initialBalance);
    }

//make deposite
    public double makeDeposit(double amount, double initialBalance) {
        initialBalance = initialBalance + amount;
        System.out.println("Your deposit was Successfully");
        return initialBalance;
    }

//make withdraw 
    public double makeWithdraw(double amountToWithdraw, double initialBalance) {
        if(initialBalance >= amountToWithdraw){
            initialBalance = initialBalance - amountToWithdraw;
            System.out.println("Your withdraw was Successfully");
        }
        else{
            System.out.println("Insufficient Balance");
        }
        return initialBalance;
    }
}

// user account balance and main method
public class Task3Codsoft {
    static double balance = 1000.0;//initial account balance
    public static void main(String[] args) {
        ATM1 atm1 = new ATM1();
        Scanner console = new Scanner(System.in);
        System.out.println("\n______________Welcome to PMP Simple banking System_____________\n");
        while(true) {
            System.out.println("Please select your choice from the following options:");
            System.out.println("\t1. Check Balance");
            System.out.println("\t2. Make Deposit");
            System.out.println("\t3. Make Withdraw");
            System.out.println("\t4. Exit");
            System.out.print("Enter your choice : ");
            String choice = console.nextLine();
            if (isDigit(choice) && isInTheRange(choice)) {
                switch (Integer.parseInt(choice)) {
                    case 1:
                        atm1.checkBalance(balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        String amount = console.nextLine();
                        if (isDigit(amount)) {//check the input is it is digit proceed
                            balance =  atm1.makeDeposit(Double.parseDouble(amount), balance);
                        } else {
                            System.out.println("Your input is invalid!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        String amountWithdraw = console.nextLine();
                        if (isDigit(amountWithdraw)) {//check the input is it is digit proceed
                            balance = atm1.makeWithdraw(Double.parseDouble(amountWithdraw), balance);
                        } else {
                            System.out.println("Your input is invalid!");
                        }
                        break;
                    case 4:
                        System.out.println("See you soon!");
                        System.exit(0);
                }

            }else
                System.out.println("Invalid Choice");
            System.out.println();
        }
    }
    public static boolean isInTheRange(String choice){
        if(isDigit(choice)){
            if(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 4){
                return true;
            }
            else{
                System.out.println("Your choice is out of the given option range!");
            }
        }
        return false;
    }

    public static boolean isDigit(String amount){
        for(int i = 0; i<amount.length(); i++){
            if(!Character.isDigit(amount.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
