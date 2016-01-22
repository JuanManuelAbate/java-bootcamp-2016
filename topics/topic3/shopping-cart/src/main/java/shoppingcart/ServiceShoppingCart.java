package shoppingcart;

import java.util.ArrayList;

public interface ServiceShoppingCart {
	ArrayList<Product> getCartProducts();

	void addProdcut(Product productToAdd);

	void deleteProduct(Product productToDelete) throws InvalidInputException;
}
