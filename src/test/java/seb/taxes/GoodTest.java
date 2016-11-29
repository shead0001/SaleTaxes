/**
 * 
 */
package seb.taxes;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import seb.taxes.Good;
import seb.taxes.type.GoodType;

/**
 * Testing del calcolo del prezzo finale (applicando le opportune tasse)
 * 
 * @author caponnetto
 */
public class GoodTest {

	/**
	 * Testing del calcolo del prezzo finale sui Beni ottenuti dall'output 1
	 */
	@Test
	public void testCalculateFinalPriceInput1() {

		final Good good1 = new Good("book", GoodType.BOOK, false, 1,
				new BigDecimal("12.49"));
		Assert.assertEquals(new BigDecimal("12.49"), good1.getFinalPrice());

		final Good good2 = new Good("music CD", GoodType.OTHER, false, 1,
				new BigDecimal("14.99"));
		Assert.assertEquals(new BigDecimal("16.49"), good2.getFinalPrice());

		final Good good3 = new Good("chocolate bar", GoodType.FOOD, false, 1,
				new BigDecimal("0.85"));
		Assert.assertEquals(new BigDecimal("0.85"), good3.getFinalPrice());

	}
}
