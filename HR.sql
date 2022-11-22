--table account

create table account (
    id int not null primary key,
    username varchar(200) not null,
    pass varchar(250) not null,
    name varchar(255) not null
);
INSERT INTO account (ID, username, pass, name) VALUES (1, 'admin', 'admin', 'Admin');
INSERT INTO account (ID, username, pass, name) VALUES (2, 'loan123', '123456', 'Loan');
INSERT INTO account (ID, username, pass, name) VALUES (3, 'ngan23', '123456', 'Ngan');
    
select * from account;

create table drinks (
    id int not null primary KEY,
    name varchar(200) not null,
    price int not null,
    start_date date default null,
    end_date date default null
); 


INSERT INTO drinks (ID, name, price, start_date, end_date) VALUES (4, 'Trà s?a', 40000, '11-11-2021', '12-12-2021');
INSERT INTO drinks (ID, name, price, start_date, end_date) VALUES (5, 'S?a t??i', 30000, '11-11-2021', '12-12-2021');
INSERT INTO drinks (ID, name, price, start_date, end_date) VALUES (6, 'Trà trái cây', 20000, '11-11-2021', '12-12-2021');
INSERT INTO drinks (ID, name, price, start_date, end_date) VALUES (7, 'Trà xanh Nh?t B?n', 40000, '11-11-2021', '12-12-2021');

select * from drinks;
select sysdate,systimestamp from dual;
CREATE TABLE bills (
    ID int NOT NULL PRIMARY Key,
    account_ID int NOT NULL,
    bill_date timestamp  DEFAULT systimestamp NOT NULL,
    total_price int DEFAULT 0 NOT NULL,
    foreign key(account_ID) references account(id)
);
INSERT INTO bills (ID, account_ID, bill_date, total_price) VALUES (8, 1, '26-11-2021 13:18:08', 260000);
INSERT INTO bills (ID, account_ID, bill_date, total_price) VALUES (9, 1, '26-11-2021 13:18:08', 200000);
INSERT INTO bills (ID, account_ID, bill_date, total_price) VALUES (10, 1, '26-11-2021 13:18:08', 170000);
INSERT INTO bills (ID, account_ID, bill_date, total_price) VALUES (11, 1, '26-11-2021 13:18:08', 300000);
SELECT
    * FROM bills;
create table orders (
    ID int NOT NULL PRIMARY KEY,
    drinks_ID int NOT NULL,
    bills_ID int NOT NULL,
    count int NOT NULL,
    foreign key(drinks_ID) references drinks(id),
    foreign key(bills_ID) references bills(id)
);
INSERT INTO orders (ID, drinks_ID, bills_ID ,count) VALUES (13, 4, 8, 1);
INSERT INTO orders (ID, drinks_ID, bills_ID ,count) VALUES (14, 6, 9, 2);
INSERT INTO orders (ID, drinks_ID, bills_ID ,count) VALUES (15, 5, 10, 9);
INSERT INTO orders (ID, drinks_ID, bills_ID ,count) VALUES (16, 7, 11, 10);


--create table sum{select d.id, d.name, ord.count, d.price from drinks d
--join orders ord on ord.drinks_id=d.id}
--select d.id, d.name, ord.count, d.price from drinks d
--join orders ord on ord.drinks_id=d.id where ord.id=18
