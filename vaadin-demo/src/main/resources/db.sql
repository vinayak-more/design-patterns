CREATE USER 'shop'@'localhost' IDENTIFIED BY 'shop';
GRANT ALL PRIVILEGES ON * . * TO 'shop'@'localhost';

FLUSH PRIVILEGES;

create database shop;

create table product (

rid int(10) auto increment primary key,
product_id varchar(10) not null,
name varchar(100) not null,
price double not null
);

insert into product (product_id,name,price) values ("1","Product 1","100"), ("2","Product 2","200"), ("3","Product 3","300");