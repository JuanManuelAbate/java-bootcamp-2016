CREATE DATABASE `high-school`;
USE high-school;

CREATE TABLE student(
	reg_numb INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	birth_date DATE);

CREATE TABLE teacher(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	birth_date DATE);

CREATE TABLE course(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	id_teacher INT,
	FOREIGN KEY (id_teacher) REFERENCES teacher(id));

CREATE TABLE studentcourse(
	id_student INT NOT NULL,
	id_course INT NOT NULL,
	note1 INT,
	note2 INT,
	note3 INT,
	final_note INT,
	FOREIGN KEY (id_student) REFERENCES student(reg_numb),
	FOREIGN KEY (id_course) REFERENCES course(id),
	PRIMARY KEY (id_student, id_course));

CREATE TABLE scheduler(
	id_course INT NOT NULL,
	begin TIME NOT NULL,
	end TIME NOT NULL,
	day VARCHAR(15) NOT NULL,
	FOREIGN KEY (id_course) REFERENCES course(id),
	PRIMARY KEY (id_course, begin, day));