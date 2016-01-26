package point7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	private static DbConnection connection;
	private Connection conn;

	private DbConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/high-school", "jabate", "juansete");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DbConnection getInstance() {

		if (connection == null) {
			connection = new DbConnection();
		}
		return connection;
	}

	public ResultSet executeQuery(String query) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
