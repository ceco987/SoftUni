DELIMITER //
CREATE FUNCTION ufn_get_salary_level (emp_salary DECIMAL (19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	CASE 
		WHEN emp_salary <30000 THEN RETURN 'Low';
		WHEN emp_salary BETWEEN 30000 AND 50000 THEN RETURN 'Average';
		ELSE RETURN 'High';
    END CASE;
END //
DELIMITER ;