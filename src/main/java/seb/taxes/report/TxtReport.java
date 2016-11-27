package seb.taxes.report;

import seb.taxes.Basket;
import seb.taxes.Good;

/**
 * @author caponnetto
 *
 */
public class TxtReport implements Report {

	String reportText;

	/**
	 * 
	 */
	public TxtReport() {

	}

	/**
	 * @return
	 * 
	 */
	public void generate(Basket basket) {

		reportText = generateString(basket);
		return;

	}

	/**
	 * 
	 * @param basket
	 * @return
	 */

	public String generateString(Basket basket) {
		final String listRowsReportString = genListRowsReport(basket);

		String finalPartReportString = genFinalPartReport(basket);

		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(listRowsReportString)
				.append(finalPartReportString);

		return stringBuilder.toString();
	}

	/**
	 * 
	 * @param basket
	 * @return
	 */
	public String genListRowsReport(Basket basket) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (Good good : basket.getGoodsList()) {
			// stringBuilder.append(good);
			stringBuilder.append(genRowReport(good));

			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	/**
	 * 
	 * @param basket
	 * @return
	 */
	public String genFinalPartReport(Basket basket) {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Sales Taxes: ").append(basket.getSumTaxes())
				.append("\n").append("Total: ").append(basket.getSumPrices());

		String finalPartReportString = stringBuilder.toString();
		return finalPartReportString;
	}

	/**
	 * 
	 * @param good
	 * @return
	 */
	public String genRowReport(Good good) {
		String imported = good.isImported() ? " imported " : " ";
		return good.getNumber() + imported + good.getName() + ": "
				+ good.getFinalPrice();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see seb.taxes.report.Report#print()
	 */
	@Override
	public void print() {
		System.out.print(reportText);
	}

}