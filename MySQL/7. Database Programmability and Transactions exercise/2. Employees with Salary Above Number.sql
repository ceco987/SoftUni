DELIMITER //
CREATE PROCEDURE usp_get_employees_salary_above_number (num decimal(20,4))
BEGIN
	select first_name, last_name from employees
    where salary>=num
    order by first_name, last_name;
END //
DELIMITER ;