package seb.taxes.type;

import java.math.BigDecimal;

public enum TaxType {

	SALE(new BigDecimal("0.1")), IMPORT(new BigDecimal("0.05"));

	/**
     * 
     */
	private BigDecimal taxValue;

	/**
	 * 
	 * @return
	 */
	public BigDecimal getTaxValue() {
		return taxValue;
	}

	private TaxType(BigDecimal taxValue) {

		this.taxValue = taxValue;

	}

}