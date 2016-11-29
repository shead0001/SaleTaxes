package seb.taxes.report;

/**
 * Facotory per la creazione di un generatore di report
 * @author caponnetto
 *
 */
public class ReportGeneratorFactory {

	/**
	 * 
	 * @return un generatore di report
	 */
	public static ReportGenerator createTxtReportGenerator() {

		final ReportGenerator reportoGen = new ReportGenerator();

		reportoGen.setReport(new TxtReport());

		return reportoGen;
	}
}