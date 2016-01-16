package point2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.Query;

public class PostgreSql implements SqlConnection {

	private static PostgreSql connection;
	private Connection conn;

	private PostgreSql() {
		try {
			Class.forName("driver for postgresql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("url for postgresql", "user", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static PostgreSql getInstance() {
		if (connection == null) {
			connection = new PostgreSql();
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
