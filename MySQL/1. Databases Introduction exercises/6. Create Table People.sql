CREATE TABLE `people` (
`id` INT AUTO_INCREMENT NOT NULL,
`name` varchar(200) NOT NULL,
`picture` BLOB,
`height` FLOAT (3,2),
`weight` FLOAT (4,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `people` (`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)
VALUES
(1,'Ivan','dpoasisdap',5.23,62.58,'F','1995-04-23','az papkam katofki'),
(2,'Goshko','fdsfa',5.99,51.98,'M','1995-05-21','az papkam domatki'),
(3,'Stamat','dasdw',2.65,65.25,'M','1985-05-25','az papkam diulki'),
(4,'Stamatka','fsefdfs',6.18,98.25,'F','1921-12-25','az papkam musakichka s mlekce'),
(5,'GENCHO','dsasdawa',8.65,99.85,'m','2020-09-12','az papkam vsichko');