package shoppingcart;

import java.util.ArrayList;

import javax.jws.WebService;

@WebService
public class ServiceShoppingCartWebService implements ServiceShoppingCart {

	ServiceShoppingCart imp = new ShoppingCart();

	@Override
	public ArrayList<Product> getCartProducts() {
		return imp.getCartProducts();
	}

	@Override
	public void addProdcut(Product productToAdd) {
		imp.addProdcut(productToAdd);

	}

	@Override
	public void deleteProduct(Product productToDelete) throws InvalidInputException {
		imp.deleteProduct(productToDelete);

	}

}
