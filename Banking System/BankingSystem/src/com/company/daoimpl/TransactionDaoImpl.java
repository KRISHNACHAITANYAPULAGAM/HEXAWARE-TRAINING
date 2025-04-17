package com.company.daoimpl;

import com.company.dao.TransactionDAO;
import com.company.entity.Transaction;
import com.company.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDAO {

    @Override
    public boolean addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (account_Id, amount, transaction_Date, transaction_Type) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, transaction.getAccountId());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setString(3, transaction.getTransactionDate());
            preparedStatement.setString(4, transaction.getTransactionType());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Transaction> getTransactionsByAccount(int accountId) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE account_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Transaction transaction = new Transaction(
                        resultSet.getInt("transaction_Id"),
                        resultSet.getInt("account_Id"), 
                        resultSet.getDouble("amount"),
                        resultSet.getString("transaction_Date"), 
                        resultSet.getString("transaction_Type") 
                );

                transactions.add(transaction);
            }
        } catch (SQLException e) {
            // Log the exception with a clear error message
            System.err.println("Error retrieving transactions by account ID: " + accountId);
            e.printStackTrace();
        }
        return transactions;
    }


    @Override
    public boolean updateTransaction(Transaction transaction) {
        String query = "UPDATE transactions SET amount = ?, transaction_Date = ?, transaction_Type = ? WHERE transaction_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, transaction.getAmount());
            preparedStatement.setString(2, transaction.getTransactionDate());
            preparedStatement.setString(3, transaction.getTransactionType());
            preparedStatement.setInt(4, transaction.getTransactionId()); // Using transactionId here
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTransaction(int transactionId) {
        String query = "DELETE FROM transactions WHERE transaction_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, transactionId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
