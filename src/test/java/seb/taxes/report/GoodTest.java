/**
 * 
 */
package seb.taxes.report;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import seb.taxes.Good;
import seb.taxes.type.GoodType;

/**
 * @author caponnetto
 *
 */
public class GoodTest {

	@Test
    public void tesTCalculateFinalPriceInput1() {
		
    	
		final Good good1 = new Good("book", GoodType.BOOK, false, 1, new BigDecimal("12.49"));
		Assert.assertEquals( new BigDecimal("12.49"), good1.getFinalPrice());
		
		
		Good good2 = new Good("music CD", GoodType.OTHER, false, 1, new BigDecimal("14.99"));
		Assert.assertEquals( new BigDecimal("16.49"), good2.getFinalPrice());
		
		
		Good good3 = new Good("chocolate bar", GoodType.FOOD, false, 1, new BigDecimal("0.85"));
		Assert.assertEquals( new BigDecimal("0.85"), good3.getFinalPrice());
				
	}
}
