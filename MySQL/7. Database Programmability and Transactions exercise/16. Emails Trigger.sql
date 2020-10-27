CREATE TABLE `notification_emails` (
id int primary key auto_increment,
recipient int,
`subject` varchar (50),
body varchar(100)
);

DELIMITER //
CREATE TRIGGER tr_new_record
AFTER INSERT
ON `logs`-- 
FOR EACH ROW
INSERT INTO `notification_emails` (recipient,`subject`, body)
values(
old.account_id,
concat('Balance change for account: ', old.account_id),
concat('On ', now(), ' your balance was changed from ', old.balance, ' to ', new.balance, '.')
);
DELIMITER ;