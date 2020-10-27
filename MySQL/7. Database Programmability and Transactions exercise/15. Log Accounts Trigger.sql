CREATE TABLE `logs` (
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT,
old_sum DECIMAL(19,2),
new_sum DECIMAL(19,2)
);

DELIMITER //
CREATE TRIGGER tr_updated_accounts
AFTER UPDATE
ON accounts
FOR EACH ROW
begin
INSERT INTO `LOGS` (account_id, old_sum, new_sum)
VALUES (old.id, old.balance, new.balance);
end//
DELIMITER ;

