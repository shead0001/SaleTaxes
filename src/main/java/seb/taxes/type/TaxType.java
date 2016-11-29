package seb.taxes.type;

import java.math.BigDecimal;

/**
 * Enumerazione delle tipologie di tasse applicabili ai beni
 * Ogni tipologia è caratterizzata dal corrispondente 
 * coefficiente da applicare per il calcolo
 * Come da specifiche:
 * "Basic sales tax is applicable at a rate of 10% on all goods,
 *  except books, food, and medical
 * products that are exempt.
 * Import duty is an additional sales tax applicable on all imported goods
 * at a rate of 5%, with no exemptions."
 * 
 * @author caponnetto
 *
 */
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

	private TaxType(final BigDecimal taxValue) {

		this.taxValue = taxValue;

	}

}