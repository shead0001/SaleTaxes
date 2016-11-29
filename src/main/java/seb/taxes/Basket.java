package seb.taxes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo contenete le informazioni ottenute dal parsing dell'input:
 *
 * @author caponnetto
 *
 */
public class Basket {

	/**
	 * lista degli oggetti ottenuti dal parsing delle righe dell'input
	 */
	private List<Good> goodsList;

	/**
	 * somma totale delle tasse
	 */
	private BigDecimal sumTaxes = BigDecimal.ZERO;

	/**
	 * somma totale dei prezzi (con applicate le opportune tasse)
	 */
	private BigDecimal sumPrices = BigDecimal.ZERO;

	public Basket() {
		this.goodsList = new ArrayList<Good>();
	}

	/**
	 * Metodo per l'aggiunta di un nuovo elemento al carrello. Contestualmente
	 * all'aggiunta dell'elemento viene incrementato opportunamente sumTaxes e
	 * sumPrices
	 * 
	 * @param good
	 */
	public void add(final Good good) {
		this.goodsList.add(good);
		sumTaxes = sumTaxes.add(good.geTotalTax());
		sumPrices = sumPrices.add(good.getFinalPrice());
	}

	/**
	 * 
	 * @return lista degli oggetti Good
	 */
	public List<Good> getGoodsList() {
		return goodsList;
	}

	/**
	 * 
	 * @return somma totale delle tasse
	 */
	public BigDecimal getSumTaxes() {
		return sumTaxes;
	}

	/**
	 * 
	 * @return somma totale dei prezzi (con applicate le opportune tasse)
	 */
	public BigDecimal getSumPrices() {
		return sumPrices;
	}

}
