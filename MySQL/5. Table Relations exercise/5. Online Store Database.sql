CREATE TABLE `item_types`
(
item_type_id INT AUTO_INCREMENT PRIMARY KEY,
`name` varchar(50) null
);

CREATE TABLE `items`
(
item_id INT AUTO_INCREMENT PRIMARY KEY,
`name` varchar(50) null,
item_type_id int,
CONSTRAINT fk_items_item_types
FOREIGN KEY (item_type_id)
REFERENCES `item_types`(item_type_id)
);

CREATE TABLE `cities`
(
city_id INT AUTO_INCREMENT PRIMARY KEY,
`name` varchar(50) null
);

CREATE TABLE `customers`
(
customer_id INT AUTO_INCREMENT PRIMARY KEY,
`name` varchar(50) null,
birthday date,
city_id int,
CONSTRAINT fk_customers_cities
FOREIGN KEY (city_id)
REFERENCES `cities`(city_id)
);

CREATE TABLE `orders`
(
order_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id int,
CONSTRAINT fk_orders_customers
FOREIGN KEY (customer_id)
REFERENCES `customers`(customer_id)
);

CREATE TABLE `order_items`
(
order_id INT,
item_id int,
primary key(order_id,item_id),
CONSTRAINT fk_order_items_items
FOREIGN KEY (item_id)
REFERENCES `items`(item_id),
CONSTRAINT fk_order_items_orders
FOREIGN KEY (order_id)
REFERENCES `orders`(order_id)
);
