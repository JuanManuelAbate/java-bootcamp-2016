package point7;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		String query = "SELECT teacher.last_name, teacher.first_name, scheduler.day, scheduler.begin, scheduler.end, course.name "
				+ "FROM teacher " + "INNER JOIN course ON course.id_teacher = teacher.id "
				+ "INNER JOIN scheduler ON scheduler.id_course = course.id " + "WHERE teacher.id = \"3\" "
				+ "ORDER BY FIELD(scheduler.day,'Monday','Tuesday','Wednesday','Thursday', 'Friday'), scheduler.begin ";

		ResultSet rs = DbConnection.getInstance().executeQuery(query);
		while (rs.next()) {
			String out = new String();

			for (int i = 1; i < 6; i++)
				out = out + rs.getString(i) + ", ";
			out = out + rs.getString(6);

			System.out.println(out);
		}
	}

}
