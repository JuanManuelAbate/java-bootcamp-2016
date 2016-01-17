package points123;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSum() {
		Calculator calc = new Calculator();
		int result = calc.Sum(1, 1);
		Assert.assertEquals(result, 2);
	}

	@Test
	public void testSubstract() {
		Calculator calc = new Calculator();
		int result = calc.Substract(1, 1);
		Assert.assertEquals(result, 0);
	}
}
