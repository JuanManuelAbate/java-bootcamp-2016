package shoppingcart;

public class ServiceShoppingCartFactory {
	private ServiceShoppingCartFactory() {
	}

	public static ServiceShoppingCart getLocalService() {
		return new ShoppingCart();
	}

	public static ServiceShoppingCart getRemoteServiceUsingWebService() {
		return new ServiceShoppingCartProxy(new ServiceShoppingCartWebServiceClient());
	}
}
