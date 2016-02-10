package entities;

/**
 * Class to model a product
 * 
 * @author Juan Manuel Abate
 */
public class Product {

	private int id;
	private String name;
	private String category;
	private int price;
	private int quantity;

	/**
	 * Constructor Method
	 */
	public Product() {

	}

	/**
	 * Constructor Method
	 * 
	 * @param id
	 *            - Id of product
	 * @param name
	 *            - Name of product
	 * @param category
	 *            - Category of product
	 * @param price
	 *            - Price of product
	 * @param quantity
	 *            - Quantity of product
	 */
	public Product(int id, String name, String category, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * Getter Method
	 * 
	 * @return - Product Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter Method
	 * 
	 * @param id
	 *            - Product Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter Method
	 * 
	 * @return - Product name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter Method
	 * 
	 * @param name
	 *            - Product name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter Method
	 * 
	 * @return - Product category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter Method
	 * 
	 * @param category
	 *            - Product category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Getter Method
	 * 
	 * @return - Product price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Setter Method
	 * 
	 * @param price
	 *            - Product price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Getter Method
	 * 
	 * @return - Product quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter Method
	 * 
	 * @param quantity
	 *            - Product quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
