package seb.taxes.report;

/**
 * @author caponnetto
 *
 */
public class ReportGeneratorFactory {

	/**
	 * 
	 * @return
	 */
	public static ReportGenerator createTxtReportGenerator() {

		final ReportGenerator reportoGen = new ReportGenerator();

		reportoGen.setReport(new TxtReport());

		return reportoGen;
	}
}