CREATE TABLE `towns` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL
);

CREATE TABLE `addresses` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `address_text` VARCHAR(100) NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT `fk_addresses_towns` FOREIGN KEY (`town_id`)
        REFERENCES `towns` (`id`)
);

CREATE TABLE `departments` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL
);

CREATE TABLE `employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `job_title` VARCHAR(20) NOT NULL,
  `department_id` INT NOT NULL,
  `hire_date` DATE NOT NULL,
  `salary` DECIMAL(10,2) NOT NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employees_departments_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_employees_addresses_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_employees_departments`
    FOREIGN KEY (`department_id`)
    REFERENCES `departments` (`id`),
  CONSTRAINT `fk_employees_addresses`
    FOREIGN KEY (`address_id`)
    REFERENCES `addresses` (`id`)
    );

INSERT INTO `towns` (`id`, `name`)
VALUES
('1', 'Sofia'),
('2', 'Plovdiv'),
('3', 'Varna'),
('4', 'Burgas');

INSERT INTO `departments` (`id`, `name`)
VALUES
('1', 'Engineering'),
('2', 'Sales'),
('3', 'Marketing'),
('4', 'Software Development'),
('5', 'Quality Assurance');

INSERT INTO `employees` (`id`, `first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
('1', 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', '4', '2013-02-01', '3500.00'),
('2', 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', '1', '2004-03-02', '4000.00'),
('3', 'Maria', 'Petrova', 'Ivanova', 'Intern', '5', '2016-08-28', '525.25'),
('4', 'Georgi', 'Terziev', 'Ivanov', 'CEO', '2', '2007-12-09', '3000.00'),
('5', 'Peter', 'Pan', 'Pan', 'Intern', '3', '2016-08-28', '599.88');
