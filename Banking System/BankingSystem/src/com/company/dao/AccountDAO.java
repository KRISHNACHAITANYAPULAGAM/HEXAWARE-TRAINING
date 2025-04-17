package com.company.dao;

import com.company.entity.Account;

import java.util.List;

public interface AccountDAO {
    boolean addAccount(Account account);
    Account getAccountById(int accountId);
    boolean updateAccount(Account account);
    boolean deleteAccount(int accountId);
    List<Account> getAllAccounts();
}
