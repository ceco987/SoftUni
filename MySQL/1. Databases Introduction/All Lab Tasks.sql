CREATE DATABASE `gamebar`;

USE `GAMEBAR`;

CREATE TABLE `employees`(
`id` INT AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `products`(
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`category_id` INT NOT NULL,
PRIMARY KEY (`id`)
);

INSERT INTO `employees` (`first_name`, `last_name`) VALUES
	('Ivan', 'Petrov'),
	('Pencho', 'Slaveikov'),
	('Mitko', 'Ivanov');
    
ALTER TABLE `employees`
add `middle_name` varchar(50) not null;

ALTER TABLE `products`
ADD CONSTRAINT `fk_products_categories`
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`)
ON UPDATE NO ACTION
ON DELETE NO ACTION;

ALTER TABLE `employees`
modify `middle_name` varchar(100) not null;
