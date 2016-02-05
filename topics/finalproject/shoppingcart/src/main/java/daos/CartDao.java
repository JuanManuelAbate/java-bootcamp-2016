package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import databaseconnection.DbConnection;

/**
 * Class to manage queries related to cart
 * 
 * @author Juan Manuel Abate
 */
public class CartDao {

	private Statement stmt;

	/**
	 * Constructor Method
	 */
	public CartDao() {
		try {
			stmt = DbConnection.getInstance().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to delete cart in database related to a specific user
	 * 
	 * @param userName
	 *            - Usesname of the owner of cart
	 */
	public void deleteCartByUserName(String userName) {
		String query = new String("DELETE FROM usercart WHERE usercart.id_user = " + "'" + userName + "'");
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to insert product and quantity in a cart related to an user
	 * 
	 * @param userName
	 *            - Usesname of the owner of cart
	 * @param productId
	 *            - Id of product to insert
	 * @param quantity
	 *            - Quantity of product to insert
	 */
	public void addProductByUser(String userName, int productId, int quantity) {
		String query = new String("INSERT INTO usercart(id_user, id_product, product_quantity) VALUES (" + "'" + userName + "'" + ","
				+ productId + "," + quantity + ")");
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get all products in a cart of an specific user
	 * 
	 * @param userName
	 *            - Usesname of the owner of cart
	 * @return - All products in a cart of an specific user in a ResultSet
	 *         structure
	 */
	public ResultSet getProductsByUserName(String userName) {
		String query = new String(
				"SELECT product.id, product.name, product.category, product.price, usercart.product_quantity FROM product INNER JOIN usercart ON usercart.id_product = product.id WHERE usercart.id_user = "
						+ "'" + userName + "'");
		try {
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}