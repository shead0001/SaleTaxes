package seb.taxes.type;

import java.math.BigDecimal;

public enum GoodType {

	BOOK(BigDecimal.ZERO), FOOD(BigDecimal.ZERO), MEDICAL(BigDecimal.ZERO), OTHER(
			TaxType.SALE.getTaxValue());

	private BigDecimal saleTax;

	public BigDecimal getSaleTax() {
		return saleTax;
	}

	private GoodType(BigDecimal saleTax) {

		this.saleTax = saleTax;

	}

}