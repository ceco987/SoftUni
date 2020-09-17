CREATE DATABASE hotel;

USE hotel;

CREATE TABLE `employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `title` VARCHAR(15) NULL,
  `notes` TEXT(300) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `customers` (
  `account_number` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `emergency_name` VARCHAR(45) NOT NULL,
  `emergency_number` VARCHAR(15) NOT NULL,
  `notes` TEXT(300) NULL,
  PRIMARY KEY (`account_number`));

CREATE TABLE `room_status` (
  `room_status` VARCHAR(15) NOT NULL,
  `notes` TEXT NULL,
  PRIMARY KEY (`room_status`));
  
CREATE TABLE `room_types` (
  `room_type` VARCHAR(15) NOT NULL,
  `notes` TEXT NULL,
  PRIMARY KEY (`room_type`));
  
  CREATE TABLE `bed_types` (
  `bed_type` VARCHAR(15) NOT NULL,
  `notes` TEXT NULL,
  PRIMARY KEY (`bed_type`));

CREATE TABLE `rooms` (
  `room_number` INT NOT NULL,
  `room_type` VARCHAR(15) NOT NULL,
  `bed_type` VARCHAR(15) NOT NULL,
  `rate` DECIMAL NOT NULL,
  `room_status` VARCHAR(15) NOT NULL,
  `notes` TEXT NULL,
  PRIMARY KEY (`room_number`),
  UNIQUE INDEX `room_number_UNIQUE` (`room_number` ASC) VISIBLE,
  INDEX `fk_rooms_room_type_idx` (`room_type` ASC) VISIBLE,
  INDEX `fk_rooms_bed_type_idx` (`bed_type` ASC) VISIBLE,
  INDEX `fk_rooms_room_status_idx` (`room_status` ASC) VISIBLE,
  INDEX `rate_inx` (`rate` ASC) VISIBLE,
  CONSTRAINT `fk_rooms_room_type`
    FOREIGN KEY (`room_type`)
    REFERENCES `room_types` (`room_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rooms_bed_type`
    FOREIGN KEY (`bed_type`)
    REFERENCES `bed_types` (`bed_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rooms_room_status`
    FOREIGN KEY (`room_status`)
    REFERENCES `room_status` (`room_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `payments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NOT NULL,
  `payment_date` DATE NOT NULL,
  `account_number` INT NULL,
  `first_date_occupied` DATE NOT NULL,
  `last_date_occupied` DATE NOT NULL,
  `total_days` INT NOT NULL,
  `amount_charged` DECIMAL NOT NULL,
  `tax_rate` DECIMAL NOT NULL,
  `tax_amount` INT NOT NULL,
  `payment_total` DECIMAL NOT NULL,
  `notes` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `account_number_UNIQUE` (`account_number` ASC) VISIBLE,
  INDEX `fk_payments_employees_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `fk_payments_employees`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payments_customers`
    FOREIGN KEY (`account_number`)
    REFERENCES `customers` (`account_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `occupancies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NOT NULL,
  `date_occupied` DATE NOT NULL,
  `account_number` INT NOT NULL,
  `room_number` INT NOT NULL,
  `rate_applied` DECIMAL NOT NULL,
  `phone_charge` DECIMAL NOT NULL,
  `notes` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_occupancies_employees_idx` (`employee_id` ASC) VISIBLE,
  INDEX `fk_occupancies_customers_idx` (`account_number` ASC) VISIBLE,
  INDEX `fk_occupancies_rooms_idx` (`room_number` ASC) VISIBLE,
  INDEX `fk_occupancies_rooms_rate_idx` (`rate_applied` ASC) VISIBLE,
  CONSTRAINT `fk_occupancies_employees`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_occupancies_customers`
    FOREIGN KEY (`account_number`)
    REFERENCES `customers` (`account_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_occupancies_rooms`
    FOREIGN KEY (`room_number`)
    REFERENCES `rooms` (`room_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_occupancies_rooms_rate`
    FOREIGN KEY (`rate_applied`)
    REFERENCES `rooms` (`rate`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `employees` (`id`, `first_name`, `last_name`, `title`, `notes`)
VALUES
('1', 'Petko', 'Petkov', 'Pazach', 'toq zdravo naguva banichki'),
('2', 'Mitko', 'Ivanov', 'Kamerier', 'chisti legla'),
('3', 'Penka', 'Menkova', 'Shef', 'Penka is the BOSS');

INSERT INTO `customers` (`account_number`, `first_name`, `last_name`, `phone_number`, `emergency_name`, `emergency_number`, `notes`)
VALUES 
('1', 'Penka', 'Menkova', '0885962587', 'Gencho', '0885321158', 'Penka e shtastliva'),
('2', 'Mitko', 'Pazacha', '0558965412', 'Genka', '0556987445', 'Mitko e pazach'),
('3', 'Vanko', 'Bozdugana', '0556987745', 'Mariika', '4548799875', 'Mariika e jena mu');

INSERT INTO `room_status` (`room_status`) 
VALUES
('Busy'),
('Occupied'),
('Cleaning');

INSERT INTO `room_types` (`room_type`)
VALUES
('Appartment'),
('Single_room'),
('Presitent_suite');

INSERT INTO `bed_types` (`bed_type`)
VALUES
('Single'),
('Double'),
('Kingsize');

INSERT INTO `rooms` (`room_number`, `room_type`, `bed_type`, `rate`, `room_status`)
VALUES 
('101', 'Appartment', 'Double', '1.2', 'Busy'),
('102', 'Presitent_suite', 'Single', '2.5', 'Cleaning'),
('203', 'Single_room', 'Kingsize', '3.5', 'Occupied');

INSERT INTO `payments` (`id`, `employee_id`, `payment_date`, `account_number`, `first_date_occupied`, `last_date_occupied`, `total_days`, `amount_charged`, `tax_rate`, `tax_amount`, `payment_total`)
VALUES
('1', '1', '2020-12-21', '1', '2020-12-01', '2020-12-03', '2', '305.25', '20', '1', '305.25'),
('2', '2', '1968-08-25', '2', '1968-01-01', '1968-01-20', '19', '2035', '20', '1', '2035'),
('3', '3', '1975-05-30', '3', '1975-05-15', '1975-05-19', '4', '200', '20', '1', '200');

INSERT INTO `occupancies` (`id`, `employee_id`, `date_occupied`, `account_number`, `room_number`, `rate_applied`, `phone_charge`)
VALUES
('1', '1', '2020-02-14', '1', '101', '1', '5'),
('2', '2', '2020-03-18', '2', '102', '3', '5'),
('3', '3', '2015-06-22', '3', '203', '4', '5');
