DELIMITER //
CREATE FUNCTION ufn_is_word_comprised (set_of_letters varchar(50), word varchar(50))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
RETURN word regexp(concat('^[',set_of_letters,']+$'));
END //
DELIMITER ;