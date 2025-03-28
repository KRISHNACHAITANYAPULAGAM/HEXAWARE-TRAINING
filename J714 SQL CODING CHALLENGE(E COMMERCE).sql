create schema Ecommerce_sql;
use Ecommerce_sql;
create table customers(customer_id int auto_increment primary key,
name varchar(255) not null,
email varchar(255) unique,
password varchar(255) not null);

alter table customers add column Address varchar(255) not null;
alter table customers rename column password to address;
alter table customers rename column address1 to password;

create table products (
    product_id int auto_increment primary key,
    name varchar(100) not null,
    description varchar(255) default 'No description available',
    price decimal(10,2),
    stockQuantity int
);

create table cart (
    cart_id int auto_increment primary key,
    customer_id int not null,
    product_id int not null,
    quantity int,
    foreign key (customer_id) references customers(customer_id) on delete cascade,
    foreign key (product_id) references products(product_id) on delete cascade
);

create table orders (
    order_id int auto_increment primary key,
    customer_id int not null,
    order_date date,
    total_price decimal(10,2),
    shipping_address varchar(255),
    foreign key (customer_id) references customers(customer_id) on delete cascade
);

create table order_items (
    order_item_id int auto_increment primary key,
    order_id int not null,
    product_id int not null,
    quantity int,
    constraint fk_order_orderitems foreign key (order_id) references orders(order_id) on delete cascade,
    constraint fk_product_orderitems foreign key (product_id) references products(product_id) on delete cascade
);

insert into products (name, description, price, stockQuantity) values
('Laptop', 'High-performance laptop', 800.00, 10),
('Smartphone', 'Latest smartphone', 600.00, 15),
('Tablet', 'Portable tablet', 300.00, 20),
('Headphones', 'Noise-canceling', 150.00, 30),
('TV', '4K Smart TV', 900.00, 5),
('Coffee Maker', 'Automatic coffee maker', 50.00, 25),
('Refrigerator', 'Energy-efficient', 700.00, 10),
('Microwave Oven', 'Countertop microwave', 80.00, 15),
('Blender', 'High-speed blender', 70.00, 20),
('Vacuum Cleaner', 'Bagless vacuum cleaner', 120.00, 10);

insert into customers (name, email, address) values
('John Doe', 'johndoe@example.com', '123 Main St, City'),
('Jane Smith', 'janesmith@example.com', '456 Elm St, Town'),
('Robert Johnson', 'robert@example.com', '789 Oak St, Village'),
('Sarah Brown', 'sarah@example.com', '101 Pine St, Suburb'),
('David Lee', 'david@example.com', '234 Cedar St, District'),
('Laura Hall', 'laura@example.com', '567 Birch St, County'),
('Michael Davis', 'michael@example.com', '890 Maple St, State'),
('Emma Wilson', 'emma@example.com', '321 Redwood St, Country'),
('William Taylor', 'william@example.com', '432 Spruce St, Province'),
('Olivia Adams', 'olivia@example.com', '765 Fir St, Territory');

update customers 
set password = 
    case 
        when customer_id = 1 then 'jd@1234'
        when customer_id = 2 then 'js#5678'
        when customer_id = 3 then 'rj$9101'
        when customer_id = 4 then 'sb!2345'
        when customer_id = 5 then 'dl@6789'
        when customer_id = 6 then 'lh#1122'
        when customer_id = 7 then 'md$3344'
        when customer_id = 8 then 'ew!5566'
        when customer_id = 9 then 'wt@7788'
        when customer_id = 10 then 'oa#9900'
    end;

set sql_safe_updates = 0;

insert into orders (customer_id, order_date, total_price, shipping_address) values
(1, '2023-01-05', 1200.00, '123 Main St, City'),
(2, '2023-02-10', 900.00, '456 Elm St, Town'),
(3, '2023-03-15', 300.00, '789 Oak St, Village'),
(4, '2023-04-20', 150.00, '101 Pine St, Suburb'),
(5, '2023-05-25', 1800.00, '234 Cedar St, District'),
(6, '2023-06-30', 400.00, '567 Birch St, County'),
(7, '2023-07-05', 700.00, '890 Maple St, State'),
(8, '2023-08-10', 160.00, '321 Redwood St, Country'),
(9, '2023-09-15', 140.00, '432 Spruce St, Province'),
(10, '2023-10-20', 1400.00, '765 Fir St, Territory');

