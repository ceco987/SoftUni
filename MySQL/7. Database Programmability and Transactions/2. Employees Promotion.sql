DELIMITER //
create procedure usp_raise_salaries (dep_name varchar (15))
BEGIN
	update `employees` join departments as d using (department_id)
    set salary = salary * 1.05
    where d.`name` = dep_name;
END //
DELIMITER ;