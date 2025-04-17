package com.company.daoimpl;

import com.company.dao.CustomerDAO;
import com.company.entity.Customer;
import com.company.util.DBUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDAO {

    // Add a Customer
    @Override
    public boolean addCustomer(Customer customer) {
        String query = "INSERT INTO customers (first_Name, last_Name, dob, email, phone_Number, address, joiningDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getDob());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setLong(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setString(7, customer.getJoiningDate());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get Customer by ID
    @Override
    public Customer getCustomerById(int customerId) {
        String query = "SELECT * FROM customers WHERE customer_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Customer(
                        resultSet.getInt("customer_Id"),
                        resultSet.getString("first_Name"),
                        resultSet.getString("last_Name"),
                        resultSet.getString("dob"),
                        resultSet.getString("email"),
                        resultSet.getLong("phone_Number"),
                        resultSet.getString("address"),
                        resultSet.getString("joiningDate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update Customer
    @Override
    public boolean updateCustomer(Customer customer) {
        String query = "UPDATE customers SET first_Name = ?, last_Name = ?, email = ?, phone_Number = ?, address = ? WHERE customer_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setLong(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getCustomerId());
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Customer
    @Override
    public boolean deleteCustomer(int customerId) {
        String query = "DELETE FROM customers WHERE customer_Id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
