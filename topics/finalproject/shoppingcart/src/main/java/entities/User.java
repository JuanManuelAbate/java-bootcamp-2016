package entities;

/**
 * Class to model a user
 * 
 * @author Juan Manuel Abate
 */
public class User {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;

	/**
	 * Constructor Method
	 */
	public User() {

	}

	/**
	 * 
	 * @param userName
	 *            - Username of user
	 * @param password
	 *            - Password of user
	 * @param firstName
	 *            - First name of user
	 * @param lastName
	 *            - Last name of user
	 */
	public User(String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Getter Method
	 * 
	 * @return - User username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter Method
	 * 
	 * @param userName
	 *            - User username
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter Method
	 * 
	 * @return - User password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter Method
	 * 
	 * @param password
	 *            - User password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter Method
	 * 
	 * @return - User first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter Method
	 * 
	 * @param firstName
	 *            - User first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter Method
	 * 
	 * @return - User last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter Method
	 * 
	 * @param lastName
	 *            - User last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
