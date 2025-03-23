-- Task 1: Database Design

-- 1. Create the database
CREATE DATABASE HMBank;
USE HMBank;

-- 2. Create Tables

-- Customers Table
CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    DOB DATE,
    email VARCHAR(255),
    phone_number BIGINT,
    address VARCHAR(255) -- Added in later ALTER TABLE
);

-- Accounts Table
CREATE TABLE Accounts (
    account_id INT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    account_type VARCHAR(255),
    balance BIGINT,
    CHECK (account_type IN ('savings', 'current', 'zero_balance'))
);

-- Transactions Table
CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id),
    transaction_type VARCHAR(255),
    amount DECIMAL(10,2),
    transaction_date DATE,
    CHECK (transaction_type IN ('deposit', 'withdraw', 'transfer'))
);

-- 3. Insert Sample Data

-- Insert into Customers
INSERT INTO Customers (first_name, last_name, DOB, email, phone_number, address) VALUES
('Krishna', 'Chaitanya', '2003-08-22', 'pulagam2003@gmail.com', 8885676555, 'Guntur'),
('Siva', 'Prasad', '1970-06-01', 'pulagams2350@gmail.com', 9848112350, 'Guntur'),
('Ash', 'Born', '1995-08-12', '1234@gmail.com', 8928124321, 'Pallet Town'),
('Arthur', 'Morgan', '1983-06-21', 'arthur@gmail.com', 8912345667, 'Saint Dennis'),
('Dutch', 'Vanderlin', '1970-03-14', 'dutch@gmail.com', 9782345601, 'Black Water'),
('Sadie', 'Adler', '1987-09-10', 'sadie@gmail.com', 7890123456, 'Saint Dennis'),
('Micah', 'Bells', '1982-11-05', 'micah@gmail.com', 9870654321, 'Black Water'),
('John', 'Marston', '1985-02-28', 'john@gmail.com', 9087563412, 'Black Water'),
('Peter', 'Parker', '2001-08-10', 'peter@gmail.com', 8905672341, 'New York'),
('Miles', 'Morales', '2005-05-22', 'miles@gmail.com', 7890345612, 'New York');

-- Insert into Accounts
INSERT INTO Accounts VALUES
(101, 1, 'savings', 9999999999),
(102, 2, 'savings', 99999999998),
(103, 5, 'current', 50000),
(104, 3, 'zero_balance', 0),
(105, 6, 'current', 70000),
(106, 7, 'zero_balance', 450000),
(107, 4, 'savings', 1000000),
(108, 10, 'current', 250000),
(109, 8, 'zero_balance', 90000),
(110, 9, 'savings', 40000);

-- Insert into Transactions
INSERT INTO Transactions (account_id, transaction_type, amount, transaction_date) VALUES
(101, 'withdraw', 1000000, '2025-03-20'),
(102, 'deposit', 2000000, '2025-03-20'),
(104, 'transfer', 40000, '2024-04-12'),
(105, 'withdraw', 1000, '2024-12-12'),
(103, 'deposit', 10000000, '2025-01-01'),
(108, 'withdraw', 2000, '2025-03-19'),
(109, 'deposit', 10000, '2025-02-28'),
(107, 'transfer', 3000, '2025-02-27'),
(110, 'transfer', 5000, '2025-03-01'),
(106, 'deposit', 9000, '2025-01-01');

-- Task 2: SQL Queries

-- 1. Retrieve the name, account type, and email of all customers
SELECT CONCAT(first_name, ' ', last_name) AS FullName, customers.email, accounts.account_type 
FROM customers
INNER JOIN accounts USING (customer_id);

-- 2. List all transactions corresponding to each customer
SELECT CONCAT(first_name, ' ', last_name) AS FullName, transactions.*
FROM customers
JOIN accounts ON customers.customer_id = accounts.customer_id
JOIN transactions ON accounts.account_id = transactions.account_id;

-- 3. Increase the balance of a specific account by a certain amount
UPDATE Accounts
SET balance = balance + 100000
WHERE customer_id = 4;

