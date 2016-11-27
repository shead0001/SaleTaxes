package seb.taxes.report;

import seb.taxes.Basket;

/**
 * @author caponnetto
 *
 */
public class ReportGenerator {

	/**
	 * 
	 */
	private Report report;

	/**
	 * 
	 * @param basket
	 * @return
	 */
	public Report generate(final Basket basket) {
		report.generate(basket);
		return report;
	}

	/**
	 * 
	 * @param report
	 */
	public void setReport(final Report report) {
		this.report = report;
	}

	/**
	 * 
	 * @return
	 */
	public Report getReport() {
		return report;
	}
}