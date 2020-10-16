delimiter //

create procedure usp_raise_salary_by_id(id INT)
	begin 
		update employees
		set salary = salary * 1.05
		where employee_id = id;
	end //

delimiter ;