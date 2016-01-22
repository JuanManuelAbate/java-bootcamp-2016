package shoppingcart;

import java.util.ArrayList;

public class ShoppingCart implements ServiceShoppingCart {

	private ArrayList<Product> cartProducts;
	int totalProducts;

	public ShoppingCart() {
		this.cartProducts = new ArrayList<Product>();
		this.totalProducts = 0;
	}

	@Override
	public ArrayList<Product> getCartProducts() {
		return cartProducts;
	}

	@Override
	public void addProdcut(Product productToAdd) {
		cartProducts.add(productToAdd);
		totalProducts = totalProducts + 1;

	}

	@Override
	public void deleteProduct(Product productToDelete) throws InvalidInputException {
		if (cartProducts.contains(productToDelete) == false) {
			throw new InvalidInputException("That entry dos not belong to the blog");
		} else {
			cartProducts.remove(productToDelete);
			totalProducts = totalProducts - 1;
		}

	}
	
	public int totalProducts(){
		return this.totalProducts;
	}

}
