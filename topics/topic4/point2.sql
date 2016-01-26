INSERT INTO teacher (first_name, last_name, birth_date) VALUES ("Juan", "Perez", "1980-01-01");
INSERT INTO teacher (first_name, last_name, birth_date) VALUES ("Manuel", "Gomez", "1980-01-02"); 
INSERT INTO teacher (first_name, last_name, birth_date) VALUES ("Matias", "Rulo", "1980-01-03");  

INSERT INTO student (first_name, last_name) VALUES ("Student0", "Student0");
INSERT INTO student (first_name, last_name) VALUES ("Student1", "Student1");
INSERT INTO student (first_name, last_name) VALUES ("Student2", "Student2");
INSERT INTO student (first_name, last_name) VALUES ("Student3", "Student3");
INSERT INTO student (first_name, last_name) VALUES ("Student4", "Student4");
INSERT INTO student (first_name, last_name) VALUES ("Student5", "Student5");
INSERT INTO student (first_name, last_name) VALUES ("Student6", "Student6");
INSERT INTO student (first_name, last_name) VALUES ("Student7", "Student7");
INSERT INTO student (first_name, last_name) VALUES ("Student8", "Student8");
INSERT INTO student (first_name, last_name) VALUES ("Student9", "Student9");

INSERT INTO course (name, id_teacher) VALUES ("Java", "1");
INSERT INTO course (name, id_teacher) VALUES ("JavaScript", "2");
INSERT INTO course (name, id_teacher) VALUES ("Python", "3");

INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("1", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("2", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("3", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("4", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("5", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("6", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("7", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("8", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("9", "1", "10", 10", "10", "10");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("10", "1", "10", 10", "10", "10");

INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("1", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("2", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("3", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("4", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("5", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("6", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("7", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("8", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("9", "2", "1", "1", "1", "1");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("10", "2", "1", "1", "1", "1");

INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("1", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("2", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("3", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("4", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("5", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("6", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("7", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("8", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("9", "3", "5", "5", "5", "5");
INSERT INTO studentcourse (id_student, id_course, note1, note2, note3, final_note) VALUES ("10", "3", "5", "5", "5", "5");

INSERT INTO scheduler (id_course, begin, end, day) VALUES ("3", "10:00", "11:00", "Monday");
INSERT INTO scheduler (id_course, begin, end, day) VALUES ("3", "15:00", "17:30", "Monday");
INSERT INTO scheduler (id_course, begin, end, day) VALUES ("3", "08:45", "10:40", "Friday");
