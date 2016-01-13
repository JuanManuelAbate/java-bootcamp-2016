package point1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static DbConnection connection;
	private Connection conn;

	private DbConnection() {
		try {
			Class.forName("driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("url", "user", "pass");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DbConnection getInstance() {

		if (connection == null) {
			connection = new DbConnection();
		}
		return connection;
	}

	public Connection getConnection() {
		return conn;
	}
}
