DELIMITER //
CREATE PROCEDURE usp_get_employees_by_salary_level (s_level VARCHAR(10))
BEGIN
SELECT first_name, last_name
FROM `employees`
where ufn_get_salary_level (salary) = s_level
order by first_name desc, last_name desc;
END //
DELIMITER ;