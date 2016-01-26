package shoppingcart;

import java.util.List;

public class ServiceShoppingCartWebServiceClient implements ServiceShoppingCart {

	ServiceShoppingCart webService;

	public ServiceShoppingCartWebServiceClient() {
		// webService = code to get the reference to Service A from the
		// webservice call
	}

	@Override
	public List<Product> getCartProducts() {
		return webService.getCartProducts();
	}

	@Override
	public void addProdcut(Product productToAdd) {
		webService.addProdcut(productToAdd);

	}

	@Override
	public void deleteProduct(Product productToDelete) throws InvalidInputException {
		webService.deleteProduct(productToDelete);

	}

}
