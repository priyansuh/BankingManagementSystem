package model;

public class Account {

    //structure (private so that other classes cannot directly modify balance)
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Invalid amount.");
            return;
        }
        balance+=amount;
        System.out.println(amount+" deposited successfully.");
    }

    public void withdraw(double amount){
        if(amount<=0){
            System.out.println("Invalid amount.");
            return;
        }
        if(amount>balance){
            System.out.println("Insufficient balance ! Try again.");
        }
        balance-=amount;
        System.out.println(amount+" withdrawn successfully.");
    }

    public void displayAccountInfo(){
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Account Holder : "+accountHolderName);
        System.out.println("Balance        : "+balance);
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

}