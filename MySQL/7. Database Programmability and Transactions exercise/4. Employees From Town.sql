DELIMITER //

CREATE PROCEDURE usp_get_employees_from_town (town_name varchar(20)) 
BEGIN
	select first_name, last_name
    from employees
    join addresses using (address_id)
    join towns using (town_id)
    where `name` = town_name
    order by first_name, last_name;
END //
DELIMITER ;