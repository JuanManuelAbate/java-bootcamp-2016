package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import databaseconnection.DbConnection;
import entities.User;

/**
 * Class to manage queries related to user
 * 
 * @author Juan Manuel Abate
 */
public class UserDao {

	private Statement stmt;

	/**
	 * Constructor Method
	 */
	public UserDao() {
		try {
			stmt = DbConnection.getInstance().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to check if an username is already used
	 * 
	 * @param userName
	 *            - Username to check if its used
	 * @return - True or False
	 */
	public boolean usernameUsed(String userName) {
		String query = new String("SELECT * FROM user WHERE user.user_name = " + "'" + userName + "'");
		ResultSet queryResult;
		try {
			queryResult = stmt.executeQuery(query);
			if (queryResult.next() == true)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method to add a new user
	 * 
	 * @param newUser
	 *            - User object that contains all data related to the new user
	 */
	public void addUser(User newUser) {
		try {
			String query = new String("INSERT INTO user(user_name, password, first_name, last_name) VALUES" + " (\"" + newUser.getUserName()
					+ "\", \"" + newUser.getPassword() + "\", \"" + newUser.getFirstName() + "\", \"" + newUser.getLastName() + "\")");
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to if an username and password have matching in the user table to
	 * do a login
	 * 
	 * @param userName
	 *            - Username to check
	 * @param password
	 *            - Password to check
	 * @return - True or False
	 */
	public boolean login(String userName, String password) {
		String query = new String(
				"SELECT * FROM user WHERE user.user_name = " + "'" + userName + "'" + " and user.password = " + "'" + password + "'");
		ResultSet queryResult;
		try {
			queryResult = stmt.executeQuery(query);
			if (queryResult.next() == true)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
