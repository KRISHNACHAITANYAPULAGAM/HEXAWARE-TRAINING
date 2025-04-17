package com.company.entity;

public class ZeroBalanceAccount extends Account {
    // Constructor for initialization
    public ZeroBalanceAccount(int accountId, int customerId, String accountType, long balance) {
        super(accountId, customerId, accountType, balance);
    }
}
