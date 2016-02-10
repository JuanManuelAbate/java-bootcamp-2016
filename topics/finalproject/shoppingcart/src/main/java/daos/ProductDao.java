package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import databaseconnection.DbConnection;
import entities.Product;

/**
 * Class to manage queries related to product
 * 
 * @author Juan Manuel Abate
 */
public class ProductDao {

	private Statement stmt;

	/**
	 * Constructor Method
	 */
	public ProductDao() {
		try {
			stmt = DbConnection.getInstance().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to check if specific product exist in store
	 * 
	 * @param productId
	 *            - Id of product to check
	 * @return - True or False
	 */
	public boolean productExist(int productId) {
		String query = new String("SELECT * FROM product WHERE product.id = " + productId);
		try {
			ResultSet queryResult = stmt.executeQuery(query);
			if (queryResult.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Method to get all products in store
	 * 
	 * @return - A list of all products
	 */
	public List<Product> getAllProducts() {
		Product product;
		List<Product> productList = new ArrayList<Product>();
		ResultSet queryResult;
		String query = new String("SELECT * FROM product");
		try {
			queryResult = stmt.executeQuery(query);
			while (queryResult.next()) {
				product = new Product();
				product.setId(queryResult.getInt("id"));
				product.setName(queryResult.getString("name"));
				product.setCategory(queryResult.getString("category"));
				product.setPrice(queryResult.getInt("price"));
				product.setQuantity(queryResult.getInt("quantity"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	/**
	 * Method to find products by criteria
	 * 
	 * @param criteria
	 *            - Criteria to use in the search
	 * @param value
	 *            - Value to compare in the search
	 * @return - A list of products
	 */
	public List<Product> findBycriteria(String criteria, String value) {
		Product product;
		List<Product> productList = new ArrayList<Product>();
		ResultSet queryResult;
		String query = new String("SELECT * FROM product where product." + criteria + "='" + value + "'");
		try {
			queryResult = stmt.executeQuery(query);
			while (queryResult.next()) {
				product = new Product();
				product.setId(queryResult.getInt("id"));
				product.setName(queryResult.getString("name"));
				product.setCategory(queryResult.getString("category"));
				product.setPrice(queryResult.getInt("price"));
				product.setQuantity(queryResult.getInt("quantity"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	/**
	 * Method to get quantity in stock of a specific product
	 * 
	 * @param prodcutId
	 *            - Id of product to get quantity
	 * @return - An int value that represents the quantity in stock
	 */
	public int getStockOfProduct(int prodcutId) {
		String query = new String("SELECT quantity FROM product WHERE product.id = " + prodcutId);
		ResultSet queryResult;
		try {
			queryResult = stmt.executeQuery(query);
			queryResult.next();
			return queryResult.getInt("quantity");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Method to update stock of specific product
	 * 
	 * @param productId
	 *            - Id of product to update quantity in stock
	 * @param quantity
	 *            - Quantity to update stock
	 */
	public void updateStockOfProduct(int productId, int quantity) {
		String query = new String("UPDATE product SET quantity = quantity - " + quantity + " WHERE product.id = " + productId);
		try {
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
