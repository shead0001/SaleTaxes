package seb.taxes;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import seb.taxes.Basket;
import seb.taxes.Good;
import seb.taxes.data.Inputs;
import seb.taxes.parsing.Parser;
import seb.taxes.parsing.ParserImpl;

/**
 * Testing del parsing della stringa di input per il popolamento dell'oggetto
 * Basket
 * 
 * @author caponnetto
 */
public class ParserTest {

	private Parser parser;

	@Before
	public void initialize() {
		parser = new ParserImpl();
	}

	/**
	 * Input 1
	 */
	@Test
	public void genereTextReportFromBasketInput1() {

		final Basket basket = parser.parse(Inputs.input1);

		final Good good1 = basket.getGoodsList().get(0);
		Assert.assertEquals(1, good1.getNumber());
		Assert.assertEquals("book", good1.getName());
		Assert.assertEquals(new BigDecimal("12.49"), good1.getFinalPrice());
		Assert.assertEquals(false, good1.isImported());

		final Good good2 = basket.getGoodsList().get(1);
		Assert.assertEquals(1, good2.getNumber());
		Assert.assertEquals("music CD", good2.getName());
		Assert.assertEquals(new BigDecimal("16.49"), good2.getFinalPrice());
		Assert.assertEquals(false, good2.isImported());

		Assert.assertEquals(new BigDecimal("1.50"), basket.getSumTaxes());
		Assert.assertEquals(new BigDecimal("29.83"), basket.getSumPrices());

	}

	/**
	 * Input 2
	 */
	@Test
	public void genereTextReportFromBasketInput2() {

		final Basket basket = parser.parse(Inputs.input2);

		final Good good1 = basket.getGoodsList().get(0);
		Assert.assertEquals(1, good1.getNumber());
		Assert.assertEquals("box of chocolates", good1.getName());
		Assert.assertEquals(new BigDecimal("10.50"), good1.getFinalPrice());
		Assert.assertEquals(true, good1.isImported());

		final Good good2 = basket.getGoodsList().get(1);
		Assert.assertEquals(1, good2.getNumber());
		Assert.assertEquals("bottle of perfume", good2.getName());
		Assert.assertEquals(new BigDecimal("54.65"), good2.getFinalPrice());
		Assert.assertEquals(true, good2.isImported());

		Assert.assertEquals(new BigDecimal("7.65"), basket.getSumTaxes());
		Assert.assertEquals(new BigDecimal("65.15"), basket.getSumPrices());
	}

}