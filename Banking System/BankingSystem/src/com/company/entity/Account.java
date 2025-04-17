package com.company.entity;

public class Account {
    private int accountId;
    private int customerId;
    private String accountType;
    private long balance;

    // Constructor with parameters for initialization
    public Account(int accountId, int customerId, String accountType, long balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and setters for each attribute
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String toString() {
        return "Account ID: " + accountId +
               ", Customer ID: " + customerId +
               ", Account Type: " + accountType +
               ", Balance: " + balance;
    }

}