insert into order_items (order_id, product_id, quantity) values
(1, 1, 2),
(1, 3, 1),
(2, 2, 3),
(3, 5, 2),
(4, 4, 4),
(4, 6, 1),
(5, 1, 1),
(5, 2, 2),
(6, 10, 2),
(6, 9, 3);

insert into cart (customer_id, product_id, quantity) values
(1, 1, 2),
(1, 3, 1),
(2, 2, 3),
(3, 4, 4),
(3, 5, 2),
(4, 6, 1),
(5, 1, 1),
(6, 10, 2),
(6, 9, 3),
(7, 7, 2);

-- 1. Update refrigerator product price to 800
describe products;
update products 
set price = 800 where name="refrigerator";

-- 2. Remove all cart items for a specific customer
select * from cart;
delete from cart
where customer_id=7;

-- 3. Retrieve Products Priced Below $100
select * from products
where price<100;

-- 4. Find Products with Stock Quantity Greater Than 5
select * from products
where stockQuantity>5;

-- 5. Find Products Which Name End with Letter ‘r’
select product_id,name from products
where name like "%r";

-- 6. Retrieve Orders with Total Amount Between $500 and $1000
select * from orders
where total_price between 500 and 1000;

-- 7. Retrieve Cart Items for Customer 5
select c.product_id,p.name from cart c
join products p on c.product_id=p.product_id
where customer_id=5;

-- 8. Find Customers Who Placed Orders in 2023
describe customers;
describe orders;

select orders.customer_id,name,order_date from orders
join customers c on c.customer_id=orders.customer_id
where order_date like "2023%";

--  Add Product Category Column to Products Table
describe products;

alter table products add column product_category varchar(255);

update products 
set product_category = 
    case 
        when product_id in (1, 2, 3, 5) then 'Electronics'
        when product_id in (4, 6) then'Accessories'
        when product_id = 7 then 'Home Appliances'
        when product_id in (8, 9) then 'Kitchen Appliances'
        when product_id = 10 then 'Cleaning Appliances'
        else 'Miscellaneous'
    end;

-- 9. Determine the Minimum Stock Quantity for Each Product Category
select product_category,min(stockQuantity) as Minimum_stock_quantity from products
group by product_category;

-- 10. Calculate the Total Amount Spent by Each Customer
select customer_id, sum(total_price) as total_amount_spent
from orders
group by customer_id;

-- 11. Find the Average Order Amount for Each Customer
select customer_id, name, round(avg(total_price),2) as average_order_amount
from orders
join customers using(customer_id)
group by customer_id;

-- 12. Count the Number of Orders Placed by Each Customer
select customer_id, name, count(customer_id) as totalcount 
from orders
join customers using (customer_id)
group by customer_id, name;

-- 13. Find the Maximum Order Amount for Each Customer
select c.customer_id, c.name, max(o.total_price) as max_order_amount
from customers c
join orders o on c.customer_id = o.customer_id
group by c.customer_id, c.name;

-- 14. Get Customers Who Placed Orders Totaling Over $1000
select c.customer_id, c.name, sum(o.total_price) as total_spent
from customers c
join orders o on c.customer_id = o.customer_id
group by c.customer_id, c.name
having total_spent > 1000;

-- 15. Subquery to Find Products Not in the Cart
select * from products
where product_id not in (select distinct product_id from cart);

-- 16. Subquery to Find Customers Who Haven't Placed Orders
select * from customers
where customer_id not in (select distinct customer_id from orders);

-- 17. Subquery to Calculate the Percentage of Total Revenue for a Product
describe order_items;
describe products;

select p.product_id, p.name, 
(sum(o.quantity * p.price) * 100) / 
(select sum(quantity * price) from order_items oi join products pr on oi.product_id = pr.product_id) 
as total_percentage
from order_items o
join products p on o.product_id = p.product_id
group by p.product_id, p.name
order by total_percentage desc;

-- 18. Subquery to Find Products with Low Stock
select product_id, name, stockQuantity 
from products 
where stockQuantity < (select avg(stockQuantity) from products);

-- 19. Subquery to Find Customers Who Placed High-Value Orders
select distinct customer_id, total_price
from orders 
where total_price > (select avg(total_price) from orders);
