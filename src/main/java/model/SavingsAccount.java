package model;

import exception.InsufficientBalanceException;

public class SavingsAccount extends Account {

    private static final long serialVersionUID = 1L;
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }
    @Override
    public boolean withdraw(double amount) throws InsufficientBalanceException {

        if (getBalance() - amount < MIN_BALANCE) {
            throw new InsufficientBalanceException("Savings Account must maintain minimum balance of " + MIN_BALANCE);
        }

        return super.withdraw(amount);
    }
}