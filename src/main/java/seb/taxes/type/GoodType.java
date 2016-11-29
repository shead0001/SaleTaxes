package seb.taxes.type;

import java.math.BigDecimal;

/**
 * Enumerazione delle tipologie dei beni
 * Ogni tipologia è caratterizzata dal corrispondente 
 * coefficiente da applicare per il calcolo delle tasse
 * Come da specifiche:
 * "Basic sales tax is applicable at a rate of 10% on all goods, 
 *  except books, food, and medical
 *  products that are exempt."
 * 
 * @author caponnetto
 *
 */
public enum GoodType {

	BOOK(BigDecimal.ZERO), FOOD(BigDecimal.ZERO), MEDICAL(BigDecimal.ZERO), OTHER(
			TaxType.SALE.getTaxValue());

	/**
	 * 
	 */
	private BigDecimal saleTax;

	public BigDecimal getSaleTax() {
		return saleTax;
	}

	private GoodType(final BigDecimal saleTax) {

		this.saleTax = saleTax;

	}

}