-- 4. Combine first and last names of customers as full_name
SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM Customers;

-- 5. Remove accounts with a balance of zero where the account type is savings
DELETE FROM Accounts
WHERE balance = 0 AND account_type = 'savings';

-- 6. Find customers living in a specific city
SELECT * FROM Customers WHERE address = 'Saint Dennis';

-- 7. Get the account balance for a specific account
SELECT balance FROM Accounts WHERE account_type = 'savings';

-- 8. List all current accounts with a balance greater than $1,000
SELECT * FROM Accounts WHERE account_type = 'current' AND balance > 1000;

-- 9. Retrieve all transactions for a specific account
SELECT * FROM Transactions WHERE account_id = 104;

-- 10. Calculate the interest accrued on savings accounts based on a given interest rate (5%)
SELECT account_id, balance, balance * 0.05 AS Interest
FROM Accounts WHERE account_type = 'savings';

-- 11. Identify accounts where the balance is less than a specified overdraft limit (60,000)
SELECT * FROM Accounts WHERE balance < 60000;

-- 12. Find customers not living in a specific city (Guntur)
SELECT first_name, last_name FROM Customers WHERE address != 'Guntur';

-- TASK 3: Aggregate functions, Having, Order By, GroupBy, and Joins

-- 1. Find the average account balance for all customers.
SELECT AVG(balance) AS averageaccountbalance FROM accounts;

-- 2. Retrieve the top 10 highest account balances.
SELECT * FROM accounts ORDER BY balance DESC LIMIT 10;

-- 3. Calculate Total Deposits for All Customers on a specific date.
SELECT SUM(amount) AS totaltransactions FROM transactions WHERE transaction_date = "2025-01-01";

-- 4. Find the Oldest and Newest Customers.
SELECT customer_id, CONCAT(first_name, " ", last_name), joiningdate FROM customers
WHERE joiningdate = (SELECT MAX(joiningdate) FROM customers)
UNION
SELECT customer_id, CONCAT(first_name, " ", last_name), joiningdate FROM customers
WHERE joiningdate = (SELECT MIN(joiningdate) FROM customers);

-- 5. Retrieve transaction details along with the account type.
SELECT transactions.*, accounts.account_type FROM transactions
INNER JOIN accounts USING (account_id);

-- 6. Get a list of customers along with their account details.
SELECT customers.*, accounts.* FROM customers
INNER JOIN accounts ON accounts.customer_id = customers.customer_id;

-- 7. Retrieve transaction details along with customer information for a specific account.
SELECT transactions.*, customers.* FROM transactions
INNER JOIN accounts ON transactions.account_id = accounts.account_id
INNER JOIN customers ON accounts.customer_id = customers.customer_id
WHERE transactions.amount = 5000;

-- 8. Identify customers who have more than one account.
SELECT customers.customer_id, CONCAT(first_name, " ", last_name) AS FullName, COUNT(accounts.account_id)  
FROM customers
INNER JOIN accounts USING (customer_id)
GROUP BY customer_id, FullName
HAVING COUNT(accounts.account_id) > 1;

-- 9. Calculate the difference in transaction amounts between deposits and withdrawals.
SELECT SUM(CASE WHEN transaction_type="deposit" THEN amount END) - 
       SUM(CASE WHEN transaction_type="withdraw" THEN amount END) AS diff 
FROM transactions;

-- 10. Calculate the average daily balance for each account over a specified period.
SELECT accounts.customer_id, ROUND(AVG(balance), 2) AS avgdailybalance FROM accounts
INNER JOIN transactions ON transactions.account_id = accounts.account_id 
WHERE transaction_date BETWEEN "2024-01-01" AND "2025-12-01"
GROUP BY customer_id;

-- 11. Calculate the total balance for each account type.
SELECT account_type, SUM(balance) FROM accounts GROUP BY account_type;

