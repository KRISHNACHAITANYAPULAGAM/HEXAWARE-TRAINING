package com.company.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountId, int customerId, String accountType, long balance, double interestRate) {
        super(accountId, customerId, accountType, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
