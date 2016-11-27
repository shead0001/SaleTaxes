package seb.taxes.report;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import seb.taxes.Basket;
import seb.taxes.Good;
import seb.taxes.report.data.Inputs;
import seb.taxes.report.data.Results;
import seb.taxes.type.GoodType;

/**
 * @author caponnetto
 *
 */
public class TxtReportTest 
{
	@Test
    public void genereTextReportFromBasket() {
		Basket basket= new Basket();
		basket.add(new Good("book", GoodType.BOOK, false, 1, new BigDecimal("12.49")));
		basket.add(new Good("music CD", GoodType.OTHER, false, 1, new BigDecimal("14.99")));
		basket.add(new Good("chocolate bar", GoodType.FOOD, false, 1, new BigDecimal("0.85")));
		
		ReportGenerator gen = ReportGeneratorFactory.createTxtReportGenerator();
		String risultato1 = ((TxtReport)(gen.generate(basket))).generateString(basket);
		
		
		Assert.assertEquals( Results.output1 , risultato1);
		
	}
	
}