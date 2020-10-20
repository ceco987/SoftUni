#the function from the previous task needs to be created here before judge submission
DELIMITER //
CREATE procedure usp_calculate_future_value_for_account (acc_id int, interest_rate DECIMAL(19,4))
begin
select ah.id as account_id, first_name, last_name,balance as current_balance,
ufn_calculate_future_value (balance,interest_rate,5) as balance_in_5_years
from account_holders as ah join accounts as acc on ah.id = acc.account_holder_id
where acc.id = acc_id;
end //
DELIMITER ;