DELIMITER //
CREATE FUNCTION ufn_calculate_future_value (sum decimal (19,4),interest_rate double, years int)
returns decimal (19,4)
deterministic
BEGIN
return pow(1+interest_rate,years)*sum;
END //
DELIMITER ;

select ufn_calculate_future_value (1000,0.5,5);