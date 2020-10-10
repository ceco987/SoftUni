CREATE SCHEMA `14. table relations`;
use `14. table relations`;

CREATE TABLE `subjects`(
subject_id int primary key auto_increment,
subject_name varchar(50) null
);

CREATE TABLE `majors`(
major_id int primary key auto_increment,
`name` varchar(50) null
);

CREATE TABLE `payments`(
payment_id int primary key auto_increment,
payment_date date null,
payment_amount decimal(8,2) null,
student_id int null
);

CREATE TABLE `students`(
student_id int primary key auto_increment,
student_number varchar(12) null,
student_name varchar(50) null,
major_id int,
CONSTRAINT fk_students_majors
FOREIGN KEY (major_id)
REFERENCES majors(major_id)
);

ALTER TABLE `payments`
ADD CONSTRAINT fk_payments_students
FOREIGN KEY (student_id)
REFERENCES students(student_id);

CREATE TABLE `agenda`(
student_id INT,
subject_id int,
primary key (student_id, subject_id),
CONSTRAINT fk_agenda_students
FOREIGN KEY (student_id)
REFERENCES students(student_id),
CONSTRAINT fk_agenda_subjects
FOREIGN KEY (subject_id)
REFERENCES subjects(subject_id)
);

