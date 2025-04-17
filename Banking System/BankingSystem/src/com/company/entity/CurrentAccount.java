package com.company.entity;

public class CurrentAccount extends Account {
    private double overdraftLimit;


    public CurrentAccount(int accountId, int customerId, String accountType, long balance, double overdraftLimit) {
        super(accountId, customerId, accountType, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
