CREATE DATABASE `car_rental`;

use `car_rental`;

CREATE TABLE `categories`(
id int auto_increment primary key,
category varchar(30),
daily_rate double not null,
weekly_rate double not null,
monthly_rate double not null,
weekend_rate double not null
);

CREATE TABLE `cars`(
id int not null auto_increment primary key,
plate_number varchar (15) not null,
make varchar (20) not null,
model varchar (20) not null,
car_year year not null,
category_id int not null,
doors int not null,
picture blob null,
car_condition varchar (20) null,
available boolean,
CONSTRAINT fk_cars_categories
	FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
INDEX car_condition (car_condition)
);

CREATE TABLE employees (
id int not null auto_increment primary key,
first_name varchar(15) not null,
last_name varchar(15) not null,
title varchar(15) not null,
notes text null
);

CREATE TABLE customers(
id int not null auto_increment primary key,
driver_license_number varchar(20) not null unique,
full_name varchar(50) not null,
address varchar (150) not null,
city varchar(15) not null,
zip_code int not null,
notes text null
);

CREATE TABLE rental_orders(
id int not null auto_increment primary key,
employee_id int,
customer_id int,
car_id int,
car_condition varchar(20) null,
tank_level double not null,
kilometrage_start int not null,
kilometrage_end int not null,
total_kilometrage int not null,
start_date date not null,
end_date date not null,
total_days int not null,
rate_applied double not null,
tax_rate double not null,
order_status varchar (15) not null,
notes text null,
CONSTRAINT fk_rental_orders_employees
	FOREIGN KEY (employee_id)
    REFERENCES employees(id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
CONSTRAINT fk_rental_orders_customers
	FOREIGN KEY (customer_id)
    REFERENCES customers(id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
CONSTRAINT fk_rental_orders_cars
	FOREIGN KEY (car_id)
    REFERENCES cars(id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
CONSTRAINT fk_rental_orders_cars2
	FOREIGN KEY (`car_condition`)
    REFERENCES `cars`(`car_condition`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION    
);