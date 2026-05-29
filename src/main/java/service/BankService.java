package service;
import model.Account;
import java.util.ArrayList;

public class BankService {
    private ArrayList<Account> accounts;

    public BankService(){
        accounts=new ArrayList<>();

    }
    public void createAccount(int accNo,String name,double balance){
        Account newAccount=new Account(accNo,name,balance);
        accounts.add(newAccount);
        System.out.println("Account created successfully.");
    }
    public void viewAllAccounts(){
        if(accounts.isEmpty()){
            System.out.println("No accounts found.");
        }
        else{
            for(Account acc:accounts){
                acc.displayAccountInfo();
            }
        }
    }
    public Account findAccount(int accNo){
        for(Account acc: accounts){
            if(acc.getAccountNumber()==accNo){
                return acc;
            }
        }
        return null;
    }

    public void depositMoney(int accNo,double amount){
        Account acc=findAccount(accNo);
        if(acc==null){
            System.out.println("Account not found.");
        }
        else{
            acc.deposit(amount);
        }
    }
    public void withdrawMoney(int accNo,double amount){
        Account acc=findAccount(accNo);
        if(acc==null){
            System.out.println("Account not found.");
        }
        else{
            acc.withdraw(amount);
        }
    }
    public void transferMoney(int senderAccNo,int receiverAccNo,double amount){
        Account sender=findAccount(senderAccNo);
        Account receiver=findAccount(receiverAccNo);

        if(sender==null||receiver==null){
            System.out.println("Invalid Account number.");
        }
        else{
            boolean success=sender.withdraw(amount);
            if(success){
                receiver.deposit(amount);
                System.out.println("Money transferred successfully");
            }
        }
    }
    public void viewTransactions(int accNo){
        Account acc=findAccount(accNo);
        if(acc==null){
            System.out.println("Account not found");
        }
        else{
            acc.displayTransactions();
        }
    }
}
