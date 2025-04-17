package com.company.main;

import com.company.daoimpl.AccountDaoImpl;
import com.company.daoimpl.CustomerDaoImpl;
import com.company.daoimpl.TransactionDaoImpl;
import com.company.entity.Account;
import com.company.entity.Customer;
import com.company.entity.Transaction;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        AccountDaoImpl accountDao = new AccountDaoImpl();
        TransactionDaoImpl transactionDao = new TransactionDaoImpl();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n========== HM BANK SYSTEM ==========");
            System.out.println("1. Customer Management");
            System.out.println("2. Account Management");
            System.out.println("3. Transaction Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (mainChoice) {
                case 1:
                    // Customer Management
                    System.out.println("\n--- CUSTOMER MENU ---");
                    System.out.println("1. Add Customer");
                    System.out.println("2. Get Customer by ID");
                    System.out.println("3. Update Customer");
                    System.out.println("4. Delete Customer");
                    System.out.print("Enter your choice: ");
                    int custChoice = sc.nextInt();
                    sc.nextLine();
                    switch (custChoice) {
                        case 1:
                            // Input for new customer
                            System.out.print("Enter Customer ID: ");
                            int customerId = sc.nextInt();
                            sc.nextLine(); // consume newline
                            System.out.print("Enter First Name: ");
                            String firstName = sc.nextLine();
                            System.out.print("Enter Last Name: ");
                            String lastName = sc.nextLine();
                            System.out.print("Enter DOB: ");
                            String dob = sc.nextLine();
                            System.out.print("Enter Email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter Phone Number: ");
                            long phone = sc.nextLong();
                            sc.nextLine();
                            System.out.print("Enter Address: ");
                            String address = sc.nextLine();
                            System.out.print("Enter Joining Date: ");
                            String joiningDate = sc.nextLine();

                            // Create Customer object using parameterized constructor
                            Customer newCustomer = new Customer(customerId, firstName, lastName, dob, email, phone, address, joiningDate);
                            customerDao.addCustomer(newCustomer);
                            break;

                        case 2:
                            System.out.print("Enter Customer ID: ");
                            int cid = sc.nextInt();
                            Customer cust = customerDao.getCustomerById(cid);
                            System.out.println(cust != null ? cust : "Customer not found.");
                            break;

                        case 3:
                        	System.out.print("Enter Customer ID to update: ");
                        	int updateCustId = sc.nextInt();
                        	sc.nextLine();
                        	System.out.print("First Name: ");
                        	String updFName = sc.nextLine();
                        	System.out.print("Last Name: ");
                        	String updLName = sc.nextLine();
                        	System.out.print("DOB: ");
                        	String updDOB = sc.nextLine();
                        	System.out.print("Email: ");
                        	String updEmail = sc.nextLine();
                        	System.out.print("Phone: ");
                        	long updPhone = sc.nextLong();
                        	sc.nextLine();
                        	System.out.print("Address: ");
                        	String updAddr = sc.nextLine();
                        	System.out.print("Joining Date: ");
                        	String updJoin = sc.nextLine();

                        	Customer updateCust = new Customer(updateCustId, updFName, updLName, updDOB, updEmail, updPhone, updAddr, updJoin);
                        	System.out.println(customerDao.updateCustomer(updateCust) ? "Customer updated!" : "Update failed.");
                        	break;

                        case 4:
                            System.out.print("Enter Customer ID to delete: ");
                            int delId = sc.nextInt();
                            System.out.println(customerDao.deleteCustomer(delId) ? "Customer deleted!" : "Deletion failed.");
                            break;

                        default:
                            System.out.println("Invalid customer choice.");
                    }
                    break;

                case 2:
                    // Account Management
                    System.out.println("\n--- ACCOUNT MENU ---");
                    System.out.println("1. Add Account");
                    System.out.println("2. Get Account by ID");
                    System.out.println("3. Update Account");
                    System.out.println("4. Delete Account");
                    System.out.println("5. View All Accounts");
                    System.out.print("Enter your choice: ");
                    int accChoice = sc.nextInt();
                    sc.nextLine();

                    switch (accChoice) {
                        case 1:
                        	 System.out.print("Enter Account ID: ");
                             int accId = sc.nextInt();
                             System.out.print("Enter Customer ID: ");
                             int custId = sc.nextInt();
                             sc.nextLine(); // consume newline
                             System.out.print("Enter Account Type: ");
                             String accType = sc.nextLine();
                             System.out.print("Enter Initial Balance: ");
                             long balance = sc.nextLong();

                             // Create Account object using parameterized constructor
                             Account newAccount = new Account(accId, custId, accType, balance);
                             accountDao.addAccount(newAccount);
                             break;

                        case 2:
                            System.out.print("Enter Account ID: ");
                            int accountId = sc.nextInt();
                            Account acc = accountDao.getAccountById(accountId);
                            System.out.println(acc != null ? acc : "Account not found.");
                            break;

                        case 3:
                        	System.out.print("Enter Account ID to update: ");
                        	int updAccId = sc.nextInt();
                        	System.out.print("Enter Customer ID: ");
                        	int updCustId = sc.nextInt();
                        	sc.nextLine();
                        	System.out.print("New Account Type: ");
                        	String updType = sc.nextLine();
                        	System.out.print("New Balance: ");
                        	long updBal = sc.nextLong();

                        	Account upAcc = new Account(updAccId, updCustId, updType, updBal);
                        	System.out.println(accountDao.updateAccount(upAcc) ? "Account updated!" : "Update failed.");
                        	break;
                        case 4:
                            System.out.print("Enter Account ID to delete: ");
                            int aid = sc.nextInt();
                            System.out.println(accountDao.deleteAccount(aid) ? "Account deleted!" : "Delete failed.");
                            break;

                        case 5:
                            List<Account> accounts = accountDao.getAllAccounts();
                            for (Account a : accounts) {
                                System.out.println(a);
                            }
                            break;

                        default:
                            System.out.println("Invalid account choice.");
                    }
                    break;

                case 3:
                    // Transaction Management
                    System.out.println("\n--- TRANSACTION MENU ---");
                    System.out.println("1. Add Transaction");
                    System.out.println("2. Get Transactions by Account ID");
                    System.out.println("3. Update Transaction");
                    System.out.println("4. Delete Transaction");
                    System.out.print("Enter your choice: ");
                    int transChoice = sc.nextInt();
                    sc.nextLine();

                    switch (transChoice) {
                        case 1:
                            Transaction txn = new Transaction();
                            System.out.print("Account ID: ");
                            txn.setAccountId(sc.nextInt());
                            System.out.print("Amount: ");
                            txn.setAmount(sc.nextDouble());
                            sc.nextLine();
                            System.out.print("Date (yyyy-mm-dd): ");
                            txn.setTransactionDate(sc.nextLine());
                            System.out.print("Type (Credit/Debit): ");
                            txn.setTransactionType(sc.nextLine());
                            System.out.println(transactionDao.addTransaction(txn) ? "Transaction added!" : "Failed to add transaction.");
                            break;

                        case 2:
                            System.out.print("Enter Account ID: ");
                            int tAccId = sc.nextInt();
                            List<Transaction> txnList = transactionDao.getTransactionsByAccount(tAccId);
                            for (Transaction t : txnList) {
                                System.out.println(t);
                            }
                            break;

                        case 3:
                            Transaction tUpdate = new Transaction();
                            System.out.print("Transaction ID: ");
                            tUpdate.setTransactionId(sc.nextInt());
                            System.out.print("Amount: ");
                            tUpdate.setAmount(sc.nextDouble());
                            sc.nextLine();
                            System.out.print("Date (yyyy-mm-dd): ");
                            tUpdate.setTransactionDate(sc.nextLine());
                            System.out.print("Type (Credit/Debit): ");
                            tUpdate.setTransactionType(sc.nextLine());
                            System.out.println(transactionDao.updateTransaction(tUpdate) ? "Transaction updated!" : "Update failed.");
                            break;

                        case 4:
                            System.out.print("Enter Transaction ID to delete: ");
                            int tid = sc.nextInt();
                            System.out.println(transactionDao.deleteTransaction(tid) ? "Transaction deleted!" : "Failed to delete.");
                            break;

                        default:
                            System.out.println("Invalid transaction choice.");
                    }
                    break;

                case 0:
                    exit = true;
                    System.out.println("Thank you for using HM Bank System!");
                    break;

                default:
                    System.out.println("Invalid main choice.");
            }
        }

        sc.close();
    }
}
