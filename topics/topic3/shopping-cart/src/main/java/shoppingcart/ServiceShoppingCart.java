package shoppingcart;

import java.util.List;

public interface ServiceShoppingCart {
	List<Product> getCartProducts();

	void addProdcut(Product productToAdd);

	void deleteProduct(Product productToDelete) throws InvalidInputException;
}
