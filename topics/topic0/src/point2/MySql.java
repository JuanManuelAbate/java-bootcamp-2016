package point2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.Query;

public class MySql implements SqlConnection {

	private static MySql connection;
	private Connection conn;

	private MySql() {
		try {
			Class.forName("driver for mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("url for mysql", "user", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static MySql getInstance() {
		if (connection == null)
			connection = new MySql();
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
