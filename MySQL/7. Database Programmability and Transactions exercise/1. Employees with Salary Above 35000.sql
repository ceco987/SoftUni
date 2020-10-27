DELIMITER //
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN
	select first_name, last_name from employees
    where salary>35000
    order by first_name, last_name;
END //
DELIMITER ;