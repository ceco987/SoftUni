CREATE TABLE `teachers`(
teacher_id int primary key auto_increment,
`name` varchar(15) NOT NULL,
manager_id int null
);

INSERT INTO `teachers`
values
(101,'John',null),
(102,'Maya',106),
(103,'Silvia',106),
(104,'Ted',105),
(105,'Mark',101),
(106,'Greta',101);

ALTER TABLE teachers
add CONSTRAINT fk_teachers
FOREIGN KEY (manager_id)
REFERENCES `teachers`(teacher_id);