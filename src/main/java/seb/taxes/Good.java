package seb.taxes;

import java.math.BigDecimal;

import seb.taxes.type.GoodType;
import seb.taxes.type.TaxType;

public class Good {

	private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");

	private String name;
	private GoodType type;
	private boolean imported;
	private int number;
	private BigDecimal price;

	public Good(String name, GoodType type, boolean imported, int number,
			BigDecimal price) {
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

	public void setName(String name) {
		this.name = name;
	}

	public GoodType getType() {
		return type;
	}

	public void setType(GoodType type) {
		this.type = type;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getImportTax() {
		BigDecimal importTax = new BigDecimal(0);
		if (this.isImported()) {
			importTax = price.multiply(TaxType.IMPORT.getTaxValue());
		}
		return importTax;
	}

	public BigDecimal getSaleTax() {
		BigDecimal saleTax = BigDecimal.ZERO;
		saleTax = price.multiply(type.getSaleTax());
		return saleTax;
	}

	public BigDecimal geTotalTax() {

		return roundOff(getImportTax().add(getSaleTax()));
	}

	public BigDecimal getFinalPrice() {
		return price.add(geTotalTax());
	}

	private BigDecimal roundOff(BigDecimal value) {
		value = value.divide(ROUND_FACTOR);
		value = new BigDecimal(Math.ceil(value.doubleValue()));
		value = value.multiply(ROUND_FACTOR);
		return value;
	}

}
