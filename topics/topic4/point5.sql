SELECT teacher.last_name, teacher.first_name, scheduler.day, scheduler.begin, scheduler.end, course.name 
FROM teacher
	INNER JOIN course ON course.id_teacher = teacher.id
	INNER JOIN scheduler ON scheduler.id_course = course.id
WHERE teacher.id = "3"
ORDER BY FIELD(scheduler.day,'Monday','Tuesday','Wednesday','Thursday', 'Friday'), scheduler.begin;