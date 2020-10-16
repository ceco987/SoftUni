DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE e_count INT;
    SET e_count := (SELECT COUNT(*) from employees AS e
		JOIN addresses as a using (`address_id`)
        join towns as t using (town_id)
	WHERE t.`name` = town_name);
    RETURN e_count;
END $$
DELIMITER ;