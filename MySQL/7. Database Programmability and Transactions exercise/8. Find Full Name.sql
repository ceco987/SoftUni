DELIMITER //
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
SELECT CONCAT_WS(' ', first_name,last_name) as full_name
from account_holders
order by full_name,id;
END //
DELIMITER ;