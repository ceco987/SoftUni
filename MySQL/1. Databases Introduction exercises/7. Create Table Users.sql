CREATE TABLE `users`(
`id` INT AUTO_INCREMENT,
`username` VARCHAR(30),
`password` VARCHAR(26),
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` boolean,
PRIMARY KEY (`id`),
CONSTRAINT
UNIQUE (`id`,`username`)
);

INSERT INTO `users`
VALUES
(1,'domatcho','1234','asdawdas','2020-05-25 12:23:23',true),
(2,'kartofcho','123445','1321355123','2020-01-23 13:23:23',false),
(3,'pencho','32412','34144fdf343','2018-02-27 03:45:01',true),
(4,'armani','12341','123141fsgg2231','2017-09-15 18:23:23',false),
(5,'armagedoncho','75689345','adsgr453gdt2','2012-12-21 00:00:00',true);