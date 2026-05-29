import model.Account;
import service.BankService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankservice=new BankService();
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");

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

                    bankservice.createAccount(accNo,name,balance);
                    break;

                case 2:
                    bankservice.viewAllAccounts();
                    break;

                case 3:
                    System.out.println("Enter Account Number: ");
                    int depositAccNo=sc.nextInt();

                    System.out.println("Enter amount: ");
                    double depositAmount=sc.nextDouble();

                    bankservice.depositMoney(depositAccNo,depositAmount);
                    break;

                case 4:
                    System.out.println("Enter Account Number: ");
                    int withdrawAccountNo=sc.nextInt();
                    System.out.println("Enter Amount: ");
                    double withdrawAmount=sc.nextDouble();

                    bankservice.withdrawMoney(withdrawAccountNo,withdrawAmount);
                    break;

                case 5:
                    System.out.println("Enter Sender Account Number: ");
                    int senderAccNo=sc.nextInt();

                    System.out.println("Enter Receiver Account Number: ");
                    int receiverAccNo=sc.nextInt();

                    System.out.println("Enter Amount: ");
                    double transferAmount=sc.nextDouble();

                    bankservice.transferMoney(senderAccNo,receiverAccNo,transferAmount);
                    break;

                case 6:
                    System.out.println("Enter Account Number: ");
                    int transactionAccNo=sc.nextInt();
                    bankservice.viewTransactions(transactionAccNo);
                    break;

                case 7:
                    System.out.println("Thank you for using Banking System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