-- 12. Identify accounts with the highest number of transactions ordered by descending order.
SELECT transactions.account_id, CONCAT(first_name, " ", last_name) AS FullName, COUNT(transaction_id) AS highesttransactioncount 
FROM transactions
INNER JOIN accounts ON transactions.account_id = accounts.account_id
INNER JOIN customers ON accounts.customer_id = customers.customer_id
GROUP BY transactions.account_id ORDER BY highesttransactioncount DESC;

-- 13. List customers with high aggregate account balances, along with their account types.
SELECT customers.customer_id, CONCAT(first_name,' ',last_name) AS FullName, SUM(balance) 
FROM customers
INNER JOIN accounts USING (customer_id)
GROUP BY customer_id;

-- 14. Identify and list duplicate transactions based on transaction amount, date, and account.
SELECT transaction_date, account_type, amount FROM transactions
INNER JOIN accounts ON transactions.account_id = accounts.account_id
GROUP BY transactions.transaction_date, transactions.amount, transactions.account_id
HAVING COUNT(*) > 1;

-- TASK 4: Subqueries and Their Types

-- 1. Retrieve the customer(s) with the highest account balance.
SELECT customers.customer_id, CONCAT(first_name,' ',last_name) AS FullName, balance FROM customers
INNER JOIN accounts USING (customer_id)
WHERE balance IN (SELECT MAX(balance) FROM accounts);

-- 2. Calculate the average account balance for customers who have more than one account.
SELECT customers.customer_id, CONCAT(first_name,' ',last_name) AS FullName, AVG(balance) 
FROM customers
INNER JOIN accounts USING (customer_id)
WHERE customer_id IN (SELECT customer_id FROM accounts GROUP BY customer_id HAVING COUNT(customer_id) > 1)
GROUP BY customer_id;

-- 3. Retrieve accounts with transactions whose amounts exceed the average transaction amount.
SELECT account_id, amount FROM transactions
WHERE amount > (SELECT AVG(amount) FROM transactions);

-- 4. Identify customers who have no recorded transactions.
SELECT CONCAT(first_name,' ',last_name) AS FullName, accounts.account_id 
FROM customers
INNER JOIN accounts USING (customer_id)
WHERE account_id IN (SELECT accounts.account_id FROM transactions RIGHT JOIN accounts USING (account_id) 
WHERE transactions.account_id IS NULL);

-- 5. Calculate the total balance of accounts with no recorded transactions.
SELECT CONCAT(first_name,' ',last_name), SUM(balance) AS totalbalance 
FROM customers
INNER JOIN accounts ON accounts.customer_id = customers.customer_id
WHERE accounts.account_id IN (SELECT accounts.account_id FROM accounts 
LEFT JOIN transactions ON accounts.account_id = transactions.account_id
WHERE transaction_id IS NULL)
GROUP BY customer_id;

-- 6. Retrieve transactions for accounts with the lowest balance.
SELECT * FROM transactions
WHERE account_id = (SELECT account_id FROM accounts ORDER BY balance LIMIT 1);

-- 7. Identify customers who have accounts of multiple types.
SELECT * FROM customers
WHERE customer_id IN (SELECT accounts.customer_id FROM accounts GROUP BY customer_id HAVING COUNT(account_type) > 1);

-- 8. Calculate the percentage of each account type out of the total number of accounts.
SELECT account_type, ROUND(dca / tat * 100, 2) AS percentageaccounttype FROM
(SELECT account_type, COUNT(account_type) AS dca, (SELECT COUNT(*) FROM accounts) AS tat 
 FROM accounts GROUP BY account_type) AS subquery;

-- 9. Retrieve all transactions for a customer with a given customer_id.
SELECT t.* FROM transactions t
WHERE account_id IN (SELECT account_id FROM customers 
JOIN accounts USING (customer_id)
JOIN transactions USING (account_id) WHERE customer_id = 3);

-- 10. Calculate the total balance for each account type, including a subquery within the SELECT clause.
SELECT account_type, 
       (SELECT SUM(balance) FROM accounts a2 WHERE a2.account_type = a.account_type) AS totalbalance 
FROM accounts a
GROUP BY account_type;
