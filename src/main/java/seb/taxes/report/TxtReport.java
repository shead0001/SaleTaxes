package seb.taxes.report;

import seb.taxes.Basket;
import seb.taxes.Good;

/**
 * @author caponnetto
 *
 */
public class TxtReport implements Report {

	/**
	 * 
	 */
	private String reportText;

	/**
	 * Implementazione della logica per la generazioene della stringa di output
	 * 
	 * @return
	 */
	public void generate(final Basket basket) {

		reportText = generateString(basket);

	}

	/**
	 * Generazione della stringa di output a partire dall'oggetto Basket
	 * @param basket
	 * @return stringa di output da stampare come output
	 */

	public String generateString(final Basket basket) {
		final String listRowsReportString = genListRowsReport(basket);

		final String finalPartReportString = genFinalPartReport(basket);

		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(listRowsReportString)
				.append(finalPartReportString);

		return stringBuilder.toString();
	}

	/**
	 * Generazione della parte di stringa di output relativa alle righe
	 * 
	 * @param basket
	 * @return parte di stringa di output relativa alle righe
	 */
	private String genListRowsReport(final Basket basket) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (final Good good : basket.getGoodsList()) {
			// stringBuilder.append(good);
			stringBuilder.append(genRowReport(good));

			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}

	/**
	 * Generazione della parte di stringa di output relativa al totale dei prezzi
	 *  e delle tasse
	 * 
	 * @param basket
	 * @return
	 */
	public String genFinalPartReport(final Basket basket) {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Sales Taxes: ").append(basket.getSumTaxes())
				.append("\nTotal: ").append(basket.getSumPrices());

		return stringBuilder.toString();
	}

	/**
	 * Generazione della stringa di output a partire da un oggetto Good
	 * 
	 * @param good
	 * @return
	 */
	private String genRowReport(final Good good) {
		final String imported = good.isImported() ? " imported " : " ";
		return good.getNumber() + imported + good.getName() + ": "
				+ good.getFinalPrice();
	}

	/**
	 * 
	 */
	@Override
	public void print() {
		System.out.print(reportText);
	}

}