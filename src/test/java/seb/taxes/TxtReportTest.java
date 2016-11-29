package seb.taxes;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import seb.taxes.Basket;
import seb.taxes.Good;
import seb.taxes.data.Results;
import seb.taxes.report.ReportGenerator;
import seb.taxes.report.ReportGeneratorFactory;
import seb.taxes.report.TxtReport;
import seb.taxes.type.GoodType;

/**
 * Testing del corretto output a partire da un oggetto Basket valorizzato
 * manualmente
 * 
 * @author caponnetto
 *
 */
public class TxtReportTest {

	private Basket basket;

	@Before
	public void initialize() {
		basket = new Basket();
	}

	/**
	 * Elementi Good dell'Input 1
	 */
	@Test
	public void genereTextReportFromBasket1() {

		basket.add(new Good("book", GoodType.BOOK, false, 1, new BigDecimal(
				"12.49")));
		basket.add(new Good("music CD", GoodType.OTHER, false, 1,
				new BigDecimal("14.99")));
		basket.add(new Good("chocolate bar", GoodType.FOOD, false, 1,
				new BigDecimal("0.85")));

		final ReportGenerator gen = ReportGeneratorFactory
				.createTxtReportGenerator();
		final String risultato1 = ((TxtReport) (gen.generate(basket)))
				.generateString(basket);

		Assert.assertEquals(Results.output1, risultato1);

	}

}