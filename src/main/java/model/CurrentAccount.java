package model;

import exception.InsufficientBalanceException;

public class CurrentAccount extends Account {

    private static final long serialVersionUID = 1L;
    private static final double OVERDRAFT_LIMIT = 2000;

    public CurrentAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }
    @Override
    public boolean withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        if (getBalance() - amount < -OVERDRAFT_LIMIT) {
            throw new InsufficientBalanceException("Overdraft limit exceeded.");
        }
        double newBalance = getBalance() - amount;
        setBalance(newBalance);
        addTransaction("Withdraw", amount);
        System.out.println(amount + " withdrawn successfully.");
        return true;
    }

}