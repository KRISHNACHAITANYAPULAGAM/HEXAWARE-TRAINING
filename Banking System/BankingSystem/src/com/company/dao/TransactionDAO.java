package com.company.dao;

import com.company.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    boolean addTransaction(Transaction transaction);
    List<Transaction> getTransactionsByAccount(int accountId);
    boolean updateTransaction(Transaction transaction);
    boolean deleteTransaction(int transactionId);
}
