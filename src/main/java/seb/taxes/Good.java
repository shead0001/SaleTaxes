package seb.taxes;

import java.math.BigDecimal;

import seb.taxes.type.GoodType;
import seb.taxes.type.TaxType;

/**
 * Pojo contenete le informazioni caratterizzanti il Bene Inoltresono presenti i
 * due metodi: - geTotalTax() che restituisce il totale delle tasse da applicare
 * al prezzo del bene - getImportTax() che restituisce il prezzo finale incluse
 * le eventuali tasse applicate
 *
 * @author caponnetto
 *
 */
public class Good {

	/**
	 * Fattore da applicare per l'arrotondamento
	 */
	private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");

	/**
	 * Nome del Bene
	 */
	private String name;

	/**
	 * Tipologia del Bene
	 */
	private GoodType type;

	/**
	 * Flag Bene importato
	 */
	private boolean imported;

	/**
	 * Quantità
	 */
	private int number;

	/**
	 * Prezzo del bene
	 */
	private BigDecimal price;

	public Good(final String name, final GoodType type, final boolean imported,
			final int number, final BigDecimal price) {
		this.name = name;
		this.type = type;
		this.imported = imported;
		this.number = number;
		this.price = price;
	}

	public Good() {
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public GoodType getType() {
		return type;
	}

	public void setType(final GoodType type) {
		this.type = type;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(final boolean imported) {
		this.imported = imported;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(final int number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	/**
	 * restituisce la tassa base da sommare al prezzo iniziale (il coefficiente
	 * da applicare dipende dalla tipologia di bene) Come da specifiche: "Basic
	 * sales tax is applicable at a rate of 10% on all goods, except books,
	 * food, and medical products that are exempt."
	 */
	private BigDecimal getSaleTax() {
		BigDecimal saleTax = BigDecimal.ZERO;
		saleTax = price.multiply(type.getSaleTax());
		return saleTax;
	}

	/**
	 * Restituisce il totale delle tasse da applicare
	 * 
	 * @return Tasse da applicare al prezzo netto
	 */
	public BigDecimal geTotalTax() {

		return roundOff(getImportTax().add(getSaleTax()));
	}

	/**
	 * restituisce la tassa da sommare al prezzo iniziale nel caso in cui il
	 * Good sia importato Come da specifiche: "Import duty is an additional
	 * sales tax applicable on all imported goods at a rate of 5%, with no
	 * exemptions."
	 */
	private BigDecimal getImportTax() {
		BigDecimal importTax = BigDecimal.ZERO;
		if (this.isImported()) {
			importTax = price.multiply(TaxType.IMPORT.getTaxValue());
		}
		return importTax;
	}

	/**
	 * Restituisce il prezzo finale incluse le eventuali tasse applicate
	 * 
	 * @return Il prezzo finale del bene
	 */
	public BigDecimal getFinalPrice() {
		return price.add(geTotalTax());
	}

	private BigDecimal roundOff(final BigDecimal value) {
		BigDecimal valueCalculated = value.divide(ROUND_FACTOR);
		valueCalculated = new BigDecimal(Math.ceil(valueCalculated
				.doubleValue()));
		valueCalculated = valueCalculated.multiply(ROUND_FACTOR);
		return valueCalculated;
	}

}
