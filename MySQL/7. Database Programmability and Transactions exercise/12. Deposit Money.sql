DELIMITER //
CREATE PROCEDURE usp_deposit_money(acc_id int, money decimal (19,4))
begin
start transaction;
if 	balance<=0
	or (select count(*) from accounts where id = acc_id) = 0
then rollback;
else 
	update accounts
	set balance = balance + money
	where id = acc_id;
end if;
end //
DELIMITER ;