DELIMITER //
DROP PROCEDURE IF EXISTS usp_transfer_money //
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4)) 
begin
start transaction;
if 	(select balance from accounts where id = from_account_id) < amount
	or from_account_id = to_account_id
    or (select count(*) from accounts where id = from_account_id or id = to_account_id) = 0
    or amount < 0
    then rollback;
    else
		update accounts as a1, accounts as a2
        set a1.balance = a1.balance - amount, a2.balance = a2.balance + amount
        where a1.id = from_account_id and a2.id = to_account_id;
    end if;
end //
DELIMITER ;

call usp_transfer_money(1,2,10);
select * from accounts
where id in (1,2);