SELECT course.name, teacher.last_name, teacher.first_name, student.last_name, student.first_name 
FROM course
	INNER JOIN studentcourse ON studentcourse.id_course = course.id 
	INNER JOIN teacher ON teacher.id = course.id_teacher 
	INNER JOIN student on student.reg_numb = studentcourse.id_student 
where studentcourse.id_course = "3"
ORDER BY student.last_name;