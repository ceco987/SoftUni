DELIMITER //
drop procedure usp_get_towns_starting_with;
CREATE PROCEDURE usp_get_towns_starting_with (city_name VARCHAR(25))
BEGIN
	SELECT `name` from towns
    where `name` like concat(city_name,'%')
    order by `name`;
END //
DELIMITER ;