package seb.taxes;

import seb.taxes.parsing.Parser;
import seb.taxes.parsing.ParserImpl;
import seb.taxes.report.ReportGenerator;
import seb.taxes.report.ReportGeneratorFactory;

/**
 * Classe principale da istanziare per il processamento dell'input e la stampa
 * del risultato finale
 * 
 * @author caponnetto
 */
public class Processor {

	public Processor() {

	}

	/**
	 * Il metodo stampa su console il risultato finale
	 * 
	 * @param input
	 *            esto di inpute che si vuole processare
	 */
	public void execute(final String input) {
		final Parser parser = new ParserImpl();
		final Basket basket = parser.parse(input);
		final ReportGenerator gen = ReportGeneratorFactory
				.createTxtReportGenerator();
		gen.generate(basket).print();

	}

}
