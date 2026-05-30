package model;
import java.util.ArrayList;
import exception.InsufficientBalanceException;

public class Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    //structure (private so that other classes cannot directly modify balance)
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, String accountHolderName, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        transactions=new ArrayList<>();
    }
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Invalid amount.");
            return;
        }
        balance+=amount;
        transactions.add(new Transaction("Deposit",amount));
        System.out.println(amount+" deposited successfully.");
    }

    public boolean withdraw(double amount) throws InsufficientBalanceException{
        if(amount<=0){
            System.out.println("Invalid amount.");
            return false;
        }
        if(amount>balance){
            throw new InsufficientBalanceException("Insufficient balance !");
        }
        balance-=amount;
        transactions.add(new Transaction("withdraw",amount));
        System.out.println(amount+" withdrawn successfully.");
        return true;
    }

    public void displayTransactions(){
        System.out.println("\n===== TRANSACTION HISTORY =====");
        if(transactions.isEmpty()){
            System.out.println("No transactions found.");
        }else{
            for(Transaction t:transactions){
                t.displayTransaction();
            }
        }
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
    protected void setBalance(double balance){
        this.balance=balance;
    }
    protected void addTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }

}