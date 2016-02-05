package controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import daos.ProductDao;
import daos.UserDao;
import entities.Cart;
import entities.Product;
import entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Rest controller class that contains end points of ShoppingCart Api
 * 
 * @author Juan Manuel Abate
 *
 */
@RestController
@Api(description = "ShoppingCart API", produces = "application/json")
public class ShoppingCartController {

	private String userName = null;
	private Cart userCart;

	/**
	 * Method to check if already exists a logged user
	 * 
	 * @return - True or False
	 */
	private boolean isLogged() {
		if (userName == null)
			return false;
		else
			return true;
	}

	/***************************** User Methods *****************************/

	/**
	 * Method that lets the user log into the system
	 * 
	 * @param userName
	 *            - User Name of a registered user
	 * @param password
	 *            - Password to a registered user
	 * @return - HTTP status code: 406 or 200
	 */
	@RequestMapping(value = "shoppingCart/login/{userName}/{password}", method = RequestMethod.PUT)
	@ApiOperation(value = "Login", notes = "Login as a register user")
	@ApiResponses({ @ApiResponse(code = 406, message = "A user is currently logged"),
			@ApiResponse(code = 200, message = "Logged as userName"), @ApiResponse(code = 406, message = "Wrong credentials") })
	public ResponseEntity<String> login(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "password") String password) {
		if (isLogged())
			return new ResponseEntity<String>("A user is currently logged", HttpStatus.NOT_ACCEPTABLE);
		UserDao ud = new UserDao();
		if (ud.login(userName, password)) {
			this.userName = new String(userName);
			userCart = new Cart();
			userCart.loadProductsByUsername(this.userName);
			return new ResponseEntity<String>("Logged as " + this.userName, HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Wrong credentials", HttpStatus.NOT_ACCEPTABLE);
	}

	/**
	 * Method that lets the user logout to the system
	 * 
	 * @return - HTTP status code: 200
	 */
	@RequestMapping(value = "shoppingCart/logout", method = RequestMethod.PUT)
	@ApiOperation(value = "Logout", notes = "Logout")
	@ApiResponses({ @ApiResponse(code = 200, message = "Logout") })
	public ResponseEntity<String> logout() {
		userCart.save(userName);
		this.userName = null;
		this.userCart = null;
		return new ResponseEntity<String>("Logout", HttpStatus.OK);
	}

	/**
	 * Method for register a new user
	 * 
	 * @param newUser
	 *            - All the data about new user
	 * @return - HTTP status code: 406 or 201
	 */
	@RequestMapping(value = "shoppingCart/user/newUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add an user", notes = "Register a new user to the system")
	@ApiResponses({ @ApiResponse(code = 406, message = "Username already used"), @ApiResponse(code = 201, message = "User created") })
	public ResponseEntity<String> newUser(@RequestBody User newUser) {
		UserDao ud = new UserDao();
		if (ud.usernameUsed(newUser.getUserName()))
			return new ResponseEntity<String>("Username already used", HttpStatus.NOT_ACCEPTABLE);
		else {
			ud.addUser(newUser);
			return new ResponseEntity<String>("User created", HttpStatus.CREATED);
		}
	}

	/***************************** Cart Methods *****************************/

	/**
	 * Method to buy products in cart
	 * 
	 * @return - HTTP status code: 401 or 200 or 406
	 */
	@RequestMapping(value = "shoppingCart/cart/buy", method = RequestMethod.PUT)
	@ApiOperation(value = "Buy", notes = "Buy products in cart and update stock")
	@ApiResponses({ @ApiResponse(code = 401, message = "You need to be logged"), @ApiResponse(code = 200, message = "Purchase completed"),
			@ApiResponse(code = 406, message = "Impossible to buy , check quantities") })
	public ResponseEntity<String> buyCartProducts() {
		if (isLogged()) {
			if (userCart.buy(this.userName))
				return new ResponseEntity<String>("Purchase completed", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Impossible to buy , check quantities", HttpStatus.NOT_ACCEPTABLE);
		} else
			return new ResponseEntity<String>("You need to be logged", HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Method to save user cart
	 * 
	 * @return - HTTP status code: 401 or 200
	 */
	@RequestMapping(value = "shoppingCart/cart/save", method = RequestMethod.POST)
	@ApiOperation(value = "Save", notes = "Save user cart")
	@ApiResponses({ @ApiResponse(code = 401, message = "You need to be logged"), @ApiResponse(code = 200, message = "Cart Saved") })
	public ResponseEntity<String> saveCart() {
		if (isLogged()) {
			userCart.save(this.userName);
			return new ResponseEntity<String>("Cart Saved", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("You need to be logged", HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Method to add product to cart
	 * 
	 * @param newProduct
	 *            - Product to be added to cart
	 * @return - HTTP status code: 401 or 200 or 400
	 */
	@RequestMapping(value = "shoppingCart/cart/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add product to cart", notes = "Add a product to cart that can be buyed or saved later")
	@ApiResponses({ @ApiResponse(code = 401, message = "You need to be logged"), @ApiResponse(code = 200, message = "Product added"),
			@ApiResponse(code = 400, message = "That product doesn't exist") })
	public ResponseEntity<String> addProductToCart(@RequestBody Product newProduct) {
		if (isLogged()) {
			ProductDao pd = new ProductDao();
			if (pd.productExist(newProduct.getId())) {
				userCart.addProduct(newProduct);
				return new ResponseEntity<String>("Product added", HttpStatus.OK);
			} else
				return new ResponseEntity<String>("That product doesn't exist", HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<String>("You need to be logged", HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Method to remove product from cart
	 * 
	 * @param removeProduct
	 *            - Product to be removed
	 * @return - HTTP status code: 401 or 200
	 */
	@RequestMapping(value = "shoppingCart/cart/removeProduct", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Remove product of cart", notes = "Remove a spesific product from cart")
	@ApiResponses({ @ApiResponse(code = 401, message = "You need to be logged"), @ApiResponse(code = 200, message = "Product removed") })
	public ResponseEntity<String> deleteProductInCar(@RequestBody Product removeProduct) {
		if (isLogged()) {
			userCart.removeProduct(removeProduct);
			return new ResponseEntity<String>("Product removed", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("You need to be logged", HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Method to update product in cart
	 * 
	 * @param updateProduct
	 *            - Product to be updated
	 * @return - HTTP status code: 401 or 200
	 */
	@RequestMapping(value = "shoppingCart/cart/updateProduct", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update product of cart", notes = "Update a product in cart")
	@ApiResponses({ @ApiResponse(code = 401, message = "You need to be logged"), @ApiResponse(code = 200, message = "Product updated") })
	public ResponseEntity<String> UpdateProductInCar(@RequestBody Product updateProduct) {
		if (isLogged()) {
			userCart.updateProduct(updateProduct);
			return new ResponseEntity<String>("Product updated", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("You need to be logged", HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Method to get total prices of products in cart
	 * 
	 * @return - HTTP status code: 401 or 200
	 */
	@RequestMapping(value = "shoppingCart/cart/totalPrice", method = RequestMethod.GET)
	@ApiOperation(value = "Cart total", notes = "Get the total amount of cart")
	@ApiResponses({ @ApiResponse(code = 401, message = "You need to be logged"), @ApiResponse(code = 200, message = "Amount of cart") })
	public ResponseEntity<Integer> getTotalPrice() {
		if (isLogged()) {
			return new ResponseEntity<Integer>(userCart.getTotalPrice(), HttpStatus.OK);
		} else
			return new ResponseEntity<Integer>(HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Method to get all products in cart
	 * 
	 * @return - List of products in JSON format and HTTP status code: 401 or
	 *         200
	 */
	@RequestMapping(value = "shoppingCart/cart/allProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "All products in cart", notes = "Get all products in cart for a logged user")
	@ApiResponses({ @ApiResponse(code = 401, message = "You need to be logged"), @ApiResponse(code = 200, message = "Cart products") })
	public ResponseEntity<List<Product>> getAllProductsInCar() {
		if (isLogged()) {
			return new ResponseEntity<List<Product>>(userCart.getCartProducts(), HttpStatus.OK);
		} else
			return new ResponseEntity<List<Product>>(HttpStatus.UNAUTHORIZED);
	}

	/*****************************
	 * Product Methods
	 *****************************/

	/**
	 * Method to get all products in store
	 * 
	 * @return - List of products in JSON format and HTTP status code: 200
	 */
	@RequestMapping(value = "shoppingCart/product/allProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Show products", notes = "Show all products in store")
	@ApiResponses({ @ApiResponse(code = 200, message = "All products") })
	public ResponseEntity<List<Product>> getAllProducts() {
		ProductDao pd = new ProductDao();
		return new ResponseEntity<List<Product>>(pd.getAllProducts(), HttpStatus.OK);
	}

	/**
	 * Method to find and list products that contains a specific category
	 * 
	 * @param category
	 *            - Category to find
	 * @return - List of products in JSON format and HTTP status code: 200
	 */
	@RequestMapping(value = "shoppingCart/product/productsByCategory/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "List products by category", notes = "Find and list all products that meet a category")
	@ApiResponses({ @ApiResponse(code = 200, message = "List of products") })
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
		ProductDao pd = new ProductDao();
		return new ResponseEntity<List<Product>>(pd.findBycriteria("category", category), HttpStatus.OK);
	}

	/**
	 * Method to find and list products that contains a specific name
	 * 
	 * @param name
	 *            - Name to find
	 * @return - List of products in JSON format and HTTP status code: 200
	 */
	@RequestMapping(value = "shoppingCart/product/productsByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "List products by name", notes = "Find and list all products that meet a name")
	@ApiResponses({ @ApiResponse(code = 200, message = "List of products") })
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
		ProductDao pd = new ProductDao();
		return new ResponseEntity<List<Product>>(pd.findBycriteria("name", name), HttpStatus.OK);
	}
}
