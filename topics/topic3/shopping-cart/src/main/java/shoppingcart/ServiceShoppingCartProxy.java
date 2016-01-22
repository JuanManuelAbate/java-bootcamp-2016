package shoppingcart;

import java.util.ArrayList;

public class ServiceShoppingCartProxy implements ServiceShoppingCart {

	private ServiceShoppingCart implementation;

	public ServiceShoppingCartProxy(ServiceShoppingCart imp) {
		this.implementation = imp;
	}

	@Override
	public ArrayList<Product> getCartProducts() {
		return implementation.getCartProducts();
	}

	@Override
	public void addProdcut(Product productToAdd) {
		implementation.addProdcut(productToAdd);
	}

	@Override
	public void deleteProduct(Product productToDelete) throws InvalidInputException {
		implementation.deleteProduct(productToDelete);
	}

}
