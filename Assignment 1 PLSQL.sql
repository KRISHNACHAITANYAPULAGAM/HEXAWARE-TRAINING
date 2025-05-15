use fsd_hexaware;

create table book(id int primary key auto_increment,
title varchar(255) default "no description",
price decimal(10,2),
author varchar(255) not null,
publication_house varchar(255),
category varchar(255),
book_count int,
status varchar(255),
check (status in ('IN_STOCK','OUT_OF_STOCK')));

describe book;

INSERT INTO book (title, price, author, publication_house, category, book_count, status) VALUES
('War of Shadows', 24.99, 'Ethan Black', 'Mcgraw Hill', 'WAR', 15, 'IN_STOCK'),
('Laughter Lane', 12.50, 'Maya Green', 'DreamFolks', 'COMEDY', 8, 'IN_STOCK'),
('The Last Goal', 18.00, 'Chris Ball', 'Warner Bros', 'SPORTS', 0, 'OUT_OF_STOCK'),
('Echoes of Fiction', 16.75, 'Laura Knight', 'Mcgraw Hill', 'FICTION', 12, 'IN_STOCK'),
('Fields of Valor', 20.99, 'James K. Rowe', 'DreamFolks', 'WAR', 0, 'OUT_OF_STOCK'),
('Comic Relief', 14.30, 'Nina Bloom', 'Warner Bros', 'COMEDY', 6, 'IN_STOCK'),
('Final Whistle', 17.60, 'Tom Bradyson', 'Mcgraw Hill', 'SPORTS', 4, 'IN_STOCK'),
('Fiction Junction', 19.20, 'Alex Poe', 'DreamFolks', 'FICTION', 0, 'OUT_OF_STOCK'),
('Blitzkrieg', 21.45, 'Sarah Vaughn', 'Warner Bros', 'WAR', 9, 'IN_STOCK'),
('Goal Diggers', 15.50, 'Sam Field', 'DreamFolks', 'SPORTS', 3, 'IN_STOCK');

select * from book;


delimiter $$
create procedure proc_instock(p_price int)
begin
select * from book where price < p_price and status = 'IN_STOCK';
end;
drop procedure proc_instock;
call proc_instock(15);

delimiter $$
create procedure proc_delete(IN publication varchar(255))
begin
declare b_id int default 0;
declare id_count int default 0;
declare i int default 0;
select count(id)into id_count from book where publication_house=publication;
while i<id_count do
select id into b_id from book where publication_house=publication limit i,1;
delete from book where id=b_id;
set i=i+1;
end while;
end;
drop procedure proc_delete;
call proc_delete("MCgraw Hill");

delimiter $$
create procedure proc_update_price(IN p_category varchar(255),IN p_price_percent int)
begin

declare i int default 0;
declare cat varchar(255) default "";
declare p_count int default 0;
declare p_id int default 0;
select count(cat) into p_count from book where category=p_category;
while i<p_count do

select id into p_id from book where category=p_category limit i,1;

update book set price =price+(price*(p_price_percent/100)) where id=p_id;
set i=i+1;
end while;

end;

drop procedure proc_update_price;
call proc_update_price("Fiction",5);
delimiter ;
select * from book;