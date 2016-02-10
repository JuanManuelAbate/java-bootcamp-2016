package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import daos.CartDao;
import daos.ProductDao;

/**
 * Class to model a cart
 * 
 * @author Juan Manuel Abate
 */
public class Cart {

	private int totalPrice;
	private Map<Integer, Product> cartProducts;

	/**
	 * Constructor Method
	 */
	public Cart() {
		cartProducts = new HashMap<Integer, Product>();
	}

	/**
	 * Method to add a product to cart
	 * 
	 * @param newProduct
	 *            - Product object to add to cart
	 */
	public void addProduct(Product newProduct) {
		totalPrice = totalPrice + (newProduct.getPrice() * newProduct.getQuantity());
		cartProducts.put(newProduct.getId(), newProduct);
	}

	/**
	 * Method to remove a product to cart
	 * 
	 * @param removeProduct
	 *            - Product object to remove of cart
	 */
	public void removeProduct(Product removeProduct) {
		totalPrice = totalPrice - (removeProduct.getPrice() * removeProduct.getQuantity());
		cartProducts.remove(removeProduct.getId());
	}

	/**
	 * Method to update a product in cart
	 * 
	 * @param updateProduct
	 *            - Product object to update in cart
	 */
	public void updateProduct(Product updateProduct) {
		removeProduct(updateProduct);
		addProduct(updateProduct);
	}

	/**
	 * Getter Method
	 * 
	 * @return - Total price of cart
	 */
	public int getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * Method to get all products in cart
	 * 
	 * @return - A list of Products
	 */
	public List<Product> getCartProducts() {
		List<Product> productsInCart = new ArrayList<Product>();
		for (Map.Entry<Integer, Product> entry : cartProducts.entrySet()) {
			productsInCart.add(entry.getValue());
		}
		return productsInCart;
	}

	/**
	 * Method to add all saved products of a specific user to cart
	 * 
	 * @param userName
	 *            - Username of the user
	 */
	public void loadProductsByUsername(String userName) {
		CartDao cd = new CartDao();
		ResultSet queryResult = cd.getProductsByUserName(userName);
		Product product;
		try {
			while (queryResult.next()) {
				product = new Product();
				product.setId(queryResult.getInt("id"));
				product.setName(queryResult.getString("name"));
				product.setCategory(queryResult.getString("category"));
				product.setPrice(queryResult.getInt("price"));
				product.setQuantity(queryResult.getInt("product_quantity"));
				this.addProduct(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to save products of the cart
	 * 
	 * @param userName
	 *            - Username of the owner of cart
	 */
	public void save(String userName) {
		CartDao cd = new CartDao();
		cd.deleteCartByUserName(userName);
		for (Map.Entry<Integer, Product> entry : cartProducts.entrySet()) {
			cd.addProductByUser(userName, entry.getKey(), entry.getValue().getQuantity());
		}
	}

	/**
	 * Method to buy all products that cart contains
	 * 
	 * @param userName
	 *            - Username of the owner of cart
	 * @return - True if the purchase is complete or return False if some
	 *         product quantity in cart is bigger that quantity in stock
	 */
	public boolean buy(String userName) {
		boolean canBuy = true;
		ProductDao pd = new ProductDao();
		for (Map.Entry<Integer, Product> entry : cartProducts.entrySet()) {
			if (pd.getStockOfProduct(entry.getKey()) < entry.getValue().getQuantity())
				canBuy = false;
		}
		if (canBuy == false)
			return false;
		else {
			for (Map.Entry<Integer, Product> entry : cartProducts.entrySet()) {
				pd.updateStockOfProduct(entry.getKey(), entry.getValue().getQuantity());
			}
			CartDao cd = new CartDao();
			cd.deleteCartByUserName(userName);
			cartProducts.clear();
			return true;
		}
	}
}
