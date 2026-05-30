package service;

import model.Account;

import java.util.ArrayList;

import model.CurrentAccount;
import model.SavingsAccount;
import util.FileManager;

import exception.InsufficientBalanceException;
import exception.AccountNotFoundException;

public class BankService {
    private ArrayList<Account> accounts;

    public BankService() {
        accounts = FileManager.loadAccounts();

    }

    public void createAccount(int accNo, String name, double balance, int accountType) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                System.out.println("Account number already exists.");
                return;
            }
        }
        Account newAccount;
        if (accountType == 1) {
            newAccount = new SavingsAccount(accNo, name, balance);
        } else {
            newAccount = new CurrentAccount(accNo, name, balance);
        }
        accounts.add(newAccount);
        FileManager.saveAccounts(accounts);
        System.out.println("Account created successfully.");
    }

    public void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account acc : accounts) {
                acc.displayAccountInfo();
            }
        }
    }

    public Account findAccount(int accNo) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        throw new AccountNotFoundException("Account " + accNo + " not found.");
    }

    public void depositMoney(int accNo, double amount) {
        try {
            Account acc = findAccount(accNo);
            acc.deposit(amount);
            FileManager.saveAccounts(accounts);
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawMoney(int accNo, double amount) {
        try {
            Account acc = findAccount(accNo);
            acc.withdraw(amount);
            FileManager.saveAccounts(accounts);

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void transferMoney(int senderAccNo, int receiverAccNo, double amount) {
        try {
            Account sender = findAccount(senderAccNo);
            Account receiver = findAccount(receiverAccNo);
            boolean success = sender.withdraw(amount);
            if (success) {
                receiver.deposit(amount);
                FileManager.saveAccounts(accounts);
                System.out.println("Money transferred successfully");
            }
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewTransactions(int accNo) {
        try {

            Account acc = findAccount(accNo);
            acc.displayTransactions();
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }
}
