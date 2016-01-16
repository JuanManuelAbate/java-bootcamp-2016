package point1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.Query;

import point3.Accessor;

public class DbConnection implements Accessor {

	private static DbConnection connection;
	private Connection conn;

	private DbConnection() {

		try {
			Class.forName("driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("url", "user", "pass");
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

	@Override
	public ResultSet executeQuery(Query sentence) {
		Statement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sentence.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
