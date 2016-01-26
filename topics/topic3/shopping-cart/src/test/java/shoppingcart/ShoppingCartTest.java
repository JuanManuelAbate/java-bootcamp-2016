package shoppingcart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

	ShoppingCart testShoppingCart = new ShoppingCart();
	Product newProduct = new Product(0, "newProduct");
	Product otherProduct = new Product(1, "otherProduct");

	@Test
	public void whenOneProductIsAddedThenReturnTheTotalProductsOfCartPlusOne() {
		int totalProducts = testShoppingCart.totalProducts();
		testShoppingCart.addProdcut(newProduct);
		Assert.assertEquals(totalProducts + 1, testShoppingCart.totalProducts());
	}

	@Test
	public void whenOneProductIsDeletedThenReturnThetotalProductsOfCartLessOne() {
		testShoppingCart.addProdcut(newProduct);
		int totalProducts = testShoppingCart.totalProducts();
		try {
			testShoppingCart.deleteProduct(newProduct);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(totalProducts - 1, testShoppingCart.totalProducts());
	}

	@Test(expected = InvalidInputException.class)
	public void whenAProductThatNotBelongToTheCartIsSentToDeleteThenExceptionIsThrown() throws InvalidInputException {
		testShoppingCart.deleteProduct(newProduct);
	}

	@Test
	public void whenTheListOfProductsAreRequestedThenReturnTheFullListOfProducts() {
		testShoppingCart.addProdcut(newProduct);
		testShoppingCart.addProdcut(otherProduct);
		List<Product> totalProducts = testShoppingCart.getCartProducts();
		Assert.assertEquals(2, totalProducts.size());
	}

	@Test
	public void whenNewProductIsAddedThenAddThatProductOnTheTopOfcart() {
		testShoppingCart.addProdcut(newProduct);
		Assert.assertEquals(testShoppingCart.getTopProduct(), newProduct);
	}

	@Test
	public void whenAProductThatAlreadyExistsInCartIsAddedThenMoveThatProductToTop() {
		testShoppingCart.addProdcut(newProduct);
		testShoppingCart.addProdcut(otherProduct);
		testShoppingCart.addProdcut(newProduct);
		Assert.assertEquals(2, testShoppingCart.totalProducts());
		Assert.assertEquals(testShoppingCart.getTopProduct(), newProduct);
	}

}
