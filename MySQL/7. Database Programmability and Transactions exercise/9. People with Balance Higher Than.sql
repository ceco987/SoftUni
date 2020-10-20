DELIMITER //
CREATE PROCEDURE usp_get_holders_with_balance_higher_than (suma DECIMAL(19,4))
BEGIN
SELECT first_name, last_name
from account_holders as ah join accounts as acc on acc.account_holder_id = ah.id
group by account_holder_id
having sum(acc.balance) > suma
order by account_holder_id;
END //
DELIMITER ;