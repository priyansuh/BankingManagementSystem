import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts=new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");

            System.out.println("\nEnter your choice: ");
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter Account Number: ");
                    int accNo=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Account Holder Name: ");
                    String name=sc.nextLine();

                    System.out.println("Enter Initial Balance: ");
                    double balance=sc.nextDouble();

                    Account newAccount=new Account(accNo,name,balance);
                    accounts.add(newAccount);

                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    if(accounts.isEmpty()){
                        System.out.println("No accounts found.");
                    }else{
                        for(Account acc:accounts){
                            acc.displayAccountInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Account Number: ");
                    int depositAccNo=sc.nextInt();

                    Account depositAccount=null;

                    for(Account acc: accounts){
                        if(acc.getAccountNumber()==depositAccNo){
                            depositAccount=acc;
                            break;
                        }
                    }
                    if(depositAccount==null){
                        System.out.println("Account not found.");
                    }
                    else{
                        System.out.println("Enter amount to deposit: ");
                        double amount=sc.nextDouble();
                        depositAccount.deposit(amount);
                    }
                    break;

                case 4:
                    System.out.println("Enter Account Number: ");
                    int withdrawAccountNo=sc.nextInt();
                    Account withdrawAccount=null;

                    for(Account acc: accounts){
                        if(acc.getAccountNumber()==withdrawAccountNo){
                            withdrawAccount=acc;
                            break;
                        }
                    }
                    if(withdrawAccount==null){
                        System.out.println("Account not found.");
                    }
                    else{
                        System.out.println("Enter amount to withdraw: ");
                        double amount=sc.nextDouble();
                        withdrawAccount.withdraw(amount);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Banking System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
