create schema hmbank;
use hmbank;

create table customers (
    customer_id int primary key auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    dob date not null,
    email varchar(100) unique not null,
    phone_number varchar(15),
    address varchar(255)
);

create table accounts (
    account_id int primary key auto_increment,
    customer_id int not null,
    account_type enum('savings', 'current', 'zero_balance') not null,
    balance decimal(12, 2) default 0.00,
    foreign key (customer_id) references customers(customer_id)
        on delete cascade
);

create table transactions (
    transaction_id int primary key auto_increment,
    account_id int not null,
    transaction_type enum('deposit', 'withdrawal', 'transfer') not null,
    amount decimal(12, 2) not null,
    transaction_date timestamp default current_timestamp,
    foreign key (account_id) references accounts(account_id)
        on delete cascade
);
