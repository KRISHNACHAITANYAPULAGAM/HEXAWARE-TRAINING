package com.company.dao;

import com.company.entity.Customer;

public interface CustomerDAO {
    boolean addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int customerId);
}
