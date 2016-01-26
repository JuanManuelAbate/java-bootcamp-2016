package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements ServiceShoppingCart {

	private List<Product> cartProducts;

	public ShoppingCart() {
		this.cartProducts = new ArrayList<Product>();
	}

	@Override
	public List<Product> getCartProducts() {
		return cartProducts;
	}

	@Override
	public void addProdcut(Product productToAdd) {
		if (cartProducts.contains(productToAdd) == true) {
			cartProducts.remove(productToAdd);
		}
		cartProducts.add(0, productToAdd);

	}

	@Override
	public void deleteProduct(Product productToDelete) throws InvalidInputException {
		if (cartProducts.contains(productToDelete) == false) {
			throw new InvalidInputException("That entry dos not belong to the blog");
		} else {
			cartProducts.remove(productToDelete);

		}

	}

	public int totalProducts() {
		return this.cartProducts.size();
	}

	public Product getTopProduct() {
		return this.cartProducts.get(0);
	}

}
