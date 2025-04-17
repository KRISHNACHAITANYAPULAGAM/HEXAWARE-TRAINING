package com.company.daoimpl;

import com.company.dao.AccountDAO;
import com.company.entity.Account;
import com.company.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDAO {

    // Add an Account
    @Override
    public boolean addAccount(Account account) {
        String query = "INSERT INTO accounts (customer_Id, account_Type, balance) VALUES (?, ?, ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, account.getCustomerId());
            preparedStatement.setString(2, account.getAccountType());
            preparedStatement.setLong(3, account.getBalance());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get Account by ID
    @Override
    public Account getAccountById(int accountId) {
        String query = "SELECT * FROM accounts WHERE account_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Account(
                        resultSet.getInt("account_Id"),
                        resultSet.getInt("customer_Id"),
                        resultSet.getString("account_Type"),
                        resultSet.getLong("balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update Account
    @Override
    public boolean updateAccount(Account account) {
        String query = "UPDATE accounts SET account_Type = ?, balance = ? WHERE account_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getAccountType());
            preparedStatement.setLong(2, account.getBalance());
            preparedStatement.setInt(3, account.getAccountId());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Account
    @Override
    public boolean deleteAccount(int accountId) {
        String query = "DELETE FROM accounts WHERE account_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all Accounts
    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts";
        try (Connection connection = DBUtil.getDBConn();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                accounts.add(new Account(
                        resultSet.getInt("account_Id"),
                        resultSet.getInt("customer_Id"),
                        resultSet.getString("account_Type"),
                        resultSet.getLong("balance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
