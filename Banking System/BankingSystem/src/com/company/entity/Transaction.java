package com.company.entity;

public class Transaction {
    private int transactionId;
    private int accountId;
    private double amount;
    private String transactionDate;
    private String transactionType;

    public Transaction() {}

    // Constructor to include transactionId
    public Transaction(int transactionId, int accountId, double amount, String transactionDate, String transactionType) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               ", Account ID: " + accountId +
               ", Amount: " + amount +
               ", Date: " + transactionDate +
               ", Type: " + transactionType;
    }
}
