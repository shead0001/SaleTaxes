package seb.taxes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Good> goodsList;

	private BigDecimal sumTaxes = BigDecimal.ZERO;
	private BigDecimal sumPrices = BigDecimal.ZERO;

	public List<Good> getGoodsList() {
		return goodsList;
	}

	public BigDecimal getSumTaxes() {
		return sumTaxes;
	}

	public BigDecimal getSumPrices() {
		return sumPrices;
	}

	public Basket() {
		this.goodsList = new ArrayList<Good>();
	}

	public void add(Good good) {
		this.goodsList.add(good);
		sumTaxes = sumTaxes.add(good.geTotalTax());
		sumPrices = sumPrices.add(good.getFinalPrice());
	}

}
