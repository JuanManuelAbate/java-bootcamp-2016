package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to create a database connection
 * 
 * @author Juan Manuel Abate
 */
public class DbConnection {

	private static DbConnection connection;
	private Connection conn;

	/**
	 * Constructor Method Create a db connection using credentials and driver
	 */
	private DbConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/final-project", "INSERT USER HERE", "INSERT PASSWORD HERE");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get always the same instance of the DbConnection
	 * 
	 * @return - DbConnection object
	 */
	public static DbConnection getInstance() {

		if (connection == null) {
			connection = new DbConnection();
		}
		return connection;
	}

	/**
	 * Method to get the connection to the data base
	 * 
	 * @return - Connection to data base
	 */
	public Connection getConnection() {
		return connection.conn;
	}

}
